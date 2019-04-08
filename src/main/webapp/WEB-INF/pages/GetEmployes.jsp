<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:if test="${!empty getMsg}">
${getMsg}
</c:if>

<h1>EmployeDetails</h1>



<c:choose>
<c:when  test="${!empty ldto}">
<table border="1">

<c:forEach var="Details" items="${ldto}">
<tr>
<td>${Details.empNo}</td>
<td>${Details.ename}</td>
<td>${Details.job}</td>
<td>${Details.mgr}</td>
<td>${Details.sal}</td>
<td>${Details.comm}</td>
<td>${Details.deptNo}</td>

<td>
<a href="edit.htm?empNo=${Details.empNo}">Edit</a>
<a href="delete.htm?empNo=${Details.empNo}">Delete</a>
</td>

</tr>
</c:forEach>

</table>
</c:when>

<c:otherwise>
<h1>Records are not found</h1>
</c:otherwise>

</c:choose>








