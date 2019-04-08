<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<marquee><h1>Edit Employee Details</h1></marquee>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
   <form:form commandName="editCmd"><br><br>
   
 EmpNo: <form:input path="empNo" disabled="true"/><br><br>  
   
 EName:  <form:input path="ename"/><br><br>
 
 Job:  <form:input path="job"/><br><br>
 
 Mgr:  <form:input path="mgr"/><br><br>
 
 
  Sal:<form:input path="sal"/><br>
  
  
    comm:<form:input path="comm"/><br>
  
  
    deptNo<form:input path="deptNo"/><br><br>
  
   
   <input type="submit" value="EDIT"><br><br>
   
   </form:form>
   
    <a href="welcome.htm">HOME</a>








