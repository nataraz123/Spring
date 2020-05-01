<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>    

    
    <h1 style="color:red;text-align:center"> Employee Details Update Form</h1>
    
    <form:form modelAttribute="empCmd">
      <table bgcolor="cyan"  align="center">
         <tr><td>empNo ::</td> <td><form:input path="empNo"  readonly="true"/> </td>  </tr>
         <tr><td>empName ::</td> <td><form:input path="ename" /> </td>  </tr>
         <tr><td>Desg ::</td> <td><form:input path="job" /> </td>  </tr>
         <tr><td>Salary ::</td> <td><form:input path="sal" /> </td>  </tr>
         <tr><td>DeptNo ::</td> <td><form:input path="deptNo" /> </td>  </tr>
         <tr> <td colspan="2"><input type="submit"  value="updateEmployee"></td> </tr>
      </table>
    
    </form:form>
    
    