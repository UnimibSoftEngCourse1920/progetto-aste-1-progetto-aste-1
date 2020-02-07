package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Utenti;
import Model.UtentiManager;
/*          <source>1.8</source>
          <target>1.8</target>
          */

@WebServlet("/UtentiServlet")
public class UtentiServlet<Utenti> extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static boolean isDataSource = true;
    static String db = "asteonline1";
    static String username = "root";
    static String password = "mariacilento96";

    static UtentiManager manager = new UtentiManager(db, username, password);


    public  UtentiServlet() {
        super();
    }



    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Riceve il parametro
        String action = request.getParameter("action");
        Utenti utenti = (Utenti) request.getSession().getAttribute("utente");

    }
}



