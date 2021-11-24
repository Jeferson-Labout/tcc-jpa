/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JFrame;

/**
 *
 * @author Jefson
 */
public class Utilitarios {

    public void InserirIcon(JFrame frm) {

        try {
//            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/icon2_1.png"));
            frm.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/icon2_1.png")).getImage());
        } catch (Exception e) {
        }

    }

    public void InserirTitulo(JFrame frm) {

        try {
//            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/icon2_1.png"));
            frm.setTitle("iROTAS");
        } catch (Exception e) {
        }

    }

}
