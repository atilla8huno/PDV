package br.com.devschool.produto.relatorio;

import br.com.devschool.util.GeradorRelatorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ATILLA
 */
public class ProdutoReport {

    public static void main(String[] args) {
        GeradorRelatorio gerador = new GeradorRelatorio();
        
        Map<String, Object> parametros = new HashMap();
        List<Map<String, Object>> itens = new ArrayList();
        Map<String, Object> item1 = new HashMap();
        Map<String, Object> item2 = new HashMap();
        item1.put("nome", "Átilla");
        item2.put("nome", "Barros");
        itens.add(item1);
        itens.add(item2);
        
        String arquivo = "src/resources/jasper/FirstReport.jrxml";
        
        gerador.gerarRelatorioDesktop(arquivo, itens, parametros);
    }
}
