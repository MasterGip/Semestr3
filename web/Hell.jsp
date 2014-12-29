<%@ page import="ru.kfu.itis.WorkWithDB" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 27.12.14
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Задание условий</title>
</head>
<body>
<%ArrayList<String> listOfBooks = WorkWithDB.getBooks();%>
<%ArrayList<String> listOfCustomers = WorkWithDB.getCustomers();%>
<form action="/result.jsp" method = "POST">
    Книга:
    <select name="BookID">
        <%for(int i = 0; i < listOfBooks.size(); i++){%>
        <option value="<%=(listOfBooks.get(i).split(" "))[0]%>">
            <%=listOfBooks.get(i)%>
        </option>
        <%}%>
    </select>
     <-> Покупатель:

    <select name="INNcustomer">
        <%for(int i = 0; i < listOfCustomers.size(); i++){%>
        <option value="<%=(listOfCustomers.get(i).split(" "))[0]%>">
            <%=listOfCustomers.get(i)%>
        </option>
        <%}%>
    </select>
    <br/>
    <p>Дата, после которой нужны продажи:
        <input type="text" name="date"/></p>
    <p>Минимальное количество продаж:
    <input type="number" name="count"/></p>
    <input type="submit" value="GO!">

</form>
</body>
</html>
