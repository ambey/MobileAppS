
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>

<%@ page import="common.*" %>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MedExten</title>

</head>
<body bgcolor="gray">
<div align="center" style="margin-top: 200px;">
		<%
        String message = (String)request.getAttribute("message");
    %>
        <h1 align="center">Welcome <%= message %></h1>
        
	</div>
</body>
</html>