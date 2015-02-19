package br.com.devschool.util;

import br.com.devschool.produto.servico.ProdutoServico;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 * @author ATILLA
 */
public class JasperLegadoInputStream extends FilterInputStream {

    /**
     * @param is        O InputStream desenvolvido nas versões mais recentes
     */
    public JasperLegadoInputStream(final InputStream is) {
        super(convertToLegacyFormat(is));
    }

    private static InputStream convertToLegacyFormat(final InputStream is) {
        Document document = convertInputStreamToDOM(is);
        document.getDocumentElement().removeAttribute("xmlns");
        document.getDocumentElement().removeAttribute("xmlns:xsi");
        document.getDocumentElement().removeAttribute("xsi:schemaLocation");
        document.getDocumentElement().removeAttribute("uuid");
        
        String source = addDocTypeAndConvertDOMToString(document);
        
        Logger.getLogger(JasperLegadoInputStream.class.getName()).log(Level.INFO, source);
        
        source = removeAttributeFromTag(source, "band", "splitType");
        source = removeAttributeFromTag(source, "reportElement", "uuid");
        source = addAttributeToTag(source, "imageExpression", "class=\"java.awt.Image\"");
        
        Logger.getLogger(JasperLegadoInputStream.class.getName()).log(Level.INFO, "\n\n\n=====\n\n\n\n" +source);
        
        return convertStringToInputStream(source);
    }
    
    private static String removeAttributeFromTag(String source, String tag, String attr) {
        return source.replaceAll("(<"+tag+" .*)("+attr+"=\"[^\"]*\")", "$1");
    }
    private static String addAttributeToTag(String source, String tag, String attr) {
        return source.replaceAll("(<"+tag+")", "$1 "+attr);
    }

    private static Document convertInputStreamToDOM(final InputStream is){
        Document document = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(bis);
        } catch (Exception ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }

        return document;
    }

    private static String addDocTypeAndConvertDOMToString(Document document){

        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = null;
        try {
            trans = transfac.newTransformer();
        } catch (TransformerConfigurationException ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }

        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "//JasperReports//DTD Report Design//EN");
        trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd");

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(document);
        try {
            trans.transform(source, result);
        } catch (TransformerException ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }

        return sw.toString();
    }

    private static InputStream convertStringToInputStream(String template) {
        return new ByteArrayInputStream(template.getBytes());
    }
}