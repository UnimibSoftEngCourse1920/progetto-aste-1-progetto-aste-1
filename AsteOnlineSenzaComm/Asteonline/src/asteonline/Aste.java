
package asteonline;

/**
 *
 * @author andre
 */
import java.sql.*;

public class Aste extends javax.swing.JFrame {

     int ruolo_utente ;
     int id_utente;
     int id_asta;
     String username;
     double saldotot;
     double saldodisponibile;
     
     int id_cr = 0;
     String nomOg = null;
     double prezOg = 0;
     int tipA = 3;
     double offmax = 0;
     int offRim = -1;
     int astP = 0;
     int utOfMax = 0;
     double off = 0;
     int numOffMax = 0;
     double offPmax = 0; 
     
     
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
                
    public Aste() {
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
                
                jLabel1.setVisible(false); // nome oggetto
                jLabel4.setVisible(false); //messaggio opzione busta chiusa visibile solo con tipo asta 1
                jLabel8.setVisible(false); //scritta puntate rimaste
                jLabel9.setVisible(false); //numero puntate rimaste
                jLabel2.setVisible(false); //messaggio offerta corrente visibile solo con tipo asta 0
                jLabel3.setVisible(false); //valore offerta corrente visibile solo con tipo asta 0
                jLabel5.setVisible(false); //messaggio offerta personale visibile solo con tipo asta 1
                jLabel6.setVisible(false); //valore offerta personale visibile solo con tipo asta 1
                jLabel7.setVisible(false); //messaggio inserisci offerta
                jLabel12.setVisible(false);//messaggio prezzo iniziale
                jLabel13.setVisible(false);//valere prezzo oggetto iniziale
                jTextField1.setVisible(false); //campo in cui inserire l'offerta
                jButton3.setVisible(false); //bottone fai offerta
                jLabel14.setVisible(false); //si vede solo se sei il creatore dell'asta
                jLabel15.setVisible(false); //messaggio inserimento offerta errato
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
        jLabel11.setText(this.saldodisponibile+ " €");
    }
    
    public void AggiornamentoGuiTipoAperto(int offerte_rim, double saldodisp, double offcorrente){
        jLabel11.setText(String.valueOf(saldodisp));
        jLabel9.setText(String.valueOf(offerte_rim));
        jLabel3.setText(String.valueOf(offcorrente));
    }
    
    public void AggiornamentoSaldoDispUt(double saldodisp){
        try{
            query = "UPDATE utenti "
                  + "SET saldo_disponibile = '"+ saldodisp +"' "
                  + "WHERE id_utente = '"+ id_utente +"'";
            System.out.println(query);
                        
            stm = conn.createStatement();
            x = stm.executeUpdate(query);
            System.out.println("aggiornamento saldo_disponibile effettuato");
                        
            stm.close();
            
        }catch(SQLException se){
            System.err.println(se);
        }
    }
    
    public void AggiornamentoGuiTipoChiuso(int offerte_rim, double saldodisp, double offPersonale){
        jLabel11.setText(String.valueOf(saldodisp));
        jLabel9.setText(String.valueOf(offerte_rim));
        jLabel6.setText(String.valueOf(offPersonale));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("NOME OGGETTO");

        jLabel2.setText("Offerta corrente: ");

        jLabel3.setText("Valore offerta");

        jLabel4.setText("BUSTA CHIUSA: OFFERTE NASCOSTE");

        jLabel5.setText("Offerta personale: ");

        jLabel6.setText("Valore offerta");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Inserire l'offerta");

        jLabel8.setText("Numero offerte rimanente: ");

        jLabel9.setText("Numero offerte rimanenti");

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Saldo disponibile: ");

        jLabel11.setText("valore saldo disp");

        jButton2.setText("MOSTA INFO DELL'ASTA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Fai offerta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setText("Prezzo iniziale:");

        jLabel13.setText("valore prezzo oggetto");

        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("NON PUOI FARE OFFERTE PERCHE' SEI IL CREATORE");

        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("VALORE NON VALIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13)
                                            .addGap(50, 50, 50))))
                                .addComponent(jLabel14)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(28, 28, 28)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(12, 12, 12))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Home hm = new Home();
        setVisible(false);
        hm.setVisible(true);
        hm.setId(id_utente);
        hm.setRuolo(ruolo_utente);
        hm.setUsername(username);
        hm.setSaldotot(saldotot);
        hm.setSaldodisp(saldodisponibile);
        hm.setAstaPart(astP);
         try {
             conn.close();
         } catch (SQLException ex) {
             System.err.println(ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        jButton2.setVisible(false);
        jButton1.setVisible(true);
        try{
            query = "SELECT aste.utente_creator, oggetti.nome, oggetti.prezzo, aste.tipo_asta, aste.offerta_max, aste.num_off_rimanenti, aste.utente_offerta_max, aste.durata_timeslot "
                    + "FROM oggetti, aste "
                    + "WHERE aste.oggetto_asta = oggetti.id_oggetto "
                    + "AND aste.id_asta = '"+ id_asta +"'";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            if(rs.next()){
                id_cr = rs.getInt("aste.utente_creator");
                nomOg = rs.getString("oggetti.nome");
                prezOg = rs.getDouble("oggetti.prezzo");
                tipA = rs.getInt("aste.tipo_asta");
                offmax = rs.getDouble("aste.offerta_max");
                offRim = rs.getInt("aste.num_off_rimanenti");
                utOfMax = rs.getInt("aste.utente_offerta_max");
                numOffMax = rs.getInt("aste.durata_timeslot");
            }
            stm.close();
            
            query ="SELECT asta_partecipante "
                        + "FROM utenti "
                        + "WHERE id_utente = '"+ id_utente +"'";
                
                stm = conn.createStatement();
                rs = stm.executeQuery(query);
                
                if(rs.next()){
                    astP = rs.getInt("asta_partecipante");
                }
                stm.close();
            
            if(tipA == 0){ // classica
                jLabel1.setText(nomOg);
                jLabel1.setVisible(true); // nome oggetto
                jLabel8.setVisible(true); //scritta puntate rimaste
                jLabel9.setText(String.valueOf(offRim));
                jLabel9.setVisible(true); //numero puntate rimaste
                jLabel2.setVisible(true); //messaggio offerta corrente visibile solo con tipo asta 0
                jLabel3.setText(String.valueOf(offmax));
                jLabel3.setVisible(true); //valore offerta corrente visibile solo con tipo asta 0
                jLabel7.setVisible(true); //messaggio inserisci offerta
                jTextField1.setVisible(true); //campo in cui inserire l'offerta
                jLabel12.setVisible(true);//messaggio prezzo iniziale
                jLabel13.setText(String.valueOf(prezOg));
                jLabel13.setVisible(true);//valere prezzo oggetto iniziale
                
            }else{ //busta chiusa
                jLabel4.setVisible(true); //messaggio opzione busta chiusa visibile solo con tipo asta 1
                jLabel1.setText(nomOg);
                jLabel1.setVisible(true); // nome oggetto
                jLabel8.setVisible(true); //scritta puntate rimaste
                jLabel9.setText(String.valueOf(offRim));
                jLabel9.setVisible(true); //numero puntate rimaste
                jLabel7.setVisible(true); //messaggio inserisci offerta
                jTextField1.setVisible(true); //campo in cui inserire l'offerta
                jLabel12.setVisible(true);//messaggio prezzo iniziale
                jLabel13.setText(String.valueOf(prezOg));
                jLabel13.setVisible(true);//valere prezzo oggetto iniziale
                jLabel5.setVisible(true); //messaggio offerta personale visibile solo con tipo asta 1
                jLabel6.setVisible(true); //valore offerta personale visibile solo con tipo asta 1
                
                
                if(id_asta == astP){ //controllo se l'utente sta gia partecipando a questa offerta
                    if(id_utente == utOfMax){//se l'utente e' quello con l'offerta max assegno offmax
                        offPmax = offmax;
                        jLabel6.setText(String.valueOf(offPmax));
                    }else{
                        offPmax = saldotot - saldodisponibile; //altrimenti metto la sottrazione tra saldo totale e saldo disponibile(questo perchè puo' partecipare solo ad un asta alla volta)
                        jLabel6.setText(String.valueOf(offPmax));
                    }
                }else{
                    offPmax = 0;
                    jLabel6.setText("0");
                }
            }
            
             if(id_utente == id_cr){
                 jLabel14.setVisible(true);
             }else{
                 jButton3.setVisible(true);
             }
            
             
             
        }catch(SQLException se){
            System.err.println(se);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        boolean isNum = false;
        boolean numRight = true;
        String offs = jTextField1.getText();
        jLabel15.setVisible(true);
        try{
            off = Double.parseDouble(offs);
            isNum = true;
            jLabel15.setVisible(false);
        }catch(Exception e){
            System.err.println(e);
        }
        
        if(off > saldodisponibile){
            numRight = false;
            jLabel15.setVisible(true);
        }
        //controllo se l'asta è APERTA (tipo_asta = 0)
        if(tipA == 0 && isNum == true && numRight == true){
            //controllo che l'offerta inserita sia > dell'offerta corrente e >= dell'offerta iniziale
            if(off > offmax && off >= prezOg){
                //setto l'offerta max con l'offerta corrente
                offmax = off; 
                //controllo se l'utente e' un nuovo partecipante o meno 
                if(astP == 0){//setto asta_partecipante come l'id dell'asta a cui sta partecipando
                    astP = id_asta;
                    try{
                        query = "UPDATE utenti "
                                + "SET utenti.asta_partecipante = '"+ astP +"' "
                                + "WHERE id_utente = '"+ id_utente +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Cambiamento in utente partecipante effettuato");
                        
                        stm.close();
            
                    }catch(SQLException se){
                        System.err.println(se);
                    }
                }
                //controllo se questa e' la prima offerta dell'asta
                if(offRim == numOffMax){
                    try{
                        //decremento le offerte rimananti
                        offRim--; 
                        //setto stato asta = 1(in esecuzione), setto l'offerta_max e l'id dell'utente che ha fatto l'offerta, e il numero delle offerte rimanenti
                        query ="UPDATE aste "
                                + "SET stato = '1' , offerta_max = '"+ offmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Aggiornamentotipo1 stato asta, off_max, utente_off_max, num_off_rim effettuato");
                        
                        stm.close();
                        
                        
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                       
                        AggiornamentoGuiTipoAperto(offRim, saldodisponibile, offmax);
            
                    }catch(SQLException se){
                      System.err.println(se);
                    }
                }else if(offRim < numOffMax && offRim > 1){
                    try{
                        //decremento le offerte rimananti
                        offRim--;
                        query = "UPDATE aste "
                                + "SET offerta_max = '"+ offmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Aggiornamentotipo2 off_max, utente_off_max, num_off_rim effettuato");
                        
                        stm.close();
                        
                        //aggiorno saldo disponibile
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                        //aggiornare valori pagina
                        AggiornamentoGuiTipoAperto(offRim, saldodisponibile, offmax);
                        
                    }catch(SQLException se){
                       System.err.println(se);
                    }
                }else if(offRim == 1){
                    try{
                        //decremento le offerte rimananti
                        offRim--;
                        //setto stato asta = 2(terminata), setto l'offerta_max e l'id dell'utente che ha fatto l'offerta, e il numero delle offerte rimanenti che sara' 0
                        query ="UPDATE aste "
                                + "SET stato = '2' , offerta_max = '"+ offmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Aggiornamentotipo3 stato asta, off_max, utente_off_max, num_off_rim effettuato");
                        
                        stm.close();
            
                        //aggiorno saldo disponibile
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                        //creare query per riempire tabella offerte
                        query = "INSERT INTO offerte(prezzo, asta_associata, utente_vincente, totale_rimborsato) "
                                + "values('"+offmax +"','"+ id_asta +"','"+ id_utente +"','0')";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        
                        stm.close();
                        conn.close();
                        
                        //aprire pagina asta Conclusa e passare i valori
                        AstaConclusa ac= new AstaConclusa();
                        setVisible(false);
                        ac.setVisible(true);
                        ac.setId(id_utente);
                        ac.setRuolo(ruolo_utente);
                        ac.setUsername(username);
                        ac.setSaldotot(saldotot);
                        ac.setSaldodisp(saldodisponibile);
                        ac.setIdasta(id_asta);
                        
                    }catch(SQLException se){
                        System.err.println(se);
                    }
                    
                }// end if offRim == 1 BUSTA APERTA
                
                
            }else{
                jLabel15.setVisible(true);
            }
        }else if(tipA == 1 && isNum == true && numRight == true){
            //controllo se l'offerta fatta sia > dell'offerta personale e >= del prezzo iniziale
            if(off > offPmax && off >= prezOg){
                //setto l'offerta personale max con l'offerta corrente
                offPmax = off;
                //controllo se l'utente e' un nuovo partecipante o meno 
                if(astP == 0){//setto asta_partecipante come l'id dell'asta a cui sta partecipando
                    astP = id_asta;
                    try{
                        query = "UPDATE utenti "
                                + "SET utenti.asta_partecipante = '"+ astP +"' "
                                + "WHERE id_utente = '"+ id_utente +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Cambiamento in utente partecipante effettuato");
                        
                        stm.close();
            
                    }catch(SQLException se){
                        System.err.println(se);
                    }
                }
                //controllo se questa e' la prima offerta dell'asta
                if(offRim == numOffMax){
                    try{
                        //decremento il numero di offerte rimanenti
                        offRim--;
                        //setto l'offerta massima dell'asta come offPmax
                        offmax = offPmax;
                       
                        //setto stato asta = 1(in esecuzione), setto l'offerta_max e l'id dell'utente che ha fatto l'offerta, e il numero delle offerte rimanenti
                        query ="UPDATE aste "
                                + "SET stato = '1' , offerta_max = '"+ offPmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        x = stm.executeUpdate(query);
                        System.out.println("Aggiornamentotipo1 stato asta, off_max, utente_off_max, num_off_rim effettuato");
                        
                        stm.close();
                        
                        //aggiorno valore saldo_disponibile
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                        //aggiorno gui BUSTA CHIUSA
                        AggiornamentoGuiTipoChiuso(offRim, saldodisponibile, offPmax);
                        
                    }catch(SQLException se){
                        System.err.println(se);
                    }  
                }else if(offRim < numOffMax && offRim > 1){
                    try{
                        //decremento le offerte rimananti
                        offRim--;
                        if(offPmax > offmax){
                            //setto l'offerta max dell'asta come l'offerta personale massima
                            offmax = offPmax;
                            
                            query = "UPDATE aste "
                                + "SET offerta_max = '"+ offPmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                            System.out.println("Aggiornamentotipo2 off_max, utente_off_max, num_off_rim effettuato");
                        
                            stm.close();
                            
                        }else{
                            query = "UPDATE aste "
                                + "SET num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                            System.out.println("Aggiornamentotipo4 num_off_rim effettuato");
                        
                            stm.close();
                        }
                        
                        //aggiorno valore saldo_disponibile
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                        //aggiorno gui BUSTA CHIUSA
                        AggiornamentoGuiTipoChiuso(offRim, saldodisponibile, offPmax);
                        
                        
                    }catch(SQLException se){
                        System.err.println(se);
                    }    
                }else if(offRim == 1){
                    try{
                        //decremento il numero di offerte rimanenti
                        offRim--;
                        //controllo se l'offerta personale massima e' maggiore dell'offerta massima dell'asta
                        if(offPmax > offmax){
                            //setto l'offerta max dell'asta come l'offerta personale massima
                            offmax = offPmax;
                            query ="UPDATE aste "
                                + "SET stato = '2' , offerta_max = '"+ offPmax +"', utente_offerta_max = '"+ id_utente +"', num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                            System.out.println("Aggiornamentotipo3 stato asta, off_max, utente_off_max, num_off_rim effettuato");
                        
                            stm.close();
                            
                        }else{
                            query ="UPDATE aste "
                                + "SET stato = '2' , num_off_rimanenti = '"+ offRim +"' "
                                + "WHERE id_asta = '"+ id_asta +"'";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                            System.out.println("Aggiornamentotipo5 stato asta, num_off_rim effettuato");
                        
                            stm.close();
                        }
                        
                        //aggiorno valore saldo_disponibile
                        saldodisponibile = saldotot - off;
                        AggiornamentoSaldoDispUt(saldodisponibile);
                        
                        //ottengo l'id dell'utente che ha fatto l'offerta maggiore tra tutte
                        query = "SELECT utente_offerta_max "
                                + "FROM aste "
                                + "WHERE id_asta = '"+ id_asta +"'";
                        System.out.println(query);
                        
                        stm = conn.createStatement();
                        rs = stm.executeQuery(query);
                        
                        if(rs.next()){
                            utOfMax = rs.getInt("utente_offerta_max");
                        }
                        
                        stm.close();
                        
                        //inserisco la riga nella tabella offerta con l'id del vincitore
                        if(utOfMax == id_utente){
                            query = "INSERT INTO offerte(prezzo, asta_associata, utente_vincente, totale_rimborsato) "
                                + "values('"+offmax +"','"+ id_asta +"','"+ id_utente +"','0')";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                        
                            stm.close();
                            conn.close();
                        }else{
                            query = "INSERT INTO offerte(prezzo, asta_associata, utente_vincente, totale_rimborsato) "
                                + "values('"+offmax +"','"+ id_asta +"','"+ utOfMax +"','0')";
                            System.out.println(query);
                        
                            stm = conn.createStatement();
                            x = stm.executeUpdate(query);
                        
                            stm.close();
                            conn.close();
                        }
                        
                        //aprire pagina AstaConclusa e passare i valori
                        
                        AstaConclusa ac= new AstaConclusa();
                        setVisible(false);
                        ac.setVisible(true);
                        ac.setId(id_utente);
                        ac.setRuolo(ruolo_utente);
                        ac.setUsername(username);
                        ac.setSaldotot(saldotot);
                        ac.setSaldodisp(saldodisponibile);
                        ac.setIdasta(id_asta);
                        
                    }catch(SQLException se){
                        System.err.println(se);
                    }   
                } //end if offRim == 1 ASTA BUSTA CHIUSA
                     
            }else{
                jLabel15.setVisible(true);
            }
        }
        
        
        /*try{
            
            
            
        }catch(SQLException se){
            System.err.println(se);
        }*/
        
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
            java.util.logging.Logger.getLogger(Aste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
