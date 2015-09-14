<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>

<%@ page import="com.extenprise.medico.common.*" %>
<%@ page import="com.extenprise.medico.service.*" %>
<%@ page import="com.extenprise.medico.customer.*" %>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MedExten</title>
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {

	$("#logID").attr("placeholder", "Name");
	$("#pwd").attr("placeholder", "Password");

	$("#login_bt").click(function() {
		var id = $("#logID").val();
		var pwd = $("#pwd").val();
		if(id == "") {
			alert("Please enter the login name.");
			return false;
		}
		if(pwd == "") {
			alert("Please enter the password.");
			return false;
		}
	})
});
</script>
</head>
<body bgcolor="gray">
<div align="center" style="margin-top: 200px;">
	<h3 align="center">Doctor's Login</h3>

	<html:form action="/signInDoc" styleId="loginForm">
		<table>
		<html:errors property="login.invalid" />
			<tr align="center">
				<td>
				<html:text property="emailId" styleId="logID" title="Enter Name"/>
				</td>
			</tr>
			<tr align="center">
				<td>
				<html:password property="passwd" styleId="pwd" title="Enter Password"/>
				</td>
			</tr>
			<tr align="center">
				<td align="center"><input id="login_bt" type="submit" value="Sign-in" title="Please click to Sign in to your account."> </td>	
			</tr>
			<tr align="center">
				<td align="center"><a href="#">Forgot Password</a></td>
			</tr>
			<tr align="center">
				<td align="center" ><a href="./jsps/SignUpDoc.jsp">Sign-Up</a></td>
			</tr>
		</table>
	</html:form>
	
	</div>
</body>
</html>