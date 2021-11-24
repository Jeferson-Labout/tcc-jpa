/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jefson
 */
public class JasperService {

    private final Map<String, Object> params = new LinkedHashMap<>();

    public void addParams(String key, Object value) {
        this.params.put(key, value);

    }

     public void abrirPontoJasper(String jasperFile, Connection connection) {
       
        try {
             InputStream is = getClass().getClassLoader().getResourceAsStream(jasperFile);
            JasperPrint print = JasperFillManager.fillReport(is, this.params, connection);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
        } catch (JRException e) {
        }
        
    }
    
         public void exportarParaPDF(String jrxml, Connection connection,String saida) throws FileNotFoundException {
        JasperReport report = compilarJrxml(jrxml);
        try {
            OutputStream out = new FileOutputStream(saida);
            JasperPrint print = JasperFillManager.fillReport(report, this.params, connection);
            JasperExportManager.exportReportToPdfStream(print, out);
        } catch (JRException | FileNotFoundException e) {
        }
        
    }
     
    
    public void abrirJasperViewer(String jrxml, Connection connection) {
        JasperReport report = compilarJrxml(jrxml);
        try {
            JasperPrint print = JasperFillManager.fillReport(report, this.params, connection);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
        } catch (JRException e) {
        }
        
    }

    private JasperReport compilarJrxml(String arquivo) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(arquivo);
        try {
            return JasperCompileManager.compileReport(is);
        } catch (JRException e) {
        }
        return null;

    }

}
