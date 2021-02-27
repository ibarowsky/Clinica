package StatePattern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateTampone extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tampone tamp = new Tampone();
		Stato statoTamp = tamp.currentState();
		tamp.setId(request.getParameter("idprenot"));
		
		statoTamp.manageState(tamp,request.getParameter("esito"));
		statoTamp = tamp.currentState();
		statoTamp.manageState(tamp,request.getParameter("esito"));
		
		RequestDispatcher rd=request.getRequestDispatcher("MedicoInterface.jsp"); //redirect to welcome.jsp page
        rd.forward(request, response); 
	}
}