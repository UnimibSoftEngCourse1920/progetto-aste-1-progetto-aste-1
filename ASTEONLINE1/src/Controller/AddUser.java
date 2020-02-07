package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



import Bean.Utenti;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(description = "Servelet per loggare un utente", urlPatterns = { "/adduser" })
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		

		Session session = factory.openSession();
		session.beginTransaction();
		Utenti u = new Utenti(0, request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("email"), request.getParameter("username"), request.getParameter("password"), request.getParameter("indirizzo") ,request.getParameter("città"), request.getParameter("ruolo"), null);
		session.save(u);
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("useradd.jsp");
		view.forward(request, response);
		
		
		

		
	}

}
