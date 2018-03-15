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
        <div class="applicationPageHeaderCellChoose" style="cursor: pointer;"
             onclick="window.location='./applications';">Обращения
        </div>
        <div class="applicationPageHeaderCell" style="cursor: pointer;" onclick="window.location='./reports';">Отчеты
        </div>
        <div class="applicationPageHeaderCell">Настройки</div>
    </div>
    <div class="applicationSubHeader">
        <div class="togglePanel">
            <span class="switchText">Все</span>
            <label class="switch">
                <form action="/openapplications" method="POST" id="OpenCloseApps">
                    <input type="checkbox"  name="chbOpenClose" id="chbOpenClose"
                            onclick="getElementById('OpenCloseApps').submit();">
                    <span class="slider round"></span>
                </form>
            </label>
            <span class="switchText">Открытые</span>
        </div>
        <div class="togglePanel">
            <span class="switchText">Все</span>
            <label class="switch">
                <input type="checkbox" checked>
                <span class="slider round"></span>
            </label>
            <span class="switchText">Только мои</span>
        </div>
        <div class="dateSearchPanel">
            <form  method="POST" action="/filterapptablebydate" id="filterByDate">
            <input type="date" class="search" name="dateFrom"></input>
            <input type="date" class="search" name="dateTo"></input>
            <button class="btnFilterDate"><img src="icons/search.png" height="45" width="45" align="bottom" onclick='getElementById("filterByDate").submit()'/>
            </button>
            </form>
            <form id="filterByCategory" action="/filterapptablebycategory" method="POST">
            <select class="search" name="categoryFilter">
                <option>Номер</option>
                <option>Клиент</option>
                <option>Категория</option>
                <option>Дата обращения</option>
                <option>Дата закрытия(факт)</option>
                <option>Ответственный ЦПУ</option>
                <option>Исполнитель</option>
                <option>Статус</option>
            </select>
            <input type="text" class="search" placeholder="Введите значение" name="categoryValue"></input>
            <button class="btnFilterDate"><img src="icons/search.png" height="45" width="45" align="bottom" onclick='getElementById("filterByCategory").submit()'/>
            </button>
            </form>
            <button class="btnCreateApp" name="send-message" type="submit" data-toggle="modal"
                    data-target="#feedbackForm"
                    float="right"
                    onclick="
                    var txt = '';
                    document.getElementById('idForm').value=txt;
                    document.getElementById('emailForm').value=txt;
                    document.getElementById('dateForm').value=txt;
                    document.getElementById('phoneForm').value=txt;
                    document.getElementById('clientForm').value=txt;
                    document.getElementById('fioForm').value=txt;
                    document.getElementById('subcategoryForm').value=txt;
                    document.getElementById('appTextForm').value=txt;
                    document.getElementById('statusForm').value=txt;
                    document.getElementById('chronologyForm').value=txt;
                    document.getElementById('performerForm').value=txt;
                    //document.getElementById('cpuResponsibleForm').value=txt;
                    document.getElementById('dateFinishPlanForm').value=txt;
                    document.getElementById('dateFinishFactForm').value='1000-01-01';
                    document.getElementById('timeForm').value='-';
                    document.getElementById('priceForm').value='0.0';
                    document.getElementById('nvNumberForm').value='-';
                    document.getElementById('nvDateForm').value='1000-01-01';"
            ><img src="icons/createapp.png" height="45" width="45" align="center"/>Создать
                заявку
            </button>
        </div>
    </div>
    <div class="applicationsTable">
        <c:forEach items="${applications}" var="application">
            <div class="applicationTableRow" data-toggle="modal" data-target="#feedbackForm"
                 onclick="

                         var idForm='<c:out value="${application.id}"/>';
                         document.getElementById('idForm').value=idForm;
                         var  txtArea ='Номер(ID): '+idForm+'\n';

                         var emailForm='<c:out value="${application.email}"/>';
                         document.getElementById('emailForm').value=emailForm;
                         txtArea+='email: '+emailForm+'\n';

                         var dateForm='<c:out value="${application.date}"/>';
                         document.getElementById('dateForm').value=dateForm;
                         txtArea+='Дата обращения: '+dateForm+'\n';

                         var phoneForm='<c:out value="${application.phone}"/>';
                         document.getElementById('phoneForm').value=phoneForm;
                         txtArea +='Телефон: '+phoneForm+'\n';

                         var clientForm='<c:out value="${application.client}"/>';
                         document.getElementById('clientForm').value=clientForm;
                         txtArea +='Клиент: '+clientForm+'\n';

                         var fioForm='<c:out value="${application.fio}"/>';
                         document.getElementById('fioForm').value=fioForm;
                         txtArea +='Ф.И.О.: '+fioForm+'\n';

                         document.getElementById('categoryForm').selectedIndex = set_matching_word('<c:out
                         value="${application.category}"/>');

                         var subcategoryForm='<c:out value="${application.subcategory}"/>';
                         document.getElementById('subcategoryForm').value=subcategoryForm;
                         txtArea +='Подкатегория: '+subcategoryForm+'\n';

                         var appTextForm='<c:out value="${application.applicationText}"/>';
                         document.getElementById('appTextForm').value=appTextForm;
                         txtArea +='Суть обращения: '+appTextForm+'\n';

                         var statusForm='<c:out value="${application.status}"/>';
                         document.getElementById('statusForm').value=statusForm;
                         txtArea +='Статус: '+statusForm+'\n';

                         var chronologyForm='<c:out value="${application.chronology}"/>';
                         document.getElementById('chronologyForm').value=chronologyForm;
                         txtArea +='Хронология: '+chronologyForm+'\n';

                         var performerForm='<c:out value="${application.performer}"/>';
                         document.getElementById('performerForm').value=performerForm;
                         txtArea +='Исполнитель: '+performerForm+'\n';

                         document.getElementById('cpuResponsibleForm').selectedIndex=set_matching_wordCpu('<c:out
                         value="${application.cpuResponsible}"/>');

                         var dateFinishPlanForm='<c:out value="${application.dateFinishPlan}"/>';
                         document.getElementById('dateFinishPlanForm').value=dateFinishPlanForm;
                         txtArea +='Дата закрытия(план): '+dateFinishPlanForm+'\n';

                         var dateFinishFactForm='<c:out value="${application.dateFinishFact}"/>';
                         document.getElementById('dateFinishFactForm').value=dateFinishFactForm;
                         txtArea +='Дата закрытия(факт): '+dateFinishFactForm+'\n';

                         var timeForm='<c:out value="${application.time}"/>';
                         document.getElementById('timeForm').value=timeForm;

                         var priceForm='<c:out value="${application.price}"/>';
                         document.getElementById('priceForm').value=priceForm;

                         var nvNumberForm='<c:out value="${application.nvNumber}"/>';
                         document.getElementById('nvNumberForm').value=nvNumberForm;

                         var nvDateForm='<c:out value="${application.nvDate}"/>';
                         document.getElementById('nvDateForm').value=nvDateForm;

                         document.getElementById('txtAreaForm').value=txtArea;">

                <form class="applicationTableCellForm" method="POST" id="${application.id}" action="/showapp">
                    <input class="applicationTableCellId" name="appId" value="${application.id}" readonly>
                </form>
                <div class="applicationTableCell">${application.date}</div>
                <div class="clientName">${application.client}</div>
                <c:if test='${application.category == "Перевозка грузов и порожних вагонов"}'>
                    <img class="imgApp" src="icons/transportation.png" height="70" width="70" align="bottom"/>
                </c:if>
                <c:if test='${application.category == "Дополнительные услуги"}'>
                    <img class="imgApp" src="icons/delivery.png" height="70" width="70" align="bottom"/>
                </c:if>
                <c:if test='${application.category == "Заключение договора"}'>
                    <img class="imgApp" src="icons/contract.png" height="70" width="70" align="bottom"/>
                </c:if>
                <c:if test='${application.category == "Справочный запрос"}'>
                    <img class="imgApp" src="icons/info.png" height="70" width="70" align="bottom"/>
                </c:if>
                <c:if test='${application.category == "Встреча"}'>
                    <img class="imgApp" src="icons/meeting.png" height="70" width="70" align="bottom"/>
                </c:if>
                <div class="applicationSubcategory"> ${application.subcategory}</div>
                <div class="applicationTableCell"> ${application.dateFinishPlan}</div>
                <div>
                    <c:if test='${application.dateFinishFact != "1000-01-01"}'>
                        <span class="applicationStatus"> Закрыто </span>
                    </c:if>
                    <c:if test='${application.dateFinishFact == "1000-01-01"}'>
                        <span class="applicationStatusOpen">Открыто </span>
                    </c:if>
                </div>
            </div>
            <div class="applicationTableGap"></div>
        </c:forEach>
    </div>
    <div class="applicationPageFooter"></div>
</div>
<!-- Форма обратной связи в модальном окне -->
<div class="modal fade" id="feedbackForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="myModalLabel">Обращение</h4>
            </div>

            <div class="modal-body">

                <!-- Сообщение, отображаемое в случае успешной отправки данных -->
                <div class="alert alert-success hidden" role="alert" id="msgSubmit" style="margin-bottom: 0px;">
                    <strong>Внимание!</strong> Ваше сообщение отправлено.
                </div>

                <!-- Форма обратной связи -->
                <form id="messageForm" enctype="multipart/form-data" data-async data-target="#rating-modal"
                      action="./createapp" method="POST">
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName">Номер (ID)</span>
                            <input class="cellInput" type="number" id="idForm" name="idForm" required/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/mail.svg" height="12" width="12"
                                                        align="bottom"/> email</span>
                            <input class="cellInput" type="text" name="email" id="emailForm"/>
                        </div>
                    </div>
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/calendar.svg" height="12" width="12"
                                                        align="bottom"/> Дата</span>
                            <input class="cellInput" type="date" name="date" id="dateForm" required/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/phone.svg" height="12" width="12"
                                                        align="bottom"/> Телефон</span>
                            <input class="cellInput" type="text" name="phone" id="phoneForm"/>
                        </div>
                    </div>
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName">Клиент</span>
                            <input class="cellInput" type="text" name="clientForm" id="clientForm" required/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/client.svg" height="12" width="12"
                                                        align="bottom"/> ФИО</span>
                            <input class="cellInput" type="text" name="fio" id="fioForm" required/>
                        </div>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName">Категория</span>
                        <select class="cellInput" name="category" id="categoryForm" required>
                            <option>Дополнительные услуги</option>
                            <option>Перевозка грузов и порожних вагонов</option>
                            <option>Заключение договора</option>
                            <option>Справочный запрос</option>
                            <option>Встреча</option>
                        </select>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName">Подкатегория</span>
                        <input class="cellInput" type="text" name="subcategory" id="subcategoryForm" required/>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName"><img src="icons/apply.svg" height="12" width="12" align="bottom"/> Обращение</span>
                        <input class="cellInput" type="text" name="applicationText" id="appTextForm" required/>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName"><img src="icons/status.svg" height="12" width="12" align="bottom"/> Статус</span>
                        <input class="cellInput" type="text" name="status" id="statusForm" required/>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName"><img src="icons/history.svg" height="12" width="12"
                                                    align="bottom"/> Хронология</span>
                        <textarea class="cellInput" type="text" name="chronology" id="chronologyForm"> </textarea>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName">Исполнитель</span>
                        <input class="cellInput" type="text" name="performer" id="performerForm" required/>
                    </div>
                    <div class="cellFrame">
                        <span class="cellName">Ответственный ЦПУ</span>
                        <select class="cellInput" name="cpuResponsible" id="cpuResponsibleForm" required>
                            <option>Кузнецова И.</option>
                            <option>Лендел О.</option>
                            <option>Макарчук Е.</option>
                            <option>Новикова Ю.</option>
                            <option>Паль М.</option>
                            <option>Сорвачева А.</option>
                        </select>
                    </div>
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/calendar.svg" height="12" width="12"
                                                        align="bottom"/> Дата закрытия(план)</span>
                            <input class="cellInput" type="date" name="dateFinishPlan" id="dateFinishPlanForm"
                                   required/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName"><img src="icons/calendar.svg" height="12" width="12"
                                                        align="bottom"/> Дата закрытия (факт)</span>
                            <input class="cellInput" type="date" name="dateFinishFact" id="dateFinishFactForm"/>
                        </div>
                    </div>
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName">Срок</span>
                            <input class="cellInput" type="text" name="time" id="timeForm"/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName">Стоимость</span>
                            <input class="cellInput" type="text" name="price" id="priceForm"/>
                        </div>
                    </div>
                    <div class="rowForm">
                        <div class="cellFrame">
                            <span class="cellName">Номер НВ</span>
                            <input class="cellInput" type="text" name="nvNumber" id="nvNumberForm"/>
                        </div>
                        <div class="cellFrame">
                            <span class="cellName">Дата НВ</span>
                            <input class="cellInput" type="date" name="nvDate" id="nvDateForm"/>
                        </div>
                    </div>
                    <textarea id="txtAreaForm" style=" color: white; border: none; overflow: hidden"
                              readonly></textarea>
                    <!-- Кнопка, отправляющая форму по технологии AJAX onclick='getElementById("messageForm").submit();'-->
                    <button name="send-message" type="submit" onclick="$('form[data-async]').on('submit',
                            function(event) {
                            var $form=$(this);
                            var $target=$($form.attr('data-target'));

                            $.ajax({
                            type: $form.attr('method'),
                            url: $form.attr('action'),
                            data: $form.serialize(),

                            success: function(data, status) {
                            $target.html(data);

                            location.reload();
                            },
                            error: function(jqXHR, e) {
                            alert('Не удалось сохранить заявку');
                            e.print();
                             }
                            });
                             event.preventDefault();
                             });">СОХРАНИТЬ
                    </button>
                </form><!-- Конец формы -->
                <div class="clearfix"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="clipBoard()">Копировать
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть
                </button>
            </div>
        </div>
    </div>
</div>
<script src="jquery-1.12.4.min.js"></script>
<script src="bootstrap.min.js"></script>
<script src="../../script.js"></script>
<script>function set_matching_word(text) {
    var txt = text;
    var selected;
    var arr = ["Дополнительные услуги", "Перевозка грузов и порожних вагонов", "Заключение договора", "Справочный запрос", "Встреча"];
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
<script>
    function clipBoard() {
        var copyTextarea = document.getElementById('txtAreaForm');
        copyTextarea.select();
        document.execCommand("copy");
        //window.prompt("Нажмите Ctrl+С  и Enter, чтобы скопировать текст.",client+"\n"+fio);
    }
</script>
</body>
</html>
