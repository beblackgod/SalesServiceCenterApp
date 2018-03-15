package main.java;

import java.math.BigDecimal;

public class Application {
   private int id;
    private String date ;
    private String client;
    private String email;
    private String phone ;
    private String fio ;
    private String category ;
    private String subcategory ;
    private String applicationText ;
    private String status ;
    private String chronology ;
    private String performer;
    private String cpuResponsible ;
    private String dateFinishPlan ;
    private String dateFinishFact ;
    private String time;
    private BigDecimal price;
    private String nvNumber;
    private String nvDate;

    public Application(){

    }
    public Application(int id, String date, String client, String email, String phone, String fio, String category, String subcategory, String applicationText, String status, String chronology, String performer, String cpuResponsible, String dateFinishPlan, String dateFinishFact, String time, BigDecimal price, String nvNumber, String nvDate) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.email = email;
        this.phone = phone;
        this.fio = fio;
        this.category = category;
        this.subcategory = subcategory;
        this.applicationText = applicationText;
        this.status = status;
        this.chronology = chronology;
        this.performer = performer;
        this.cpuResponsible = cpuResponsible;
        this.dateFinishPlan = dateFinishPlan;
        this.dateFinishFact = dateFinishFact;
        this.time = time;
        this.price = price;
        this.nvNumber = nvNumber;
        this.nvDate = nvDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getApplicationText() {
        return applicationText;
    }

    public void setApplicationText(String applicationText) {
        this.applicationText = applicationText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChronology() {
        return chronology;
    }

    public void setChronology(String chronology) {
        this.chronology = chronology;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getCpuResponsible() {
        return cpuResponsible;
    }

    public void setCpuResponsible(String cpuResponsible) {
        this.cpuResponsible = cpuResponsible;
    }

    public String getDateFinishPlan() {
        return dateFinishPlan;
    }

    public void setDateFinishPlan(String dateFinishPlan) {
        this.dateFinishPlan = dateFinishPlan;
    }

    public String getDateFinishFact() {
        return dateFinishFact;
    }

    public void setDateFinishFact(String dateFinishFact) {
        this.dateFinishFact = dateFinishFact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNvNumber() {
        return nvNumber;
    }

    public void setNvNumber(String nvNumber) {
        this.nvNumber = nvNumber;
    }

    public String getNvDate() {
        return nvDate;
    }

    public void setNvDate(String nvDate) {
        this.nvDate = nvDate;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", client='" + client + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fio='" + fio + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", applicationText='" + applicationText + '\'' +
                ", status='" + status + '\'' +
                ", chronology='" + chronology + '\'' +
                ", performer='" + performer + '\'' +
                ", cpuResponsible='" + cpuResponsible + '\'' +
                ", dateFinishPlan='" + dateFinishPlan + '\'' +
                ", dateFinishFact='" + dateFinishFact + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", nvNumber='" + nvNumber + '\'' +
                ", nvDate='" + nvDate + '\'' +
                '}';
    }
}
