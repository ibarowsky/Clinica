package CommandPattern;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookingSwab extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String fc = (String) session.getAttribute("login");
		/*--------------------------------------------------*/
		InvokerBooking invokerBook = new InvokerBooking( new CommandBooking( new Reciver( fc )));
    invokerBook.list();
    /*--------------------------------------------------*/
    response.sendRedirect("UserInterface.jsp");
	}
}