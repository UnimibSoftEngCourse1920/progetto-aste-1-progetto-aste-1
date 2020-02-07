package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.Utenti;
import Util.DBConnection;

public class UtentiManager
{
    private static final String TAB_NAME = "utenti"; //Nome tabella nel DB

    public String db;
    public String username;
    public String password;
    public UtentiManager(String db, String username, String password)
    {
        this.db = db;
        this.username = username;
        this.password = password;
    }

    //Genera query INSERT per salvare un nuovo elemento all'interno del DB
    public synchronized void doSave(Object object){
        Utenti utenti = (Utenti) object;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        String insertSQL = "INSERT INTO " + UtentiManager.TAB_NAME + "(nome, cognome, e_mail, username, password, indirizzo, città, ruolo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, utenti.getNome());
            preparedStatement.setString(2, utenti.getCognome());
            preparedStatement.setString(3, utenti.getEmail());
            preparedStatement.setString(4, utenti.getUsername());
            preparedStatement.setString(4, utenti.getPassword());
            preparedStatement.setString(4, utenti.getIndirizzo());
            preparedStatement.setString(4, utenti.getCittà());
            preparedStatement.setString(5, utenti.getRuolo());



            System.out.println(preparedStatement.toString());

            preparedStatement.executeUpdate();

            //connection.commit();
        } catch(SQLException e){
            e.printStackTrace();
        }  finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            finally {
                try {
                    DBConnection.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //elimina utente
    public synchronized boolean doDelete(int id)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + UtentiManager.TAB_NAME + " WHERE id = ?";

        try
        {
            connection = DBConnection.getConnection(db,username,password);
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);

            result = preparedStatement.executeUpdate();
            connection.commit();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if(preparedStatement!=null)
                    preparedStatement.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    DBConnection.releaseConnection(connection);
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return (result!=0);
    }


    //Genera query SELECT per ricevere i dati in base ad una determinata key

    public synchronized Utenti doRetrieveById(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Utenti bean = new Utenti();

        String selectSQL = "SELECT * FROM " + UtentiManager.TAB_NAME + " WHERE id_account = ?";

        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                
                bean.setId_utente(rs.getInt("id_utente"));
                bean.setNome(rs.getString("nome"));
                bean.setCognome(rs.getString("cognome"));
                bean.setEmail(rs.getString("e_mail"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setIndirizzo(rs.getString("indirizzo"));
                bean.setCittà(rs.getString("città"));  
                bean.setRuolo(rs.getString("ruolo"));
                bean.setSaldo(rs.getDouble("saldo"));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }  finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DBConnection.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    
    
    //Query che ritorna la lista degli utenti
    public synchronized List<Utenti> doRetrieveAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Utenti> utenti = new ArrayList<Utenti>();

        String selectSQL = "SELECT * FROM " + UtentiManager.TAB_NAME;
        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(selectSQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                Utenti bean = new Utenti();

                bean.setId_utente(rs.getInt("id_utente"));
                bean.setNome(rs.getString("nome"));
                bean.setCognome(rs.getString("cognome"));
                bean.setEmail(rs.getString("e_mail"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setIndirizzo(rs.getString("indirizzo"));
                bean.setCittà(rs.getString("città"));  
                bean.setRuolo(rs.getString("ruolo"));
                bean.setSaldo(rs.getDouble("saldo"));
                utenti.add(bean);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }  finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DBConnection.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return utenti;

    }

    
    
    
    
    
    public synchronized Utenti doRetrieveByEmail(String email) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Utenti bean = new Utenti();

        String selectSQL = "SELECT utenti.id_utente, utenti.nome, utenti.cognome, utenti.e_mail, utenti.username, utenti.password, utenti.indirizzo, utenti.città, utenti.ruolo, utenti.saldo FROM " +
                UtentiManager.TAB_NAME + " WHERE account.e_mail = ?";
        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	bean.setId_utente(rs.getInt("id_utente"));
                bean.setNome(rs.getString("nome"));
                bean.setCognome(rs.getString("cognome"));
                bean.setEmail(rs.getString("e_mail"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setIndirizzo(rs.getString("indirizzo"));
                bean.setCittà(rs.getString("città"));  
                bean.setRuolo(rs.getString("ruolo"));
                bean.setSaldo(rs.getDouble("saldo"));
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DBConnection.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;

    }
  
    
    public synchronized void doUpdate(Object object) {

        Utenti utenti = (Utenti) object;
        utenti = doRetrieveByEmail(utenti.getEmail());

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "UPDATE " + UtentiManager.TAB_NAME + " " +
                "SET nome = ?, cognome = ?, password = ? " +
                "WHERE id_account = ? ;";


        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(insertSQL);

           

            preparedStatement.setString(1, utenti.getNome());
            preparedStatement.setString(2, utenti.getCognome());
            preparedStatement.setString(3, utenti.getPassword()); 
            preparedStatement.setInt(4, utenti.getId_utente());
            

            System.out.println(preparedStatement.toString());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DBConnection.releaseConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    

}
