package br.com.devschool.util;

import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author ATILLA
 */
public class GeradorRelatorio {
    
    /**
     * Path das libs: ..\Jaspersoft\iReport-5.5.1\ireport\modules\ext
     */
    
    public void gerarRelatorioDesktop(String arquivo, Collection<?> itens, Map<String, Object> parametros) {
        try {
            JRDataSource jrds = new JRBeanCollectionDataSource(itens);
            JasperReport jasperReport = JasperCompileManager.compileReport(arquivo);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(itens));
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
