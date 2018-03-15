
import main.java.SQLDataBase;
import main.java.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AuthControllerServlet", urlPatterns = "/tryAuth")
public class AuthControllerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        SQLDataBase sqlDataBase = new SQLDataBase();

        User user = new User();

        try {
            sqlDataBase.connect();
            ResultSet rs = sqlDataBase.setAuth(login);
            if(rs.next()){
                user.setUser(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(login.equals(user.getUser()) && password.equals(user.getPassword())){
            HttpSession session = request.getSession();
           session.setAttribute("user",user);
           //response.sendRedirect("./applications");
            request.getRequestDispatcher("WEB-INF/pages/applicationTable.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errorMsg","Неправильный логин или пароль");
            request.getRequestDispatcher("./login.html").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
