package StrategyPattern;

import java.io.IOException;
import com.itextpdf.text.Document;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reports extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context cx = new Context();
		String status = request.getParameter("status");
		if(status.equals("monthly")) {
			cx.setStrategyStats(new monthlyReportStats());
		} else if (status.equals("weekly")) {
			cx.setStrategyStats(new weeklyReportStats());
		} else if (status.equals("daily")) {
			cx.setStrategyStats(new dailyReportStats());
		}
		cx.getStrategyStats();
		response.sendRedirect("AdminInterface.jsp");
	}
}