

import main.java.SQLDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;


@javax.servlet.annotation.WebServlet(name = "messageForm", urlPatterns = "/createapp")
public class CreationApplicationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("idForm"));
        String date = request.getParameter("date");
        String client =  request.getParameter("clientForm");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String fio = request.getParameter("fio");
        String category = request.getParameter("category");
        String subcategory = request.getParameter("subcategory");
        String applicationText = request.getParameter("applicationText");
        String status = request.getParameter("status");
        String chronology = request.getParameter("chronology");
        String performer = request.getParameter("performer");
        String cpuResponsible = request.getParameter("cpuResponsible");
        String dateFinishPlan = request.getParameter("dateFinishPlan");
        String dateFinishFact = request.getParameter("dateFinishFact");
        String time = request.getParameter("time");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        //BigDecimal price =new BigDecimal(0.00);
        String nvNumber = request.getParameter("nvNumber");
        String nvDate = request.getParameter("nvDate");

        SQLDataBase sqlDataBase = new SQLDataBase();
        try {
            sqlDataBase.connect();
            ResultSet checkIdRs = sqlDataBase.setCheckAppID(id);
            if(!checkIdRs.next()){
            sqlDataBase.setAddApplication(id,date,client,email,phone,fio,category,subcategory,applicationText,status,chronology,performer,cpuResponsible,dateFinishPlan,dateFinishFact,time,price,nvNumber,nvDate);}
            else{
                sqlDataBase.setChangeApp(id,date,client,email,phone,fio,category,subcategory,applicationText,status,chronology,performer,cpuResponsible,dateFinishPlan,dateFinishFact,time,price,nvNumber,nvDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            sqlDataBase.disconnect();
        }
        response.sendRedirect("/applications");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("./applicationTable.jsp").forward(request,response);
    }
}
