<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Add new employee</h2>
<br>
<form:form action="saveEmployee" modelAttribute="emp">
    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>