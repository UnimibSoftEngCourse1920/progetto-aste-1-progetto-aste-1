
package asteonline;


/**
 *
 * @author lenovo
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ImpostazioniUtente extends javax.swing.JFrame {

    int ruolo_utente ;
     int id_utente;
     String username;
     double saldotot;
     double saldodisponibile;
     int asta_partecipante;
     int n = 0, st = 7, penCamb = 0, ogg = 0, idOff = 0;
     double totRim = 0, prezOgg = 0;
     
     
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
                
    public ImpostazioniUtente() {
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
                jLabel3.setVisible(false);
                jLabel2.setVisible(false);
                jTextField1.setVisible(false);
                jButton4.setVisible(false);
                jLabel4.setVisible(false);
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
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("IMPOSTAZIONI UTENTE");

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VISUALIZZA ASTE VINTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("AGGIUNGI CREDITO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_asta", "nome_oggetto", "offerta_vicente", "penale(%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Inserire l'id dell'asta per richiedere un rimborso ");

        jButton4.setText("RIMBORSO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("NON HAI ASTE VINTE");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("ID ASTA INESISTENTE O INPUT ERRATO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(29, 29, 29)
                                .addComponent(jButton3)))
                        .addGap(71, 71, 71)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel4)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Home hm = new Home();
        setVisible(false);
        hm.setVisible(true);
        hm.setRuolo(ruolo_utente);
        hm.setId(id_utente);
        hm.setUsername(username);
        hm.setSaldotot(saldotot);
        hm.setSaldodisp(saldodisponibile);
        hm.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel(); 
       
        if(n>0){
           for(int i=n-1;i>-1;i--){
               tableModel.removeRow(i);
           }
           n=0;
        }
        
        try{
            query = "SELECT aste.id_asta, oggetti.nome, offerte.prezzo, aste.perc_penale "
                    + "FROM aste, oggetti, offerte "
                    + "WHERE aste.stato = '2' "
                    + "AND aste.oggetto_asta = oggetti.id_oggetto "
                    + "AND offerte.asta_associata = aste.id_asta "
                    + "AND offerte.utente_vincente = '"+ id_utente +"'";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                int id_a = rs.getInt("aste.id_asta");
                String nomOg = rs.getString("oggetti.nome");
                double prez = rs.getDouble("offerte.prezzo");
                int pen = rs.getInt("aste.perc_penale");
                
                tableModel.addRow(new Object[]{id_a, nomOg, prez, pen});
                n++;
            }
            
            stm.close();
            if(n>0){
                jLabel2.setVisible(true);
                jTextField1.setVisible(true);
                jButton4.setVisible(true);
            }else{
                jLabel3.setVisible(true);
            }
            
        }catch(SQLException se){
            System.err.println(se);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String prova = jTextField1.getText();
        jLabel4.setVisible(true); 
        try{
            int q = Integer.parseInt(prova);
            jLabel4.setVisible(false);
            
            query = "SELECT * "
                    + "FROM aste, offerte "
                    + "WHERE id_asta = '"+ q +"' "
                    + "AND aste.utente_offerta_max = '"+ id_utente +"' "
                    + "AND aste.stato = '2' "
                    + "AND offerte.asta_associata = aste.id_asta";
           
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            if(rs.next()){
                penCamb = rs.getInt("aste.perc_penale");
                prezOgg = rs.getDouble("offerte.prezzo");
                ogg = rs.getInt("aste.oggetto_asta");
                idOff = rs.getInt("offerte.id_offerta");
                st = 2;
            }else{
                jLabel4.setVisible(true); 
                st = 7;
            }
            
            stm.close();
            System.out.println(st);
            
            if(st == 2){
                double togl = (prezOgg / 100)*penCamb;
                totRim = prezOgg - togl;
                System.out.println("rimb = "+totRim);
                
                System.out.println("saldDisp1 = "+saldodisponibile);
                saldodisponibile = saldodisponibile + totRim;
                System.out.println("saldDisp2 = "+saldodisponibile);
                saldotot = saldotot + totRim;
                
                
                query ="UPDATE oggetti "
                        + "SET stato = 0 "
                        + "WHERE id_oggetto = +'"+ ogg +"'";
                System.out.println(query);
                
                stm = conn.createStatement();
                x = stm.executeUpdate(query);
                
                stm.close();
                
                
                query ="UPDATE aste "
                        + "SET stato = 3 "
                        + "WHERE id_asta = +'"+ q +"'";
                System.out.println(query);
                
                stm = conn.createStatement();
                x = stm.executeUpdate(query);
                
                stm.close();
                
                
                query ="UPDATE utenti "
                        + "SET saldo = '"+ saldotot +"', saldo_disponibile ='"+ saldodisponibile +"' "
                        + "WHERE id_utente = +'"+ id_utente +"'";
                System.out.println(query);
                
                stm = conn.createStatement();
                x = stm.executeUpdate(query);
                
                stm.close();
                
                
                query ="UPDATE offerte "
                        + "SET totale_rimborsato = '"+ totRim +"' "
                        + "WHERE id_offerta = +'"+ idOff +"'";
                System.out.println(query);
                
                stm = conn.createStatement();
                x = stm.executeUpdate(query);
                
                stm.close();
                
                
                RimborsoEff rimb = new RimborsoEff();
                setVisible(false);
                rimb.setVisible(true);
                rimb.setId(id_utente);
                rimb.setRuolo(ruolo_utente);
                rimb.setUsername(username);
                rimb.setSaldotot(saldotot);
                rimb.setSaldodisp(saldodisponibile);
                rimb.setAstaPart(asta_partecipante);
            }
            
            
            
        }catch(SQLException se){
                 System.err.println(se);
             }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        IncrementoSaldo is = new IncrementoSaldo();
        setVisible(false);
        is.setVisible(true);
        is.setId(id_utente);
        is.setRuolo(ruolo_utente);
        is.setUsername(username);
        is.setSaldotot(saldotot);
        is.setSaldodisp(saldodisponibile);
        is.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ImpostazioniUtente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpostazioniUtente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpostazioniUtente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpostazioniUtente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpostazioniUtente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
