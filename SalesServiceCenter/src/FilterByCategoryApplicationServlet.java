import main.java.SQLDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FilterByCategoryApplicationServlet", urlPatterns = "/filterapptablebycategory")
public class FilterByCategoryApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String categoryFilter = request.getParameter("categoryFilter");
        String categoryValue = request.getParameter("categoryValue");
        System.out.println(categoryValue);
        SQLDataBase sqlDataBase = new SQLDataBase();
        try {
            sqlDataBase.connect();
            request.setAttribute("applications", sqlDataBase.getApplicationsListFilterByCategory(categoryFilter,categoryValue));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("./applicationTable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
