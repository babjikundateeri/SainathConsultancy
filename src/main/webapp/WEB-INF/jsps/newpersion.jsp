<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:th="http://www.thymeleaf.org">
    <head></head>

    <body>
        <div>
            <form method="post" action="#" th:action="@{/persons/new}" th:object="${personFormBean}">
                <div>
                    <div><input type="text" placeholder="First Name" th:field="*{firstName}" /> </div>
                    <div><input type="text" placeholder="Last Name" th:field="*{lastName}" /> </div>

              <!--      <div th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}">First Name Error</div>
                    <div th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}">Last Name Error</div> -->
                </div>

                <div>
                    <div><input type="submit" value="Submit"/></div>
                    <div><input type="reset" value="Reset"/></div>
                </div>
            </form>
        </div>
    </body>
</html>