<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<div>
    <h3>Persons List</h3>
    <table>
        <tr>
            <th> Id </th>
            <th> First Name </th>
            <th> Last Name </th>
            <th> DOB </th>
        </tr>

        <c:forEach var="person" items="${personsList}" >
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.dob}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
