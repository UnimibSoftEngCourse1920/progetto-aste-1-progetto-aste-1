
package asteonline;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class TransizioniUtenti extends javax.swing.JFrame {   
    
     int ruolo_utente ;
     int id_utente;
     String username;
     double saldotot;
     double saldodisponibile;
     int asta_partecipante;
     int n = 0;
     
     //oggetti per la connessione
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		//oggetti per operara sul DB
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
                
    public TransizioniUtenti() {
        initComponents();
        try{
			//caricamento del driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
		
			//creazione della connessione
		try{
			conn = DriverManager.getConnection(url,idU,pwd);
			System.out.println("connessione effettuata");
		}catch(SQLException sqle){
                        System.err.println(sqle);
			System.out.println("impossibile stabilire una connessione al db");
		} 
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
    
    public void setSaldotot(double saldotot){
        this.saldotot = saldotot;
    }
    
    public void setSaldodisp(double saldodisponibile){
        this.saldodisponibile = saldodisponibile;
    }
    
    public void setAstaPart(int asta_partecipante){
        this.asta_partecipante = asta_partecipante;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("GESTIONE TRANSIZIONE UTENTE");

        jButton1.setText("VISUALIZZA TUTTE LE TRANSIZIONI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "prezzo", "nome_oggetto", "stato_rimborzato", "rimborso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        
        if(n>0){
           for(int i=n-1;i>-1;i--){
               tableModel.removeRow(i);
           }
           n=0;
        }
        
        try{
            query = "SELECT utenti.username, offerte.prezzo, oggetti.nome, aste.stato, offerte.totale_rimborsato "
                    + "FROM utenti, offerte, aste, oggetti "
                    + "WHERE utenti.id_utente = offerte.utente_vincente "
                    + "AND offerte.asta_associata = aste.id_asta "
                    + "AND aste.oggetto_asta = oggetti.id_oggetto ";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                String us = rs.getString("utenti.username");
                double prez = rs.getDouble("offerte.prezzo");
                String nomOg = rs.getString("oggetti.nome");
                int st = rs.getInt("aste.stato");
                double rim = rs.getDouble("offerte.totale_rimborsato");
                
                String sta = null;
                
                if(st == 2){
                    sta = "No";
                }else if(st == 3){
                    sta = "Si";
                }
                
                tableModel.addRow(new Object[]{us, prez, nomOg, sta, rim});
                n++;
                
            }
            
            
        }catch(SQLException se){
            System.err.println(se);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Amministrazione am= new Amministrazione();
        setVisible(false);
        am.setVisible(true);
        am.setRuolo(ruolo_utente);
        am.setId(id_utente);
        am.setUsername(username);
        am.setSaldotot(saldotot);
        am.setSaldodisp(saldodisponibile);
        am.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TransizioniUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransizioniUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransizioniUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransizioniUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransizioniUtenti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
