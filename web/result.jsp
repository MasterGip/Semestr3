<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 27.12.14
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.kfu.itis.WorkWithDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.kfu.itis.Invoice" %>
<%@ page import="ru.kfu.itis.Book" %>
<%@ page import="ru.kfu.itis.Customer" %>
<html>
<head>
    <title>Результат</title>
</head>
<body>
<%try{%>
<%ArrayList<Invoice> listOfInvoices
        = WorkWithDB.getInvocesByDateAndCount(
        request.getParameter("date"),
        request.getParameter("count"),
        request.getParameter("INNcustomer"),
        request.getParameter("BookID")
        );%>
<%Book book = WorkWithDB
        .getBook(new Integer(request.getParameter("BookID")));%>
<%Customer customer = WorkWithDB
        .getCustomer(request.getParameter("INNcustomer"));%>
<%if(listOfInvoices.size() != 0){%>
<p><b>Информация по продажам:</b></p>
    <%for(int i = 0; i < listOfInvoices.size(); i++){%>
        <p>
            <%Invoice invoice = listOfInvoices.get(i);%>
            Номер счета: <%=invoice.getCountNumber()%><br/>
            Дата: <%=invoice.getDateStart()%><br/>
            Стоимость заказа: <%=invoice.getValue()%><br/>
            Работник: <%=invoice.getWorker()%><br/>
            Налог: <%=invoice.getTax()%><br/>
            Дополнительно: <%=invoice.getPlus()%><br/>
        </p>
        <br/>

    <%}
}else{%>

<p><b>Заказов меньше нужного</b></p>
<%}%>
<p><b>Информация о книге:</b></p>
<p>
    id: <%=book.getId()%><br/>
    Автор: <%=book.getAuthor()%><br/>
    Название: <%=book.getFilm()%><br/>
    Аннотация: <%=book.getComment()%><br/>
    Число страниц: <%=book.getPages()%><br/>
    Издательство: <%=book.getCompany()%><br/>
    Год: <%=book.getYear()%><br/>
    Цена: <%=book.getCost()%><br/><br/>
    Наличие cd: <%=book.getCdrom()%>
    ИНН поставщика: <%=book.getiNNProducer()%><br/>
</p>
<p><b>Информация о заказчике:</b></p>
<p>
    ИНН: <%=customer.getiNN()%><br/>
    Имя: <%=customer.getCustomer()%><br/>
    Лицо(Юр./ Физ.): <%=customer.getCustomerSign()%><br/>
    Адрес: <%=customer.getAddressCust()%><br/>
    Директор: <%=customer.getChief()%><br/>
    Банк: <%=customer.getBankCustomer()%><br/>
    Телефон: <%=customer.getPhone()%><br/>
    Район: <%=customer.getDistrict()%><br/>
    Номер счета в банке: <%=customer.getAccountCust()%><br/>

</p>
<%}catch (Exception e){%>
<h1>ОШИБКА!!!!!</h1>
<%e.printStackTrace();
}%>
</body>
</html>
