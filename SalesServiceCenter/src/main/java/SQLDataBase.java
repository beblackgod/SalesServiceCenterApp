package main.java;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SQLDataBase {
    private Connection connection;
    private PreparedStatement addApplication;
    private PreparedStatement getApplicationList;
    private PreparedStatement checkAppID;
    private PreparedStatement changeApp;
    private PreparedStatement selectAndCountSubcategory;
    private PreparedStatement selectAndSumPriceInSubcategory;
    private PreparedStatement auth;
    private PreparedStatement selectOpenApplications;
    private PreparedStatement filterDate;
    private PreparedStatement filterCategory;

    //подключиться к БД
    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sscdatabase","*********","**********");
        addApplication = connection.prepareStatement(" INSERT INTO applications (id,date,client,email,phone,fio,category,subcategory,applicationText,status,chronology,performer,cpuResponsible,dateFinishPlan,dateFinishFact,time,price,nvNumber,nvDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        getApplicationList = connection.prepareStatement("SElECT * from applications");
        checkAppID = connection.prepareStatement("SELECT id FROM applications WHERE id=? ");
        changeApp = connection.prepareStatement("UPDATE applications SET id=?,date=?,client=?,email=?,phone=?,fio=?,category=?,subcategory=?,applicationText=?,status=?,chronology=?,performer=?,cpuResponsible=?,dateFinishPlan=?,dateFinishFact=?,time=?,price=?,nvNumber=?,nvDate=? WHERE id = ?");
        selectAndCountSubcategory = connection.prepareStatement("SELECT COUNT(*) AS countSubcategory FROM applications WHERE subcategory = ?");
        selectAndSumPriceInSubcategory = connection.prepareStatement("SELECT SUM(price) FROM applications WHERE subcategory =? ");
        auth = connection.prepareStatement("SELECT * FROM users WHERE userName= ?");
        selectOpenApplications = connection.prepareStatement("SElECT * from applications WHERE dateFinishFact='1000-01-01'");
        filterDate = connection.prepareStatement("SElECT * from applications WHERE date>=? AND date<=? ");
        filterCategory = connection.prepareStatement("SELECT * from applications WHERE ?=? ");
    }
//отключиться
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //добавить обращение
    public void setAddApplication(int id, String date, String client, String email, String phone, String fio, String category, String subcategory, String applicationText, String status, String chronology, String performer, String cpuResponsible, String dateFinishPlan, String dateFinishFact, String time, BigDecimal price, String nvNumber, String nvDate) throws SQLException {
        try {
            addApplication.setInt(1, id);
            addApplication.setString(2, date);
            addApplication.setString(3, client);
            addApplication.setString(4, email);
            addApplication.setString(5, phone);
            addApplication.setString(6, fio);
            addApplication.setString(7, category);
            addApplication.setString(8, subcategory);
            addApplication.setString(9, applicationText);
            addApplication.setString(10, status);
            addApplication.setString(11, chronology);
            addApplication.setString(12, performer);
            addApplication.setString(13, cpuResponsible);
            addApplication.setString(14, dateFinishPlan);
            addApplication.setString(15, dateFinishFact);
            addApplication.setString(16, time);
            addApplication.setBigDecimal(17, price);
            addApplication.setString(18, nvNumber);
            addApplication.setString(19, nvDate);
            addApplication.executeUpdate();
        } catch (SQLException e) {

        }
    }

    //сохранить изменения
    public void setChangeApp(int id, String date, String client, String email, String phone, String fio, String category, String subcategory, String applicationText, String status, String chronology, String performer, String cpuResponsible, String dateFinishPlan, String dateFinishFact, String time, BigDecimal price, String nvNumber, String nvDate) throws SQLException {
        try {
            changeApp.setInt(1, id);
            changeApp.setString(2, date);
            changeApp.setString(3, client);
            changeApp.setString(4, email);
            changeApp.setString(5, phone);
            changeApp.setString(6, fio);
            changeApp.setString(7, category);
            changeApp.setString(8, subcategory);
            changeApp.setString(9, applicationText);
            changeApp.setString(10, status);
            changeApp.setString(11, chronology);
            changeApp.setString(12, performer);
            changeApp.setString(13, cpuResponsible);
            changeApp.setString(14, dateFinishPlan);
            changeApp.setString(15, dateFinishFact);
            changeApp.setString(16, time);
            changeApp.setBigDecimal(17, price);
            changeApp.setString(18, nvNumber);
            changeApp.setString(19, nvDate);
            changeApp.setInt(20, id);
            changeApp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //проверить есть ли заявка с таким номером
    public ResultSet setCheckAppID(int id) {
        try {
            checkAppID.setInt(1, id);
            ResultSet rs = checkAppID.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //получить список обращений
    public List<Application> getApplicationList() {
        List<Application> applicationList = new ArrayList<>();
        try {
            ResultSet rs = getApplicationList.executeQuery();
            while (rs.next()) {
                DateFormat dfOut = new SimpleDateFormat("dd.MM.yyyy");
                DateFormat dfIn = new SimpleDateFormat("yyyy-MM-dd");
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setDate(rs.getString("date"));
                application.setClient(rs.getString("client"));
                application.setEmail(rs.getString("email"));
                application.setPhone(rs.getString("phone"));
                application.setFio(rs.getString("fio"));
                application.setCategory(rs.getString("category"));
                application.setSubcategory(rs.getString("subcategory"));
                application.setApplicationText(rs.getString("applicationText"));
                application.setStatus(rs.getString("status"));
                application.setChronology(rs.getString("chronology"));
                application.setPerformer(rs.getString("performer"));
                application.setCpuResponsible(rs.getString("cpuResponsible"));
                application.setDateFinishPlan(rs.getString("dateFinishPlan"));
                application.setDateFinishFact(rs.getString("dateFinishFact"));
                application.setTime(rs.getString("time"));
                application.setPrice(rs.getBigDecimal("price"));
                application.setNvNumber(rs.getString("nvNumber"));
                application.setNvDate(rs.getString("nvDate"));
                applicationList.add(application);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicationList;
    }

    //поиск обращениея по id
    public Application getApplicationById(int id) {
        List<Application> applicationList = getApplicationList();
        for (Application app : applicationList) {
            if (app.getId() == id) {
                return app;
            }
        }
        return null;
    }

    //подсчет количества обращений по подкатегории
    public int setSelectAndCountSubcategory(String subcategory){
        try {
            selectAndCountSubcategory.setString(1,subcategory);
            ResultSet rs = selectAndCountSubcategory.executeQuery();
            while (rs.next()) {
               int i = rs.getInt("countSubcategory");
               return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //подсчет дохода по категории
    public BigDecimal setSelectAndSumPriceInSubcategory(String subcategory) {
        try {
            selectAndSumPriceInSubcategory.setString(1,subcategory);
            ResultSet rs = selectAndSumPriceInSubcategory.executeQuery();
            while (rs.next()){
                BigDecimal bd =rs.getBigDecimal(1);
                return bd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BigDecimal.valueOf(0.00);
    }

    // уникальные подкатегории в treeset
    public TreeSet getListSubcategories() {
        TreeSet<String> ts = new TreeSet<>();
        try {
            ResultSet rs = getApplicationList.executeQuery();
            while (rs.next()) {
                String s = rs.getString("subcategory");
                ts.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ts;
    }

    //список записей для отчета по обращениям(подкатегория, количество, доход)
    public List<ReportRecord> getReportRecordList(){
        List<ReportRecord> reportRecordList = new ArrayList<>();
        TreeSet<String> ts = getListSubcategories();

        List<String> list = new ArrayList<>(ts);
        BigDecimal bd = BigDecimal.valueOf(0.00);
        for(int i=0;i<list.size();i++ ){
            ReportRecord reportRecord = new ReportRecord();
            reportRecord.setSubcategory(list.get(i));
            reportRecord.setQuantity(setSelectAndCountSubcategory(list.get(i)));
           // bd=bd + reportRecord.getPrice();
            reportRecord.setPrice(setSelectAndSumPriceInSubcategory(list.get(i)));
            reportRecordList.add(reportRecord);
        }
        return  reportRecordList;
    }

    //auth
    public ResultSet setAuth(String userName) {
        try {
            auth.setString(1, userName);
            ResultSet rs = auth.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //показать открытые обращения
    public List<Application> getOpenApplicationsList() {
        List<Application> applicationList = new ArrayList<>();
        try {
            ResultSet rs = selectOpenApplications.executeQuery();
            while (rs.next()) {
                DateFormat dfOut = new SimpleDateFormat("dd.MM.yyyy");
                DateFormat dfIn = new SimpleDateFormat("yyyy-MM-dd");
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setDate(rs.getString("date"));
                application.setClient(rs.getString("client"));
                application.setEmail(rs.getString("email"));
                application.setPhone(rs.getString("phone"));
                application.setFio(rs.getString("fio"));
                application.setCategory(rs.getString("category"));
                application.setSubcategory(rs.getString("subcategory"));
                application.setApplicationText(rs.getString("applicationText"));
                application.setStatus(rs.getString("status"));
                application.setChronology(rs.getString("chronology"));
                application.setPerformer(rs.getString("performer"));
                application.setCpuResponsible(rs.getString("cpuResponsible"));
                application.setDateFinishPlan(rs.getString("dateFinishPlan"));
                application.setDateFinishFact(rs.getString("dateFinishFact"));
                application.setTime(rs.getString("time"));
                application.setPrice(rs.getBigDecimal("price"));
                application.setNvNumber(rs.getString("nvNumber"));
                application.setNvDate(rs.getString("nvDate"));
                applicationList.add(application);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicationList;
    }

    //фильтр обращений по дате
    public List<Application> getApplicationsListWithDateFilter(String dateFrom,String dateTo) {
        List<Application> applicationList = new ArrayList<>();
        try {
            filterDate.setString(1,dateFrom);
            filterDate.setString(2,dateTo);
            ResultSet rs = filterDate.executeQuery();
            while (rs.next()) {
                DateFormat dfOut = new SimpleDateFormat("dd.MM.yyyy");
                DateFormat dfIn = new SimpleDateFormat("yyyy-MM-dd");
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setDate(rs.getString("date"));
                application.setClient(rs.getString("client"));
                application.setEmail(rs.getString("email"));
                application.setPhone(rs.getString("phone"));
                application.setFio(rs.getString("fio"));
                application.setCategory(rs.getString("category"));
                application.setSubcategory(rs.getString("subcategory"));
                application.setApplicationText(rs.getString("applicationText"));
                application.setStatus(rs.getString("status"));
                application.setChronology(rs.getString("chronology"));
                application.setPerformer(rs.getString("performer"));
                application.setCpuResponsible(rs.getString("cpuResponsible"));
                application.setDateFinishPlan(rs.getString("dateFinishPlan"));
                application.setDateFinishFact(rs.getString("dateFinishFact"));
                application.setTime(rs.getString("time"));
                application.setPrice(rs.getBigDecimal("price"));
                application.setNvNumber(rs.getString("nvNumber"));
                application.setNvDate(rs.getString("nvDate"));
                applicationList.add(application);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicationList;
    }

    //фильтр обращений по категориям
    public List<Application> getApplicationsListFilterByCategory(String category,String value) {
        List<Application> applicationList = new ArrayList<>();
        try {

            String [] arr ={"Номер","Клиент","Категория","Дата обращения","Дата закрытия(факт)","Ответственный ЦПУ","Исполнитель","Статус"};
            String [] arrSql ={"id","client","category","date","dateFinishPlan","cpuResponsible","performer","status"};

            for(int i=0;i<arr.length;i++){
                if(category.equals(arr[i])){
                    category = arrSql[i];
                }
            }
            System.out.println(category);
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from applications WHERE client  = '" + value+"'");

            while (rs.next()) {
                DateFormat dfOut = new SimpleDateFormat("dd.MM.yyyy");
                DateFormat dfIn = new SimpleDateFormat("yyyy-MM-dd");

                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setDate(rs.getString("date"));
                application.setClient(rs.getString("client"));
                application.setEmail(rs.getString("email"));
                application.setPhone(rs.getString("phone"));
                application.setFio(rs.getString("fio"));
                application.setCategory(rs.getString("category"));
                application.setSubcategory(rs.getString("subcategory"));
                application.setApplicationText(rs.getString("applicationText"));
                application.setStatus(rs.getString("status"));
                application.setChronology(rs.getString("chronology"));
                application.setPerformer(rs.getString("performer"));
                application.setCpuResponsible(rs.getString("cpuResponsible"));
                application.setDateFinishPlan(rs.getString("dateFinishPlan"));
                application.setDateFinishFact(rs.getString("dateFinishFact"));
                application.setTime(rs.getString("time"));
                application.setPrice(rs.getBigDecimal("price"));
                application.setNvNumber(rs.getString("nvNumber"));
                application.setNvDate(rs.getString("nvDate"));
                applicationList.add(application);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(applicationList);
        return applicationList;

    }
}

