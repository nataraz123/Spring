<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  
  <c:choose>
    <c:when test="${!empty listRDTO }">
    <table border="1" bgcolor="cyan">
      <tr bgcolor="yellow">
         <th>empNo</th> <th>empName</th><th>job</th> <th>salary</th>
         <th>deptNo</th> <th>MgrNo</th>
      </tr>
        <c:forEach  var="emp" items="${listRDTO }">
           <tr bgcolor="orange">
              <td>${emp.empno} </td>
              <td>${emp.ename } </td>
               <td>${emp.job} </td>
              <td>${emp.sal } </td>
               <td>${emp.deptno} </td>
              <td>${emp.mgr } </td>
           </tr>
        </c:forEach>
      </table>
    
    </c:when>
    <c:otherwise>
       <h1 style="color:red;text-align:center">Records  not Found </h1>
    </c:otherwise>
  </c:choose>
    <br> <a href="welcome.htm">search again</a>
    
