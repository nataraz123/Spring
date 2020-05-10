<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
 
 
 <h1 style="color:blue;text-align:center">FileUploading  </h1>
 
 <form:form method="POST"  enctype="multipart/form-data"  modelAttribute="uplCmd">
      <table bgcolor="cyan" >
         <tr><td> emp name:: </td><td><form:input path="ename"/></td>  </tr>
         <tr><td> emp Address:: </td><td><form:input path="eadd"/></td>  </tr>
         <tr><td> Select emp Photo:: </td><td><form:input type="file"  path="ephoto"/></td>  </tr>
         <tr><td> Select emp Resume:: </td><td><form:input type="file" path="eresume"/></td>  </tr>
         <tr> <td colspan="2"> <input type="submit"  value="upload"> </td>   </tr>
      </table>
 
 </form:form>   
    
