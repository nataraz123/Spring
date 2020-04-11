<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
  
 <c:choose>
    <c:when test="${!empty listDTO }">
     <table align="center" border="1" bgcolor="cyan">
      <tr bordercolor="red">
        <th>srNo </th> <th>EmpNo</th> <th>EmpName </th> <th>Desg </th> <th>Salary </th> <th>deptno </th> 
      </tr>
      <c:forEach var="emp" items="${listDTO }">
        <tr bgcolor="blue">
           <td>${emp.srNo}</td>
           <td>${emp.empNo}</td>
          <td>${emp.ename}</td>
           <td>${emp.job}</td>
           <td>${emp.sal}</td>
           <td>${emp.deptNo}</td>
        </tr>
      </c:forEach>
    
    </table>
    </c:when>
    
    <c:otherwise>
       <h1 style="color:red;text-align:center"> Records not found </h1>
    </c:otherwise>
 
 </c:choose>
 
 <br><br>
   <a href="welcome.htm"><img src="images/home.jpg" width="50" height="50"></a>
