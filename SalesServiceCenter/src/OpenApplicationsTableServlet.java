import main.java.SQLDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OpenApplicationsTableServlet",urlPatterns = "/openapplications")
public class OpenApplicationsTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String b = request.getParameter("chbOpenClose");
        System.out.println(b);
        SQLDataBase sqlDataBase = new SQLDataBase();
        try {
            sqlDataBase.connect();
            //if(b){
                request.setAttribute("applications", sqlDataBase.getOpenApplicationsList());//}
                request.setAttribute("ch","on");
            //else{
                //request.setAttribute("applications", sqlDataBase.getApplicationList());
            //}
            System.out.println(b);
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
