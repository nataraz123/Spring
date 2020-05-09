<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>   
 
 <h1 style="color:blue;text-align:center"><spring:message code="form.title"></spring:message> </h1>
 
 <form:form modelAttribute="patCmd">
    <spring:message code="form.patName"/> <form:input path="patName"/> <br>
    <spring:message code="form.patAddrs"/> <form:input path="patAddrs"/> <br>
    <spring:message code="form.patAge"/> <form:input path="patAge"/> <br>
    <input type="submit"  value="<spring:message code='form.submit' />"/>
    
 </form:form>
 <br>
   <a href="?language=fr_FR">French</a> &nbsp; &nbsp;
   <a href="?language=de_DE">German</a> &nbsp; &nbsp;
   <a href="?language=hi_IN">Hindi</a> &nbsp; &nbsp;
    <a href="?language=zh_CN">Chinese</a> &nbsp; &nbsp;
    <a href="?language=te_IN">Telugu</a> &nbsp; &nbsp;
 
