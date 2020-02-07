package Controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Utenti;
import Model.UtentiManager;

@WebServlet("/AddUtenti")
public class AddUtenti extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static boolean isDataSource = true;
    static String db = "asteonline1";
    static String username = "root";
    static String password = "mariacilento96";

    static UtentiManager manager = new UtentiManager(db, username, password);

    public AddUtenti() {
        super();
    }

    /**
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String indirizzo = request.getParameter("Idirizzo");
        String città = request.getParameter("città");
        String ruolo = request.getParameter("ruolo");

        Utenti utente = new Utenti();

        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setUsername(username);
        utente.setPassword(password);
        utente.setIndirizzo(indirizzo);
        utente.setCittà(città);
        utente.setRuolo(ruolo);

        try {
            manager.doSave(utente);

        } catch(NullPointerException e){
            e.printStackTrace();
        }


        //DA MODIFICARE
        RequestDispatcher dispositivo = getServletContext().getRequestDispatcher("/AccountServlet?action=doRetrieveAll");
        dispositivo.forward(request, response);

    }

}