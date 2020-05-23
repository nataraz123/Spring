<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 
   <h1  style="color:red;text-align:center"> Login  Page </h1>
   
   <form:form  modelAttribute="userCmd">
   <table  border="0"  align="center" bgcolor="cyan">
       <tr>
           <td> username </td>
           <td> <form:input path="username"/>       
       </tr>
       <tr>
           <td> password</td>
           <td> <form:password path="password"/>       
       </tr>
       <tr>
         <td colspan="2"> <input type="submit" value="Login"> </td>  
       </tr>
   
   </table>   
   </form:form>
     <br>
     <c:if test="${!empty resultMsg }">
        <h1 style="color:blue;text-align:center"> ${resultMsg}  </h1>
     </c:if>
      
