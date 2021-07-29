<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="2">
		<tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr>
		<td valign="top"><tiles:insertAttribute name="sidebar" />
		<td valign="top"><tiles:insertAttribute name="body" />
	</tr>
	
	<tr>
		<td colspan="2">
		<tiles:insertAttribute name="footer" />
	</tr>
	
	</table>
</body>
</html>