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
</head>
<body bgcolor="gray">
<div align="center" style="margin-top: 200px;">
	<h3 align="center">Doctor's Login</h3>

	<html:form action="/signUpDoc">
		<table>
		<html:errors property="login.invalid" />
			<tr align="center">
				<td>
				<html:text property="fName" title="Enter First Name"/>
				</td>
			</tr>
			<tr align="center">
				<td>
				<html:text property="lName" title="Enter Last Name"/>
				</td>
			</tr>
			<tr align="center">
				<td>
				<html:text property="phone" title="Enter Phone"/>
				</td>
			</tr>
			<tr align="center">
				<td>
				<html:text property="altPhone" title="Enter Alternate Phone"/>
				</td>
			</tr>
			<%-- <tr align="center">
				<td>
				<html:text property="clinic" title="Enter Clinic"/>
				</td>
			</tr>
			<tr align="center">
				<td>
				<html:text property="speciality" title="Enter Speciality"/>
				</td>
			</tr> --%>
			<tr align="center">
				<td>
				<html:text property="emailId" title="Enter Email ID"/>
				</td>
			</tr>
			

			<tr align="center">
				<td>
				<html:password property="passwd" styleId="pwd" title="Enter Password"/>
				</td>
			</tr>
			<tr align="center">
				<td align="center"><input id="login_bt" type="submit" value="Submit" title="Please click to Save Details."> </td>	
			</tr>
			
		</table>
	</html:form>
	
	</div>
</body>
</html>