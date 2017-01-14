<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${appliant.job.description}" />
<h1>Register</h1>
<sf:form method="post" modelAttribute="appliant" enctype="multipart/form-data">
    <table>
        <tr>
            <td><sf:label path="firstname" cssErrorClass="error">First name: </sf:label></td>
            <td><sf:input path="firstname" cssErrorClass="error" /></td>
            <td><sf:errors path="firstname" cssClass="error"/></td>
        </tr>

        <tr>
            <td><sf:label path="surname" cssErrorClass="error">Surname: </sf:label></td>
            <td><sf:input path="surname" cssErrorClass="error" /></td>
            <td><sf:errors path="surname" cssClass="error" /></td>
        </tr>

        <tr>
            <td><sf:label path="email" cssErrorClass="error">Email: </sf:label></td>
            <td><sf:input path="email" type="email" cssErrorClass="error" /></td>
            <td><sf:errors path="email" cssClass="error" /></td>
        </tr>

        <tr>
            <td><sf:label path="description" cssErrorClass="error">Description: </sf:label></td>
            <td><sf:input path="description" cssErrorClass="error" /></td>
            <td><sf:errors path="description" cssClass="error" /></td>
        </tr>

        <tr>
            <td><label>CV file: </label></td>
            <td><input type="file" name="cv"
                       accept="image/jpeg,image/png,image/gif" /></td>
        </tr>
    </table>
    <input type="submit" value="Send application" />

    <c:if test="${appliant.id == null}" >
        <sf:errors path="*" element="div" cssClass="error" />
    </c:if>
</sf:form>
</body>
</html>
