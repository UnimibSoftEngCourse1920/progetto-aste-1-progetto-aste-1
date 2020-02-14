
package asteonline;



/**
 *
 * @author domniguez
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Oggetto extends javax.swing.JFrame {
     int ruolo_utente ;
     int id_utente;
     String username;
     double saldotot;
     double saldodisponibile;
     int asta_partecipante;
     int n=0;
     
		String idU	= "root";
		String pwd	= "ciao";
		String url	= "jdbc:mysql://localhost:3306/astedb?useTimezone=true&serverTimezone=UTC";
		
		String query 	= null;
		Connection conn = null;
		Statement stm	= null;
		ResultSet rs	= null;
                int x=0;
                
    public Oggetto() {
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
         Fillcombo();
         jLabel5.setVisible(false);
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
    
    public void Fillcombo(){
        try{
            query ="SELECT nome FROM categorie";
            System.out.println(query);
            
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                String nome = rs.getString("nome");
                jComboBox1.addItem(nome);
            }
        }catch(SQLException se){
            System.err.println(se);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("INSERIMENTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("INSERIMENTO OGGETTO");

        jLabel3.setText("NOME");

        jLabel1.setText("CATEGORIA");

        jButton2.setLabel("OGGETTI PRESENTI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_oggetto", "nome", "prezzo", "categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("PREZZO");

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("INSERIMENTO VALORI ERRATO O OGGETTO GIA' PRESENTE ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(96, 96, 96)
                                .addComponent(jButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)))
                        .addGap(40, 40, 40))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel5.setVisible(true);
        String nome=jTextField1.getText();
         boolean inserisci1 = true;
         boolean ins2 = false;
         int id_categoria=0;
         
       try{
           int v = Integer.parseInt(nome);      
           inserisci1 = false;                    
           System.out.println("inserisci1: "+inserisci1);
           
       }catch(Exception e){
           System.err.println(e);
       }
        String cat = jComboBox1.getSelectedItem().toString();
        
        String prez=jTextField2.getText();
       try{
           double q = Double.parseDouble(prez);   
           
           ins2 = true; 
           if(q<0){
               ins2=false;
           }
       }catch(Exception e){
           System.err.println(e);
       }
       
       if(inserisci1 == true && ins2 == true){
            
           try{
               query = "SELECT id_categoria FROM categorie WHERE nome = '"+ cat+"'" ;
               System.out.println(query);
               
               stm = conn.createStatement();
               rs = stm.executeQuery(query);
               
               if(rs.next()){
                    id_categoria = rs.getInt("id_categoria");
               }
             
               query = "INSERT INTO oggetti(nome, prezzo, utente_crea, categoria, stato)"
                       +"values('"+ nome +"','"+ prez +"','"+ id_utente +"','"+ id_categoria +"','0')";
               System.out.println(query);
               
               x= stm.executeUpdate(query);
                stm.close();
                jLabel5.setVisible(false);
                jTextField1.setText("");
                jTextField2.setText("");
           }catch(SQLException se){
               System.err.println(se);
           }
       }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Home hm = new Home();
        setVisible(false);
        hm.setVisible(true);
        hm.setRuolo(ruolo_utente);
        hm.setId(id_utente);
        hm.setUsername(username);
        hm.setSaldotot(saldotot);
        hm.setSaldodisp(saldodisponibile);
        hm.setAstaPart(asta_partecipante);
         try {
             conn.close();
         } catch (SQLException ex) {
             System.err.println(ex);
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
       
        
       if(n>0){
           for(int i=n-1;i>-1;i--){
               tableModel.removeRow(i);
           }
           n=0;
       }
        try{
            query ="SELECT oggetti.id_oggetto, oggetti.nome, oggetti.prezzo, categorie.nome FROM oggetti, categorie "
                    + "WHERE categorie.id_categoria = oggetti.categoria "
                    + "AND oggetti.utente_crea = '"+ id_utente +"'";
            System.out.println(query);
           
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            
            
            while(rs.next()){
                
               int id_og = rs.getInt("oggetti.id_oggetto");
               String nomog =rs.getString("oggetti.nome");
               double pr = rs.getDouble("oggetti.prezzo");
               String cat = rs.getString("categorie.nome");
              
           
                tableModel.addRow(new Object[]{id_og, nomog, pr, cat});   
                n++;
            }
            System.out.println(n);
              stm.close();  
              
        }catch(SQLException se){
            System.err.println(se);
        }
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
            java.util.logging.Logger.getLogger(Oggetto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oggetto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oggetto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oggetto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Oggetto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
