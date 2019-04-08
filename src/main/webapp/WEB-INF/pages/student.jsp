<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <form:form commandName="stCmd" method="POST">
    
    
    EmpNo:<form:input path="empNo"/><br>
    Ename:<form:input path="ename"/><br>
   Job: <form:input path="job"/><br>
    Mgr:<form:input path="mgr"/><br>
    Sal:<form:input path="sal"/><br>
    comm:<form:input path="comm"/><br>
    deptNo<form:input path="deptNo"/><br><br>
    
   <input type="submit" value="submit">
    </form:form>