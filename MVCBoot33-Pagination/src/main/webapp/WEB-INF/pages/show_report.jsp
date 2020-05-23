<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:choose>
   <c:when test="${!empty listDTO }">
     <table border="1" bgcolor="cyan">
        <tr  bgcolor="red">
          <th>empNo</th><th>empName </th><th>job </th><th>Salary </th> <th>DeptNo</th><th>mgrNo</th>
        </tr>
      <c:forEach var="dto" items="${listDTO }" >
         <tr>
             <td>${dto.empNo }  </td>
             <td>${dto.ename }  </td>
             <td>${dto.job }  </td>
             <td>${dto.sal }  </td>
             <td>${dto.deptNo }  </td>
             <td>${dto.mgr }  </td>
             
         </tr>
      
      </c:forEach>
        
     </table> <br>
      <c:forEach var="i"  begin="1"  end="${pagesCount }" >
          <a href="report.htm?pageNo=${i}">[ ${i} ]</a>  &nbsp;&nbsp;&nbsp;&nbsp;
      </c:forEach>
   
   </c:when>
    <c:otherwise>
        <h1 style="color:red;text-align:center">Records not found</h1>
    </c:otherwise>
 </c:choose>   
  <br><br>
 <a href="page.htm">home</a>
