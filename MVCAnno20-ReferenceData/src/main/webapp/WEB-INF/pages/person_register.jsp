<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
 
  <h1 style="color:blue;text-align:center">Person Registration </h1>
  
  <form:form  modelAttribute="perCmd">
    <p style="color:red">
        <form:errors path="*"/>
    </p>
     <table bgcolor="cyan" align='center'>
         <tr>
            <td>Person name::    </td>
            <td><form:input path="name"/> </td>
         </tr>
         <tr>
            <td>Person age::    </td>
            <td><form:input path="age"/> </td>
         </tr>
         <tr>
            <td>Person Gender::    </td>
            <td><form:radiobuttons path="gender"  items="${gendersList }"/>  </td>
         </tr>
          <tr>
            <td>Hobies::    </td>
            <td><form:checkboxes path="hobies"  items="${hobiesList }"/>  </td>
         </tr>
          <tr>
            <td>Qualification::    </td>
            <td><form:select path="qlfy" multiple="no">
                            <form:options items="${qlfyList }"/>
                     </form:select> 
              </td>
         </tr>
          <tr>
            <td>Courses::    </td>
            <td><form:select path="courses" multiple="multiple">
                            <form:options items="${coursesList }"/>
                     </form:select> 
               </td>
         </tr>
         <tr>
            <td colspan="2"> <input type="submit"  value="register"/> </td>
         </tr>
     </table>
  
  </form:form>
 
    
