
package asteonline;

/**
 *
 * @author andre
 */

import java.sql.*;

public class AstaConclusa extends javax.swing.JFrame {
    
    int ruolo_utente ;
    int id_utente;
    int id_asta;
    String username;
    double saldotot;
    double saldodisponibile;
    
    int utOffMax = 0;
    double offMax = 0;
    String nomOg = null;
    
    
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
                
    public AstaConclusa() {
        initComponents();
        try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
		
	
		try{
			conn = DriverManager.getConnection(url,idU,pwd);
			System.out.println("connessione effettuata");
		}catch(SQLException sqle){
                        System.err.println(sqle);
			System.out.println("impossibile stabilire una connessione al db");
		}
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                jButton1.setVisible(false);
    }
    
    public void setRuolo(int ruolo_utente){
        this.ruolo_utente=ruolo_utente;
    }
    
    public void setId(int id_utente){
        this.id_utente = id_utente;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setIdasta(int id_asta){
        this.id_asta = id_asta;
    }
    
    public void setSaldotot(double saldotot){
        this.saldotot = saldotot;
    }
    
    public void setSaldodisp(double saldodisponibile){
        this.saldodisponibile = saldodisponibile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("VITTORIA/SCONFITTA");

        jButton1.setText("CONFERMA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Oggetto: ");

        jLabel3.setText("nome oggetto");

        jLabel4.setText("Offerta vincente:");

        jLabel5.setText("valore offMax");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("VISUALIZZA RISULTATO !!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            query = "SELECT aste.utente_offerta_max, aste.offerta_max,oggetti.nome "
                    + "FROM aste, oggetti "
                    + "WHERE aste.oggetto_asta = oggetti.id_oggetto "
                    + "AND aste.id_asta = '"+ id_asta +"'";
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            if(rs.next()){
                utOffMax = rs.getInt("aste.utente_offerta_max");
                offMax = rs.getDouble("aste.offerta_max");
                nomOg = rs.getString("oggetti.nome");
            }
            
            if(id_utente == utOffMax){
                jLabel1.setText("HAI VINTOOO!!!");
                saldotot = saldodisponibile;
            }else{
                jLabel1.setText("HAI PERSO...");
                saldodisponibile = saldotot;
            }
            
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setText(nomOg);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setText(String.valueOf(offMax));
            jLabel5.setVisible(true);
            jButton1.setVisible(true);
            jButton2.setVisible(false);
            
        }catch(SQLException se){
            System.err.println(se);
        }
               
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            query = "UPDATE utenti "
                    + "SET asta_partecipante = 0, saldo = '"+saldotot +"', saldo_disponibile = '"+ saldodisponibile +"' "
                    + "WHERE id_utente = '"+id_utente+"'";
            System.out.println(query);
            
            stm = conn.createStatement();
            x = stm.executeUpdate(query);
            
            stm.close();
            
            int ast = 0;
            
            Home hm = new Home();
            setVisible(false);
            hm.setVisible(true);
            hm.setId(id_utente);
            hm.setRuolo(ruolo_utente);
            hm.setUsername(username);
            hm.setSaldotot(saldotot);
            hm.setSaldodisp(saldodisponibile);
            hm.setAstaPart(ast);
        }catch(SQLException se){
            System.err.println(se);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AstaConclusa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AstaConclusa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AstaConclusa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AstaConclusa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AstaConclusa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
