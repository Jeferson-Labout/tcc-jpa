/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import entity.Cliente;
import entity.Rota;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Utilitarios;

/**
 *
 * @author Jefson
 */
public class JframeColetasGrupo extends javax.swing.JFrame {

    public static JframeColetasGrupo instance = null;
    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    EntityManagerFactory emf;
    EntityManager em;

    /**
     * Creates new form JframeColetasGrupo
     */
    public JframeColetasGrupo() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        TCC_JPAPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("TCC_JPAPU").createEntityManager();
        gruporotaQuery = java.beans.Beans.isDesignTime() ? null : TCC_JPAPUEntityManager.createQuery("SELECT g FROM Gruporota g");
        gruporotaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : gruporotaQuery.getResultList();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : TCC_JPAPUEntityManager.createQuery("SELECT c FROM Cliente c WHERE c.clitipocad =3  ORDER BY c.cliid ");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        veiculoQuery = java.beans.Beans.isDesignTime() ? null : TCC_JPAPUEntityManager.createQuery("SELECT v FROM Veiculo v");
        veiculoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : veiculoQuery.getResultList();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxRota = new javax.swing.JComboBox<>();
        btnInserir = new javax.swing.JButton();
        btnLimpaTela = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCodVeiculo = new javax.swing.JTextField();
        txtCodMotorista = new javax.swing.JTextField();
        txtMotorista = new javax.swing.JTextField();
        txtVeiculo = new javax.swing.JTextField();
        btnPesquisaMotorista = new javax.swing.JButton();
        btnPesquisaVeiculo = new javax.swing.JButton();
        lblModelo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGpColetas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(0, 102, 0));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Gerar Coletas por Rota");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Rota:");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${resultList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gruporotaQuery, eLProperty, ComboBoxRota);
        bindingGroup.addBinding(jComboBoxBinding);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnLimpaTela.setText("Limpar Tela");
        btnLimpaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTelaActionPerformed(evt);
            }
        });

        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        jLabel18.setText("Coletor:");

        jLabel19.setText("Ve??culo:");

        txtCodVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVeiculoActionPerformed(evt);
            }
        });

        btnPesquisaMotorista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisa.png.png"))); // NOI18N
        btnPesquisaMotorista.setBorder(null);
        btnPesquisaMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaMotoristaActionPerformed(evt);
            }
        });

        btnPesquisaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisa.png.png"))); // NOI18N
        btnPesquisaVeiculo.setBorder(null);
        btnPesquisaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaVeiculoActionPerformed(evt);
            }
        });

        lblModelo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisaMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpaTela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConcluir)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxRota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblModelo)
                        .addGap(147, 147, 147))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMotorista, txtVeiculo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodMotorista, txtCodVeiculo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtCodMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(txtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPesquisaVeiculo)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInserir)
                                .addComponent(btnLimpaTela)
                                .addComponent(btnConcluir))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPesquisaMotorista)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMotorista, txtVeiculo});

        tblGpColetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Raz??o", "Fantasia", "Rota", "Coletor", "Cod_motoristal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGpColetas);
        if (tblGpColetas.getColumnModel().getColumnCount() > 0) {
            tblGpColetas.getColumnModel().getColumn(5).setMinWidth(0);
            tblGpColetas.getColumnModel().getColumn(5).setPreferredWidth(0);
            tblGpColetas.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tblGpColetas.getModel();
        //limpa a tabela
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        String rota = this.ComboBoxRota.getSelectedItem().toString();
        String motorista = this.txtMotorista.getText();

        List<Cliente> clientes = em.createNativeQuery("SELECT *FROM Cliente  WHERE clirotadescricao ='" + rota + "'", Cliente.class).getResultList();
        for (int i = 0; i < clientes.size(); i++) {
            model.addRow(new Object[]{
                ((Cliente) clientes.get(i)).getCliid(),
                //                ((Cliente) clientes.get(i)).getClinumerocontrato(),
                ((Cliente) clientes.get(i)).getClinome(),
                ((Cliente) clientes.get(i)).getClifantasia(),
                ((Cliente) clientes.get(i)).getClirotadescricao(),
                motorista

            });

        }
        this.txtCodMotorista.setEnabled(false);
        this.ComboBoxRota.setEnabled(false);
        this.txtMotorista.setEnabled(false);
        this.txtCodVeiculo.setEnabled(false);
        this.txtVeiculo.setEnabled(false);
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimpaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTelaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.tblGpColetas.getModel();
        modelo.setNumRows(0);
        this.txtCodMotorista.setEnabled(true);
        this.txtMotorista.setEnabled(true);
        this.ComboBoxRota.setEnabled(true);
        this.txtCodVeiculo.setEnabled(true);
        this.txtVeiculo.setEnabled(true);
    }//GEN-LAST:event_btnLimpaTelaActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        int linha = this.tblGpColetas.getSelectedRow();
        String rota1 = this.ComboBoxRota.getSelectedItem().toString();
        List<Cliente> clientes_ = em.createNativeQuery("SELECT *FROM Cliente  WHERE clirotadescricao ='" + rota1 + "'", Cliente.class).getResultList();
        for (int i = 0; i < clientes_.size(); i++) {
            String id = tblGpColetas.getModel().getValueAt(i, 0).toString();
            String placa = this.txtVeiculo.getText();
            String modelo = this.lblModelo.getText();
            String rotaStatus = "P";
            String tipo = "";
            String obs = "";
            BigDecimal qdtcoletada = new BigDecimal(0);
            BigDecimal vlrExer = new BigDecimal(0);
            BigDecimal valorT = new BigDecimal(0);
            String responsavel = null;
            String nomeMotorista = this.txtMotorista.getText();
            int motorista = Integer.parseInt(txtCodMotorista.getText());
            int veiculo = Integer.parseInt(txtCodVeiculo.getText());
            List<Cliente> clientes = em.createNativeQuery("SELECT * FROM cliente WHERE cliid= " + id + "", Cliente.class).getResultList();
            for (Cliente cliente : clientes) {
                em.getTransaction().begin();
                Rota rota = new Rota();
                rota.setRotagdrid(cliente.getClirota().getGdrid());
                rota.setRotagdrdescricao(cliente.getClirotadescricao());
                rota.setRotacliid(cliente.getCliid());
                rota.setRotacliidmotorista(motorista);
                rota.setRotaveiid(veiculo);
                rota.setRotaveiplaca(placa);
                rota.setRotaveimodelo(modelo);
                rota.setRotaclinomemotorista(nomeMotorista);
                rota.setRotaclinome(cliente.getClinome());
                rota.setRotaclifantasia(cliente.getClifantasia());
                rota.setRotaclilongitude(cliente.getClilongitude());
                rota.setRotaclilatitude(cliente.getClilatitude());
                rota.setRotadata(data);
                rota.setRotadatacoleta(data);
                rota.setRotastatus(rotaStatus);
                rota.setRotatipof(tipo);
                rota.setRotaqtdeexcedente(vlrExer);
                rota.setRotaqtde(cliente.getCliqtdecontratada());
                rota.setRotavalorfixo(cliente.getClivalorfixo());
                rota.setRotacliqtdecontratada(cliente.getCliqtdecontratada());
                rota.setRotavalorexcedente(cliente.getClivalorexcedente());
                rota.setRotavalortotal(cliente.getClivalorfixo());
                rota.setRotaobservacao(obs);
                rota.setRotaresponsavel(responsavel);
                rota.setRotaclifone(cliente.getClifone());
                rota.setRotacliemail(cliente.getCliemail());
                rota.setRotaclicpfcgc(cliente.getClicpfcgc());
                rota.setRotacliendereco(cliente.getCliendereco());
                rota.setRotaclibairro(cliente.getClibairro());
                rota.setRotaclinumero(cliente.getClinumero());
                rota.setRotaclicidade(cliente.getClicidade());
                rota.setRotacliuf(cliente.getCliuf());
                em.persist(rota);
                em.flush();
                //retorna o ultimo

                System.out.println(rota.getRotaid());

                em.getTransaction().commit();

            }
        }
        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void txtCodVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodVeiculoActionPerformed

    private void btnPesquisaMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaMotoristaActionPerformed
        JframeListaMotorista_ motorista = new JframeListaMotorista_();
        motorista.setVisible(true);
        motorista.g = this;
        motorista.pack();
    }//GEN-LAST:event_btnPesquisaMotoristaActionPerformed

    private void btnPesquisaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaVeiculoActionPerformed
        JframeListaVeiculo_ veiculo = new JframeListaVeiculo_();
        veiculo.setVisible(true);
        veiculo.g = this;
        veiculo.pack();
    }//GEN-LAST:event_btnPesquisaVeiculoActionPerformed

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
            java.util.logging.Logger.getLogger(JframeColetasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeColetasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeColetasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeColetasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeColetasGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxRota;
    private javax.persistence.EntityManager TCC_JPAPUEntityManager;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpaTela;
    private javax.swing.JButton btnPesquisaMotorista;
    private javax.swing.JButton btnPesquisaVeiculo;
    private java.util.List<entity.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private java.util.List<entity.Gruporota> gruporotaList;
    private javax.persistence.Query gruporotaQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblModelo;
    private javax.swing.JTable tblGpColetas;
    public javax.swing.JTextField txtCodMotorista;
    public javax.swing.JTextField txtCodVeiculo;
    public javax.swing.JTextField txtMotorista;
    public javax.swing.JTextField txtVeiculo;
    private java.util.List<entity.Veiculo> veiculoList;
    private javax.persistence.Query veiculoQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
