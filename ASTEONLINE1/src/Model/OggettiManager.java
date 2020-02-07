package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.Oggetti;
import Util.DBConnection;

public class OggettiManager {
	   private static final String TAB_NAME = "oggetti"; //Nome tabella nel DB

	    public String db;
	    public String username;
	    public String password;
	    public OggettiManager(String db, String username, String password)
	    {
	        this.db = db;
	        this.username = username;
	        this.password = password;
	    }

	    //Genera query INSERT per salvare un nuovo elemento all'interno del DB
	    public synchronized void doSave(Object object){
	        Oggetti oggetti = (Oggetti) object;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;


	        String insertSQL = "INSERT INTO " + OggettiManager.TAB_NAME + "(nome, prezzo, utente_fk, categoria_fk) VALUES (?, ?, ?, ?)";

	        try {
	            connection = DBConnection.getConnection(db, username, password);
	            preparedStatement = connection.prepareStatement(insertSQL);
	            preparedStatement.setString(1, oggetti.getNome());
	            preparedStatement.setDouble(2, oggetti.getPrezzo());
	            preparedStatement.setInt(3, oggetti.getUtente_fk());
	            preparedStatement.setInt(4, oggetti.getCategoria_fk());


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

	    //elimina oggetto
	    public synchronized boolean doDelete(int id)
	    {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        int result = 0;

	        String deleteSQL = "DELETE FROM " + OggettiManager.TAB_NAME + " WHERE id = ?";

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
	    
	    //Query lista di oggetti
	        
	        public synchronized List<Oggetti> doRetrieveAll() {

	            Connection connection = null;
	            PreparedStatement preparedStatement = null;

	            List<Oggetti> oggetti = new ArrayList<Oggetti>();

	            String selectSQL = "SELECT * FROM " + OggettiManager.TAB_NAME + "oggetti LEFT JOIN categorie "
		                + "ON oggetti.categoria_id = categorie.id_categoria "
		                + "WHERE oggetti.deleted = 0" ;
	            try {
	                connection = DBConnection.getConnection(db, username, password);
	                preparedStatement = connection.prepareStatement(selectSQL);

	                ResultSet rs = preparedStatement.executeQuery();

	                while (rs.next())
	                {
	                    Oggetti bean = new Oggetti();

	                    bean.setId_oggetto(rs.getInt("id_oggetto"));
	                    bean.setNome(rs.getString("nome"));
	                    bean.setPrezzo(rs.getDouble("prezzo"));
	                    bean.setUtente_fk(rs.getInt("utente"));
	                    bean.setCategoria_fk(rs.getInt("categoria"));
	                    
	                    oggetti.add(bean);
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
	            return oggetti;

	        }

	    
	    

}
