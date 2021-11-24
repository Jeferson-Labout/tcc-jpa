/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jefson
 */
public class PrecoRender extends DefaultTableCellRenderer{
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
       super.getTableCellRendererComponent(jtable, value, bln, bln1, i, i1);       
    
    if(value instanceof BigDecimal){
    this.setText(nf.format((BigDecimal)value));
    
    }
    
    
        return this;
    }
    
}
