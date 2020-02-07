package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.Categorie;
import Util.DBConnection;

public class CategorieManager {
	private static final String TAB_NAME = "categorie"; //Nome tabella nel DB

    public String db;
    public String username;
    public String password;
    public CategorieManager(String db, String username, String password)
    {
        this.db = db;
        this.username = username;
        this.password = password;
    }

    //Genera query INSERT per salvare un nuovo elemento all'interno del DB
    public synchronized void doSave(Object object){
       Categorie categorie = (Categorie) object;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        String insertSQL = "INSERT INTO " + CategorieManager.TAB_NAME + "(nome, utente_fk) VALUES (?, ?)";

        try {
            connection = DBConnection.getConnection(db, username, password);
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, categorie.getNome());
            preparedStatement.setInt(2, categorie.getUtente_fk());



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

    //elimina categoria
    public synchronized boolean doDelete(int id)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int result = 0;

        String deleteSQL = "DELETE FROM " + CategorieManager.TAB_NAME + " WHERE id = ?";

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


}


