/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import entity.Rota;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import util.Utilitarios;

/**
 *
 * @author Jefson
 */
public final class JframePrincipal extends javax.swing.JFrame {

    public String usuario;

    EntityManagerFactory emf;
    EntityManager em;
    public static JframePrincipal instance;

    public static JframePrincipal getInstance() { // MÉTODO QUE VERIFICA SE A INSTANCIA JÁ ESTÁ CRIADA (SINGLETON)
        if (instance == null) {
            instance = new JframePrincipal();
        }
        return instance;
    }

    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatador2 = new SimpleDateFormat("yyyy-MM-dd");

    DecimalFormat df2 = new DecimalFormat("0.00");
    DecimalFormat df3 = new DecimalFormat("0.000");

    java.util.Timer timer1 = new java.util.Timer();
    java.util.Timer timer2 = new java.util.Timer();

    public JframePrincipal() {
        initComponents();
        Utilitarios util = new Utilitarios();
        util.InserirIcon(this);
        util.InserirTitulo(this);
        emf = Persistence.createEntityManagerFactory("TCC_JPAPU");
        em = emf.createEntityManager();
        AtualizacaoColetasAutomatica();
    }

    public String diaDaSemana(Calendar calendar) {
        return new DateFormatSymbols().getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)];
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
        System.out.println("Serviço de Atualização iniciado...");
        int delay = 0;   // delay de 0 seg.
        int interval = 5000;  // intervalo de 1 seg.       

        timer1.scheduleAtFixedRate(new TimerTask() {
            int id = 1;

            @Override
            public void run() {
               System.out.println("Serviço de Atualização iniciado...");
                soma();
            }
        }, delay, interval);

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
        btnCliente = new javax.swing.JButton();
        btnColetas = new javax.swing.JButton();
        btnMonitor = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/fundo3.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0,0, getWidth(),getHeight(),this);
            }
        };
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuCadastro1 = new javax.swing.JMenu();
        MenuItemCliente1 = new javax.swing.JMenuItem();
        MenuItemGrupoRota1 = new javax.swing.JMenuItem();
        MenuItemVeículos1 = new javax.swing.JMenuItem();
        MenuItemMunicipio1 = new javax.swing.JMenuItem();
        MenuItemUsuario1 = new javax.swing.JMenuItem();
        btnMenuItemEmpresa = new javax.swing.JRadioButtonMenuItem();
        MenuMovimentacao1 = new javax.swing.JMenu();
        MenuItemColetas1 = new javax.swing.JMenuItem();
        MenuItemMonitor1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        btnCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/do-utilizador.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnColetas.setBackground(new java.awt.Color(255, 255, 255));
        btnColetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/caminhao-de-entrega (1).png"))); // NOI18N
        btnColetas.setText("Coletas");
        btnColetas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnColetas.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnColetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColetasActionPerformed(evt);
            }
        });

        btnMonitor.setBackground(new java.awt.Color(255, 255, 255));
        btnMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transferir.png"))); // NOI18N
        btnMonitor.setText("Monitor");
        btnMonitor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMonitor.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sair.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColetas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCliente, btnColetas, btnMonitor, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColetas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCliente, btnColetas, btnMonitor, jButton3});

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("HORA");

        lblData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblData.setText("DATA");

        lblDia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDia.setText("DIA");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setText("TESTE");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Usuário:");

        MenuCadastro1.setText("Cadastro");

        MenuItemCliente1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MenuItemCliente1.setText("Clientes");
        MenuItemCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCliente1ActionPerformed(evt);
            }
        });
        MenuCadastro1.add(MenuItemCliente1);

        MenuItemGrupoRota1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        MenuItemGrupoRota1.setText("Grupo de Rotas");
        MenuItemGrupoRota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGrupoRota1ActionPerformed(evt);
            }
        });
        MenuCadastro1.add(MenuItemGrupoRota1);

        MenuItemVeículos1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        MenuItemVeículos1.setText("Veículos");
        MenuItemVeículos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemVeículos1ActionPerformed(evt);
            }
        });
        MenuCadastro1.add(MenuItemVeículos1);

        MenuItemMunicipio1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        MenuItemMunicipio1.setText("Municípios");
        MenuItemMunicipio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemMunicipio1ActionPerformed(evt);
            }
        });
        MenuCadastro1.add(MenuItemMunicipio1);

        MenuItemUsuario1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        MenuItemUsuario1.setText("Usuários");
        MenuItemUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemUsuario1ActionPerformed(evt);
            }
        });
        MenuCadastro1.add(MenuItemUsuario1);

        btnMenuItemEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        btnMenuItemEmpresa.setSelected(true);
        btnMenuItemEmpresa.setText("Empresa");
        btnMenuItemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuItemEmpresaActionPerformed(evt);
            }
        });
        MenuCadastro1.add(btnMenuItemEmpresa);

        jMenuBar2.add(MenuCadastro1);

        MenuMovimentacao1.setText("Movimentação");

        MenuItemColetas1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        MenuItemColetas1.setText("Coletas");
        MenuItemColetas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemColetas1ActionPerformed(evt);
            }
        });
        MenuMovimentacao1.add(MenuItemColetas1);

        MenuItemMonitor1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        MenuItemMonitor1.setText("Monitor");
        MenuItemMonitor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemMonitor1ActionPerformed(evt);
            }
        });
        MenuMovimentacao1.add(MenuItemMonitor1);

        jMenuBar2.add(MenuMovimentacao1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(lblDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 534, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblData)
                        .addComponent(lblDia))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCliente1ActionPerformed

        JframeClientes cliente = new JframeClientes();

        cliente.setVisible(true);

    }//GEN-LAST:event_MenuItemCliente1ActionPerformed

    private void MenuItemGrupoRota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGrupoRota1ActionPerformed

        JframeGrupoRotas grupoRotas = new JframeGrupoRotas();

        grupoRotas.setVisible(true);
    }//GEN-LAST:event_MenuItemGrupoRota1ActionPerformed

    private void MenuItemVeículos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemVeículos1ActionPerformed

        JframeVeiculo veiculo = new JframeVeiculo();
        veiculo.setVisible(true);

    }//GEN-LAST:event_MenuItemVeículos1ActionPerformed

    private void MenuItemMunicipio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemMunicipio1ActionPerformed

        JframeMunicipio municipio = new JframeMunicipio();
        municipio.setVisible(true);

    }//GEN-LAST:event_MenuItemMunicipio1ActionPerformed

    private void MenuItemUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemUsuario1ActionPerformed

        JframeUsuario usuarios = new JframeUsuario();
        usuarios.setVisible(true);

    }//GEN-LAST:event_MenuItemUsuario1ActionPerformed

    private void MenuItemColetas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemColetas1ActionPerformed

        JframeColetas coletas = new JframeColetas();
        coletas.setVisible(true);

    }//GEN-LAST:event_MenuItemColetas1ActionPerformed

    private void MenuItemMonitor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemMonitor1ActionPerformed

        JframeMonitor monitor = new JframeMonitor();
        monitor.setVisible(true);

    }//GEN-LAST:event_MenuItemMonitor1ActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed

        JframeClientes cliente = new JframeClientes();
        cliente.setVisible(true);

    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnColetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColetasActionPerformed

        JframeColetas coletas = new JframeColetas();
        coletas.setVisible(true);

    }//GEN-LAST:event_btnColetasActionPerformed

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorActionPerformed

        JframeMonitor monitor = new JframeMonitor();
        monitor.setVisible(true);
    }//GEN-LAST:event_btnMonitorActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date dataSistema = new Date();
        Locale local = new Locale("pt", "BR");
        DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText((formato.format(dataSistema)));
        lblDia.setText(diaDaSemana(formato.getCalendar()) + ",");
        lblUsuario.setText(usuario);
        javax.swing.Timer timer = new javax.swing.Timer(1000, new hora());
        timer.start();
        soma();
    }//GEN-LAST:event_formWindowOpened

    private void btnMenuItemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuItemEmpresaActionPerformed
        JframeEmpresa empresa = new JframeEmpresa();
        empresa.setVisible(true);
    }//GEN-LAST:event_btnMenuItemEmpresaActionPerformed

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
            java.util.logging.Logger.getLogger(JframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro1;
    private javax.swing.JMenuItem MenuItemCliente1;
    private javax.swing.JMenuItem MenuItemColetas1;
    private javax.swing.JMenuItem MenuItemGrupoRota1;
    private javax.swing.JMenuItem MenuItemMonitor1;
    private javax.swing.JMenuItem MenuItemMunicipio1;
    private javax.swing.JMenuItem MenuItemUsuario1;
    private javax.swing.JMenuItem MenuItemVeículos1;
    private javax.swing.JMenu MenuMovimentacao1;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnColetas;
    private javax.swing.JRadioButtonMenuItem btnMenuItemEmpresa;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JButton jButton3;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Calendar now = Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));

        }

    }

}
