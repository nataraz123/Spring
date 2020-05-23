<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
  <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
  
  <h1 style="color:red;text-align:center">Pagination settings  </h1>
  
  <form:form modelAttribute="pageCmd" action="report.htm"  >
      Enter page size ::  <form:input path="pagesize"/> <br>
      <form:hidden  path="pageNo" />
      <input type="submit" value="get Report">
  </form:form>
    
