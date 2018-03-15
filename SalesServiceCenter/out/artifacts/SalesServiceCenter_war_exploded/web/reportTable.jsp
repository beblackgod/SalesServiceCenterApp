<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12.08.2017
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<html>
<head>
    <title>Центр продажи услуг</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="teststyle.css">
    <style>
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0 1000px white inset !important;
        }
    </style>
</head>
<body class="applicationPage">
<div class="">
    <div class="applicationPageHeader">
        <div class="applicationPageHeaderCell" style="cursor: pointer;" onclick="window.location='./applications';">Обращения</div>
        <div class="applicationPageHeaderCellChoose" style="cursor: pointer;" onclick="window.location='./reports';">Отчеты</div>
        <div class="applicationPageHeaderCell">Настройки</div>
    </div>
    <div class="applicationSubHeader">
        <div class="dateSearchPanel">
            <input type="date" class="search"></input>
            <input type="date" class="search"></input>
            <button class="btnFilterDate"><img src="icons/search.png" height="45" width="45" align="bottom"/>
            </button>
            <div class="togglePanel">
                <span class="switchText">Все</span>
                <label class="switch">
                    <input type="checkbox" >;
                    <span class="slider round"></span>
                </label>
                <span class="switchText">Открытые</span>
            </div>
            <div class="togglePanel">
                <span class="switchText">Все</span>
                <label class="switch">
                    <input type="checkbox" >;
                    <span class="slider round"></span>
                </label>
                <span class="switchText">Только мои</span>
            </div>
        </div>
    </div>
    <div class="analysisTable">
        <div class="analysisTableRow">
            <div class="analysisTableCell">
                <img class="imgReport" src="icons/rubles.png" height="90" width="90" align="bottom"/>
            </div>
            <div class="analysisTableCell">
                <img class="imgReport" src="icons/support.png" height="80" width="80" align="bottom"/>
            </div>
            <div class="analysisTableCell">
                <img class="imgReport" src="icons/email.png" height="80" width="80" align="bottom"/>
            </div>
            <div class="analysisTableCell">
                <img class="imgReport" src="icons/phone.png" height="80" width="80" align="bottom"/>
            </div>
            <div class="analysisTableCell">
                <img class="imgReport" src="icons/meeting.png" height="80" width="80" align="bottom"/>
            </div>
        </div>
        <div class="analysisTableRowDown">
            <div class="analysisTableCellDown">
                <div class="cellReportText">доход ЦПУ pal ${test}</div>
            </div>
            <div class="analysisTableCellDown">
                <div class="cellReportText">обращений Горячей линии</div>
            </div>
            <div class="analysisTableCellDown">
                <div class="cellReportText">обращений по email</div>
            </div>
            <div class="analysisTableCellDown">
                <div class="cellReportText">обращений по телефону</div>
            </div>
            <div class="analysisTableCellDown">
                <div class="cellReportText">проведенных встреч</div>
            </div>
        </div>
    </div>
    <div class="reportGap"></div>
    <div class="applicationsTable">
        <c:forEach items="${reportRecords}" var="reportRecord">
            <div class="applicationTableRow">
                <div class="reportSubcategory"> ${reportRecord.subcategory}</div>
                <div class="reportPriceAndQuantity"> ${reportRecord.quantity} шт.</div>
                <div class="reportPrice"> ${reportRecord.price}
                <span><img class="imgApp" src="icons/rubles.png" height="40" width="40" align="bottom"/></span>
                </div>
            </div>
            <div class="applicationTableGap"></div>
        </c:forEach>
    </div>

    <div class="applicationPageFooter"></div>
</div>

<script src="jquery-1.12.4.min.js"></script>
<script src="bootstrap.min.js"></script>
<script src="../../script.js"></script>
<script>function set_matching_word(text) {
    var txt = text;
    var selected;
    var arr = ["Дополнительные услуги", "Перевозка грузов и порожних вагонов", "Заключение договора", "Справочный запрос","Встреча"];
    for (var i = 0; i < 4; i++) {
        if (arr[i] == txt) {
            selected = i;
        }
    }
    return selected;
}
</script>
<script>function set_matching_wordCpu(text) {
    var txt = text;
    var selected;
    var arr = ["Кузнецова И.", "Лендел О.", "Макарчук Е.", "Новикова Ю", "Паль М.", "Сорвачева А."];
    for (var i = 0; i < 6; i++) {
        if (arr[i] == txt) {
            selected = i;
        }
    }
    return selected;
}
</script>
</body>
</html>
