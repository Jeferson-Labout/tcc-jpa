/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import connection.JdbcConnection;
import entity.Rota;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.JasperService;
import util.Utilitarios;

/**
 *
 * @author Jefson
 */
public final class JframeMonitor extends javax.swing.JFrame {

    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatador2 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Timer timer1 = new java.util.Timer();
    java.util.Timer timer2 = new java.util.Timer();
    DecimalFormat df2 = new DecimalFormat("0.00");
    DecimalFormat df3 = new DecimalFormat("0.000");
    EntityManagerFactory emf;
    EntityManager em;

    /**
     * Creates new form JframeMonitor
     */
    public JframeMonitor() {
        initComponents();
        Utilitarios util = new Utilitarios();
        util.InserirIcon(this);
        util.InserirTitulo(this);
        emf = Persistence.createEntityManagerFactory("TCC_JPAPU");
        em = emf.createEntityManager();
        this.ComboBoxColetor.setSelectedIndex(-1);
        AtualizacaoColetasAutomatica();
        atualizaTabelaMonitor();

    }

    public void soma() {
        String status = "'N','M'";

        String datai = formatador2.format(data) + " 00:00:00";
        String datai2 = formatador2.format(data) + " 23:59:59";

        String sql = "SELECT *FROM Rota  WHERE 1=1 ";

        if ("'N','M'".equals(status)) {
            sql += " and rotastatus in (" + status + ")";

        }
        if (!"".equals(datai)) {
            sql += " and rotadatacoleta BETWEEN '" + datai + "'";

        }

        if (!"".equals(datai2)) {
            sql += " and '" + datai2 + "'";

        }
        List<Rota> rotas = em.createNativeQuery(sql, Rota.class).getResultList();

        for (Rota rota : rotas) {

            double valorExer = 0;
            double valorTotal = 0;
            double valorFixo = Double.parseDouble(rota.getRotavalorfixo().toString());

            double qdtExer = 0;

            double qtdContradata = Double.parseDouble(rota.getRotacliqtdecontratada().toString());
            double qtdColetada = Double.parseDouble(rota.getRotaqtde().toString());
            double valorExedente = Double.parseDouble(rota.getRotavalorexcedente().toString());
            if (qtdColetada > qtdContradata) {
                qdtExer = qtdColetada - qtdContradata;
                valorExer = valorExedente * qdtExer;
                valorTotal = valorFixo + valorExer;

                BigDecimal qdtexcesso = new BigDecimal(qdtExer);
                BigDecimal valorexcesso = new BigDecimal(valorExer);
                BigDecimal valotfinal = new BigDecimal(valorTotal);
                em.getTransaction().begin();

                rota = em.find(Rota.class, Integer.parseInt(rota.getRotaid().toString()));

                rota.setRotaqtdeexcedente(qdtexcesso);

                rota.setRotavalortotal(valotfinal);

                em.persist(rota);
                em.flush();
                //retorna o ultimo

                em.getTransaction().commit();

            }

        }

    }

    public void AtualizacaoColetasAutomatica() {
        DefaultTableModel model = (DefaultTableModel) this.tblMonitor.getModel();
        System.out.println("Serviço de Atualização iniciado...");
        int delay = 0;   // delay de 0 seg.
        int interval = 5000;  // intervalo de 1 seg.       

        timer1.scheduleAtFixedRate(new TimerTask() {
            int id = 1;

            @Override
            public void run() {
                atualizaTabelaMonitor();
                soma();
                model.removeRow(0);
                System.out.println("Serviço de Atualização iniciado...");
            }
        }, delay, interval);

    }

    public void atualizaTabelaMonitor() {

        DefaultTableModel model = (DefaultTableModel) this.tblMonitor.getModel();
        String status = "'N','M'";

        String datai = formatador2.format(data) + " 00:00:00";
        String datai2 = formatador2.format(data) + " 23:59:59";

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        String coletor = "";
        if (ComboBoxColetor.getSelectedIndex() != -1) {
            coletor = ComboBoxColetor.getSelectedItem().toString();
        }
        //faz select de todos os dados e armazena em uma lista
        String sql = "SELECT *FROM Rota  WHERE 1=1 ";
        if (!"".equals(coletor)) {
            sql += " and rotaclinomemotorista ='" + coletor + "'";

        }
        if ("'N','M'".equals(status)) {
            sql += " and rotastatus IN (" + status + ")";
        } else {
        }
        if (!"".equals(datai)) {
            sql += " and rotadatacoleta BETWEEN '" + datai + "'";

        }

        if (!"".equals(datai2)) {
            sql += " and '" + datai2 + "'";

        }

        List<Rota> rotas = em.createNativeQuery(sql, Rota.class).getResultList();
        //pega todos os contato e adiciona na tebela.
        for (int i = 0; i < rotas.size(); i++) {

            model.addRow(new Object[]{
                ((Rota) rotas.get(i)).getRotaid(),
                ((Rota) rotas.get(i)).getRotaclinome(),
                ((Rota) rotas.get(i)).getRotaclinomemotorista(),
                ((Rota) rotas.get(i)).getRotagdrdescricao(),
                ((Rota) rotas.get(i)).getRotaqtde(),
                ((Rota) rotas.get(i)).getRotaclinomemotorista(),
                new SimpleDateFormat("dd/MM/yyyy").format(((Rota) rotas.get(i)).getRotadatacoleta().getTime()),
                ((Rota) rotas.get(i)).getRotavalortotal()

            });

        }

        NumberFormat z = NumberFormat.getCurrencyInstance();

        double total = 0;
        for (int i = 0; i < tblMonitor.getRowCount(); i++) {

            double valor = Double.parseDouble(tblMonitor.getValueAt(i, 7).toString());
            total += valor;

        }

        double qtdtotal = 0;
        for (int i = 0; i < tblMonitor.getRowCount(); i++) {
            double qdt = Double.parseDouble(tblMonitor.getValueAt(i, 4).toString());
            qtdtotal += qdt;

        }

        double media = 0;
        media = total / qtdtotal;
        lblTotal.setText(String.valueOf(z.format(total)));
        lbl_qtdTotal.setText(String.valueOf(df2.format(qtdtotal)));
        lbl_Media.setText(String.valueOf(df2.format(media)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        TCC_JPAPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("TCC_JPAPU").createEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : TCC_JPAPUEntityManager.createQuery("SELECT c FROM Cliente c WHERE c.clitipocad = 3 ORDER BY c.cliid");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lbl_qtdTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonitor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxColetor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lbl_Media = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        precoRender1 = new util.PrecoRender();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Monitor de Coletas Mobile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_qtdTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_qtdTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_qtdTotal.setText("0,000");
        lbl_qtdTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Qtde Total"));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0,00");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        tblMonitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Razão", "Fantasia", "Cidade", "Qtde", "Coletor", "Data/Hora", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMonitor);
        if (tblMonitor.getColumnModel().getColumnCount() > 0) {
            tblMonitor.getColumnModel().getColumn(7).setCellRenderer(precoRender1);
        }

        jLabel2.setText("Coletor:");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${resultList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteQuery, eLProperty, ComboBoxColetor);
        bindingGroup.addBinding(jComboBoxBinding);

        ComboBoxColetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxColetorActionPerformed(evt);
            }
        });
        ComboBoxColetor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxColetorKeyPressed(evt);
            }
        });

        jLabel3.setText("Média por KG:");

        lbl_Media.setText("0,00");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisa_32.png"))); // NOI18N
        btnPesquisar.setText("Consultar");
        btnPesquisar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Imprimir_32.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxColetor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Media, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_qtdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblTotal, lbl_qtdTotal});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnImprimir, btnPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_qtdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotal))
                            .addComponent(jLabel2)
                            .addComponent(ComboBoxColetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir))))
                .addGap(1, 1, 1)
                .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Media, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ComboBoxColetor, lblTotal, lbl_qtdTotal});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnImprimir, btnPesquisar});

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizaTabelaMonitor();
        soma();
    }//GEN-LAST:event_formWindowOpened

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        atualizaTabelaMonitor();

    }//GEN-LAST:event_btnPesquisarActionPerformed
    private static void abrirJrxml(String numero) {

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();
        service.abrirJasperViewer("relatorios/Coletas_Diarias-" + numero + ".jrxml", connection);
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JframeListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void abrirPontoJasper(String numero) {

        String coletor = "";
        if (ComboBoxColetor.getSelectedIndex() != -1) {
            coletor = ComboBoxColetor.getSelectedItem().toString();
        }

        Connection connection = JdbcConnection.connection();
        JasperService service = new JasperService();

        if (!"".equals(coletor)) {
            service.addParams("MOTORISTA", coletor);

        }
        service.abrirPontoJasper("relatorios/Coletas_Diarias-" + numero + ".jasper", connection);
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JframeListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Imprimir Relatório Coleta diaria", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            abrirPontoJasper("01");
//            abrirJrxml("01");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void ComboBoxColetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxColetorActionPerformed

    }//GEN-LAST:event_ComboBoxColetorActionPerformed

    private void ComboBoxColetorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxColetorKeyPressed
        if (evt.getKeyCode() == evt.VK_DELETE) {
            this.ComboBoxColetor.setSelectedIndex(-1);
            atualizaTabelaMonitor();
        }
    }//GEN-LAST:event_ComboBoxColetorKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JframeMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeMonitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ComboBoxColetor;
    private javax.persistence.EntityManager TCC_JPAPUEntityManager;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnPesquisar;
    private java.util.List<entity.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbl_Media;
    private javax.swing.JLabel lbl_qtdTotal;
    private util.PrecoRender precoRender1;
    private javax.swing.JTable tblMonitor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
