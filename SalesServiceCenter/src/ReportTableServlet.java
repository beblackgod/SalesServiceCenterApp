
import main.java.SQLDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ReportTableServlet", urlPatterns = "/reports")
public class ReportTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SQLDataBase sqlDataBase = new SQLDataBase();
        try {
            sqlDataBase.connect();
            request.setAttribute("reportRecords", sqlDataBase.getReportRecordList());
            request.setAttribute("test", "test");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("./reportTable.jsp").forward(request, response);
    }
}
