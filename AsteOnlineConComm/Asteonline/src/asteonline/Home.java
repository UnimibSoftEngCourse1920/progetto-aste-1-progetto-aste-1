
package asteonline;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class Home extends javax.swing.JFrame {

    
     int ruolo_utente ;
     int id_utente;
     String username;
     int n=0,q=7;
     double saldotot;
     double saldodisponibile;
     int asta_partecipante;
     
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
                
    public Home() {
        initComponents();
        jLabel2.setText(username);
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
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
    }
    
    public void setRuolo(int ruolo_utente){
        this.ruolo_utente=ruolo_utente;
        if(ruolo_utente == 0){
            jButton6.setVisible(false);
        }
    }
    
    public void setId(int id_utente){
        this.id_utente = id_utente;
    }
    
    public void setUsername(String username){
        this.username = username;
        jLabel2.setText(username);
    }
    
    public void setSaldotot(double saldotot){
        this.saldotot = saldotot;
    }
    
    public void setSaldodisp(double saldodisponibile){
        this.saldodisponibile = saldodisponibile;
        jLabel5.setText(saldodisponibile + " euro");
    }
    
    public void setAstaPart(int asta_partecipante){
        this.asta_partecipante = asta_partecipante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButton1.setText("Gestisci oggetti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("CIAO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        jButton2.setText("Gestisci Categorie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Crea Aste");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Visualizza Aste");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_asta", "Punt_Max", "Data", "tipo", "oggetto", "Punt_rim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton6.setText("AMMINISTRAZIONE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setText("Inserire l'id dell'asta a cui si vuole partecipare");

        jButton7.setText("Apri");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Impostazioni User");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setText("Saldo disponibile:");

        jLabel5.setText("valore saldo corrente");

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("ASTA INESISTENTE O INSERIMENTO DATI ERRATO");

        jButton9.setText("Visualizza Asta a cui stai partecipando");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("NON STAI PARTECIPANDO A NESSUNA ASTA");

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("STAI GIA PARTECIPANDO AD UN'ASTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Oggetto og = new Oggetto();
        setVisible(false);
        og.setVisible(true);
        og.setId(id_utente);
        og.setUsername(username);
        og.setRuolo(ruolo_utente);
        og.setSaldotot(saldotot);
        og.setSaldodisp(saldodisponibile);
        og.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       Amministrazione am= new Amministrazione();
       setVisible(false);
       am.setVisible(true);
       am.setId(id_utente);
       am.setRuolo(ruolo_utente);
       am.setUsername(username);
       am.setSaldotot(saldotot);
       am.setSaldodisp(saldodisponibile);
       am.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       String prova = jTextField1.getText();
       jLabel8.setVisible(true);
       if(asta_partecipante == 0){
           jLabel8.setVisible(false);
           jLabel6.setVisible(true);
            try{
                int ida = Integer.parseInt(prova);      //serve per verificare se l'utente ha inserito solo numeri
                jLabel6.setVisible(false);            //(ammetto che un utente puo' inserire numeri nei nomi della categoria)
           
                 //query per controllare se l'asta selezionata ha lo stato impostato a 0 o 1 altrimenti non apre la pagina
                query = "SELECT * "
                      + "FROM aste "
                      + "WHERE id_asta = '"+ ida +"'";
           
                 System.out.println(query);
           
                stm = conn.createStatement();
                rs = stm.executeQuery(query);
           
                if(rs.next()){
                    q = rs.getInt("stato");
                }
                System.out.println(q);
           
                if(q == 0 || q == 1){
                    Aste st=new Aste();
                    setVisible(false);
                    st.setVisible(true);
                    st.setId(id_utente);
                    st.setUsername(username);
                    st.setRuolo(ruolo_utente);
                    st.setIdasta(ida);
                    st.setSaldotot(saldotot);
                    st.setSaldodisp(saldodisponibile);
                }else{
                    jLabel6.setVisible(true);
                }
           
           
            }catch(Exception e){
                System.err.println(e);
            }
           
       }
       
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Categoria ct= new Categoria();
        setVisible(false);
        ct.setVisible(true);
        ct.setId(id_utente);
        ct.setRuolo(ruolo_utente);
        ct.setUsername(username);
        ct.setSaldotot(saldotot);
        ct.setSaldodisp(saldodisponibile);
        ct.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CreaAsta cr= new CreaAsta();
        setVisible(false);
        cr.setVisible(true);
        cr.setId(id_utente);
        cr.setRuolo(ruolo_utente);
        cr.setUsername(username);
        cr.setSaldotot(saldotot);
        cr.setSaldodisp(saldodisponibile);
        cr.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel(); 
       
       if(n>0){
           for(int i=n-1;i>-1;i--){
               tableModel.removeRow(i);
           }
           n=0;
       }
       
        try{
            query ="SELECT aste.id_asta, aste.durata_timeslot, aste.data_creazione, aste.tipo_asta, oggetti.nome, aste.num_off_rimanenti"
                    + " FROM aste,oggetti "
                    + "WHERE oggetti.id_oggetto = aste.oggetto_asta "
                    + "AND (aste.stato = '0' OR aste.stato = '1')";
            System.out.println(query);
           
            stm = conn.createStatement();
           
           //esecuzione statement
            rs = stm.executeQuery(query);
            
            
            while(rs.next()){
                
               int idast =  rs.getInt("aste.id_asta");
               int puntmax = rs.getInt("aste.durata_timeslot");
               String data = rs.getString("aste.data_creazione");
               int tip = rs.getInt("aste.tipo_asta");
               String ogg = rs.getString("oggetti.nome");
               int offrim = rs.getInt("aste.num_off_rimanenti");
               
               String mod;
               if(tip == 0){
                   mod = "Classica";
               }else{
                   mod = "Busta Chiusa";
               }
           
                tableModel.addRow(new Object[]{idast, puntmax, data, mod, ogg, offrim});     
                n++;
            }
              stm.close();  
              
        }catch(SQLException se){
            System.err.println(se);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ImpostazioniUtente imp = new ImpostazioniUtente();
        setVisible(false);
        imp.setVisible(true);
        imp.setId(id_utente);
        imp.setRuolo(ruolo_utente);
        imp.setUsername(username);
        imp.setSaldotot(saldotot);
        imp.setSaldodisp(saldodisponibile);
        imp.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(asta_partecipante == 0){
          jLabel7.setVisible(true);
        }else{
          int sta = 5;
          jLabel7.setVisible(false);
          //acquisisco lo stato dell'asta a cui stavo partecipando
          try{
            query = "SELECT stato, tipo_asta, utente_offerta_max "
                  + "FROM aste "
                  + "WHERE id_asta = '"+ asta_partecipante +"'";
            System.out.println(query);
          
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
           
           
            if(rs.next()){
                sta = rs.getInt("stato");
            }
          stm.close();
          
          }catch(SQLException se){
              System.err.println(se);
          }
          
          if(sta == 1){
              //se stato e' uguale a 1 apro la pagina Asta
              Aste st=new Aste();
              setVisible(false);
              st.setVisible(true);
              st.setId(id_utente);
              st.setUsername(username);
              st.setRuolo(ruolo_utente);
              st.setIdasta(asta_partecipante);
              st.setSaldotot(saldotot);
              st.setSaldodisp(saldodisponibile);
          }else if(sta == 2 || sta == 3){
              //se stato e' uguale a 2-3 apro la pagina AstaConclusa
                  AstaConclusa ac= new AstaConclusa();
                  setVisible(false);
                  ac.setVisible(true);
                  ac.setId(id_utente);
                  ac.setRuolo(ruolo_utente);
                  ac.setUsername(username);
                  ac.setSaldotot(saldotot);
                  ac.setSaldodisp(saldodisponibile);
                  ac.setIdasta(asta_partecipante);
              
          }  
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login lg = new Login();
        setVisible(false);
        lg.setVisible(true);
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
