/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import util.Utilitarios;

/**
 *
 * @author Jefson
 */
public class JframeListaClientes extends javax.swing.JFrame {

    JframeInserirColeta c;

    /**
     * Creates new form JframeListaClientes
     */
    public JframeListaClientes() {
        initComponents();
        Utilitarios util = new Utilitarios();
        util.InserirIcon(this);
        util.InserirTitulo(this);
        emf = Persistence.createEntityManagerFactory("TCC_JPAPU");
        em = emf.createEntityManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(0, 102, 0));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Lista de Clientes ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Cod.:");

        jLabel2.setText("Razão:");

        jButton1.setText("Pesquisar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRazao, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtRazao))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "NUMERO CONTRATO", "Rota", "Razão", "Fantasia", "CPF/CNPJ", "Cidade", "UF", "TIPO", "BAIRRO", "Fone", "LATITUDE", "LONGITUDE", "NUMERO", "ENDERECO", "E-mail", "VALORFIXO", "VALOREXCEDENTE", "QTDECONTRATADA", "Cod Rota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(1).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(1).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(8).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(8).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(9).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(9).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(11).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(11).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(11).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(12).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(12).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(12).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(13).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(13).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(13).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(14).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(14).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(14).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(16).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(16).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(16).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(17).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(17).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(17).setMaxWidth(0);
            tblClientes.getColumnModel().getColumn(18).setMinWidth(0);
            tblClientes.getColumnModel().getColumn(18).setPreferredWidth(0);
            tblClientes.getColumnModel().getColumn(18).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultTableModel model = (DefaultTableModel) this.tblClientes.getModel();
        //limpa a tabela
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        //faz select de todos os dados e armazena em uma lista
        List clientes = em.createNamedQuery("Cliente.findByClitipocad", Cliente.class).getResultList();
        //pega todos os contato e adiciona na tebela.
        for (int i = 0; i < clientes.size(); i++) {
            model.addRow(new Object[]{
                ((Cliente) clientes.get(i)).getCliid(),
                ((Cliente) clientes.get(i)).getClinumerocontrato(),
                ((Cliente) clientes.get(i)).getClirotadescricao(),
                ((Cliente) clientes.get(i)).getClinome(),
                ((Cliente) clientes.get(i)).getClifantasia(),
                ((Cliente) clientes.get(i)).getClicpfcgc(),
                ((Cliente) clientes.get(i)).getClicidade(),
                ((Cliente) clientes.get(i)).getCliuf(),
                ((Cliente) clientes.get(i)).getClitipo(),
                ((Cliente) clientes.get(i)).getClibairro(),
                ((Cliente) clientes.get(i)).getClifone(),
                ((Cliente) clientes.get(i)).getClilatitude(),
                ((Cliente) clientes.get(i)).getClilongitude(),
                ((Cliente) clientes.get(i)).getClinumero(),
                ((Cliente) clientes.get(i)).getCliendereco(),
                ((Cliente) clientes.get(i)).getCliemail(),
                ((Cliente) clientes.get(i)).getClivalorfixo(),
                ((Cliente) clientes.get(i)).getClivalorexcedente(),
                ((Cliente) clientes.get(i)).getCliqtdecontratada(),
                ((Cliente) clientes.get(i)).getClirota().getGdrid()

            });
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int linha = this.tblClientes.getSelectedRow();
        String id = this.tblClientes.getValueAt(linha, 0).toString();
        String codRota = this.tblClientes.getValueAt(linha, 19).toString();

        List<Cliente> clientes = em.createNativeQuery("SELECT * FROM cliente WHERE cliid= " + id + "", Cliente.class).getResultList();
        for (Cliente cliente : clientes) {
            c.lblCodigo.setText(cliente.getCliid().toString());
            c.lblRazao.setText(cliente.getClinome());
            c.lblFantasia.setText(cliente.getClifantasia());
            c.lblCPF.setText(cliente.getClicpfcgc());
            c.lblCidade.setText(cliente.getClicidade());
            c.lblEndereco.setText(cliente.getCliendereco());
            c.lblBairo.setText(cliente.getClibairro());
            c.lblFone.setText(cliente.getClifone());
            c.lblLatitude.setText(cliente.getClilatitude());
            c.lblLongitude.setText(cliente.getClilongitude());
            c.lblRotaDescricao.setText(cliente.getClirotadescricao());
            c.lblNumero.setText(cliente.getClinumero());
            c.lblEmail.setText(cliente.getCliemail());
            c.lblUF.setText(cliente.getCliuf());
            c.txtQdtContratada.setText(cliente.getCliqtdecontratada().toString());
            c.txtlValorFixo.setText(cliente.getClivalorfixo().toString());
            c.txtValorExcedente.setText(cliente.getClivalorexcedente().toString());
            c.lblrotaID.setText(cliente.getClirota().getGdrid().toString());
            c.lblTotal.setText(cliente.getClivalorfixo().toString());
        }

        dispose();

    }//GEN-LAST:event_tblClientesMouseClicked

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
            java.util.logging.Logger.getLogger(JframeListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeListaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtRazao;
    // End of variables declaration//GEN-END:variables

    EntityManagerFactory emf;
    EntityManager em;
}