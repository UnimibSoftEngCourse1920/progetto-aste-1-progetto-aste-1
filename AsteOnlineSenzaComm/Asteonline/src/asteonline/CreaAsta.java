
package asteonline;

/**
 *
 * @author dominguez
 */
import java.sql.*;
import java.util.*;

public class CreaAsta extends javax.swing.JFrame {


     int ruolo_utente ;
     int id_utente;
     String username;
     double saldotot;
     double saldodisponibile;
     int asta_partecipante;
     int tipo;
     
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
     
    public CreaAsta() {
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
                jButton1.setVisible(false);
                jLabel8.setVisible(false);
                controlloTipoTime();
        
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
    
    public void FillcomboOggetto(){
        try{
            query ="SELECT nome FROM oggetti WHERE utente_crea= '"+ id_utente +"' "
                    + "AND stato= '0'";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                String nome = rs.getString("nome");
                jComboBox4.addItem(nome);
            }
            stm.close();
        }catch(SQLException se){
            System.err.println(se);
        }
    }
    
    public void controlloTipoTime(){
        try{
            query = "SELECT tipo_timeslot FROM utenti WHERE username = 'Pecos'";
            System.out.println(query);
             
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            if(rs.next()){
                tipo = rs.getInt("tipo_timeslot");
                if(tipo != 0){
                    jLabel3.setVisible(false);
                    jComboBox1.setVisible(false);
                    jLabel7.setVisible(true);
                    jLabel7.setText("SETUP AMMINISTRATORE "+ tipo + " PUNTATE MASSIME");
                }else{
                    jLabel7.setVisible(false);
                }
            }
        }catch(SQLException se){
            System.err.println(se);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("CREAZIONE ASTA");

        jLabel3.setText("NUMERO PUNTATE");

        jLabel4.setText("TIPO ASTA");

        jLabel5.setText("PENALE");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "5", "7", "9" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Classica", "Busta chiusa" }));

        jLabel6.setText("OGGETTO");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "25", "50", "75", "100" }));

        jButton1.setText("CREA");
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

        jLabel7.setText("MEX");

        jButton3.setText("Visualizza tuoi oggetti");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("NESSUN OGGETTO PRESENTE NELLA TUA LISTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(jButton1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jLabel2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(72, 72, 72)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)))
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home hm = new Home();
        setVisible(false);
        hm.setVisible(true);
        hm.setId(id_utente);
        hm.setUsername(username);
        hm.setRuolo(ruolo_utente);
        hm.setSaldotot(saldotot);
        hm.setSaldodisp(saldodisponibile);
        hm.setAstaPart(asta_partecipante);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel8.setVisible(true);
        
        String t,v;
        int id_ogge=0;
        try{
            if(tipo == 0){
                t = jComboBox1.getSelectedItem().toString();
            }else{
                t = "0"; 
            }
            
            String ast =  jComboBox2.getSelectedItem().toString();
            if(ast.equals("Classica")){
                v = "0";
            }else{
                v = "1";
            }
            String pen=  jComboBox3.getSelectedItem().toString();
            
            String n_ogg =  jComboBox4.getSelectedItem().toString();
            query = "SELECT id_oggetto FROM oggetti WHERE nome = '"+ n_ogg +"'";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            if(rs.next()){
                id_ogge = rs.getInt("id_oggetto");
            }
            stm.close();
            System.out.println(id_ogge);
            //ottengo la data odierna
            GregorianCalendar gc = new GregorianCalendar();
            int giorno = (int) gc.get(Calendar.DAY_OF_MONTH);
            int mese = (int) gc.get(Calendar.MONTH)+1;
            int anno = (int) gc.get(Calendar.YEAR);
            String data=String.valueOf(anno)+"/"+String.valueOf(mese)+"/"+String.valueOf(giorno);
            System.out.println(data);
            
            if(tipo==0){
                query = "INSERT INTO aste(durata_timeslot, data_creazione, stato, tipo_asta, perc_penale, utente_creator, oggetto_asta, tipo_timeslot, utente_offerta_max, offerta_max, num_off_rimanenti) "
                        + "values('"+ t +"','"+ data + "','0','"+ v + "','"+ pen+ "','"+ id_utente +"','"+ id_ogge +"','0','0','0','"+ t +"')";
            }else{
                query = "INSERT INTO aste(durata_timeslot, data_creazione, stato, tipo_asta, perc_penale, utente_creator, oggetto_asta, tipo_timeslot, utente_offerta_max, offerta_max, num_off_rimanenti) "
                        + "values('"+ tipo +"','"+ data + "','0','"+ v + "','"+ pen+ "','"+ id_utente +"','"+ id_ogge +"','1','0','0','"+ tipo +"')";
            }
            System.out.println(query);
            
            stm = conn.createStatement();
            x = stm.executeUpdate(query);
            
            stm.close();
            
            
            query ="UPDATE oggetti SET oggetti.stato = '1' WHERE id_oggetto = '"+ id_ogge +"'";
            System.out.println(query);
            
            stm = conn.createStatement();
            x = stm.executeUpdate(query);
            
            stm.close();
            conn.close();
            
            Home hm = new Home();
            setVisible(false);
            hm.setVisible(true);
            hm.setId(id_utente);
            hm.setRuolo(ruolo_utente);
            hm.setUsername(username);
            hm.setSaldotot(saldotot);
            hm.setSaldodisp(saldodisponibile);
            hm.setAstaPart(asta_partecipante);
        }catch(SQLException se){
            System.err.println(se);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         FillcomboOggetto();
         jButton1.setVisible(true);
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
            java.util.logging.Logger.getLogger(CreaAsta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreaAsta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreaAsta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreaAsta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreaAsta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
