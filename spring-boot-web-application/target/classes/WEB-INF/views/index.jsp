<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script src="<c:url value="/resources/js/app.js" />"></script>
<title>FX Data</title>
</head>
<body>
  <h1>Spring Boot - MVC web application</h1>
  <hr>

  <div class="form">
    <form action="Success" method="post" name="FXData" onSubmit="return validate()">
      <table>
         <tr> 
         	<td>Enter Base Currency</td>
          	<td><input id="baseCurrency" name="baseCurrency"></td>
          </tr>
          <tr> 
          	<td>Enter Sender's Email Address</td>
          	<td><input id="senderEmailID" name="senderEmailID"></td>
          </tr>
          <tr>
          <td>Enter Sender's Password</td>
          <td><input id="password"  type= "password" name="password"></td>
          </tr>
          <tr>
          <td>Enter Receiver's Email Address</td>
          <td><input id="receiverEmailID" name="receiverEmailID"></td>
          </tr>
          <tr>
          <td><input type="submit" value="Submit"></td>
          </tr>
	      </table>
    </form>
  </div>

</body>
</html>