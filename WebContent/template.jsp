<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NamVT Spring Test</title>
        <jsp:include flush="true" page="template/scripts.jsp"/>
    </head>
    <body>
        <div id="wrap">
            <jsp:include flush="true" page="template/header.jsp"/>
            <div id="maincontent">
                <p align="center"><b>Wellcome to NamVT Spring Test</b></p>
            </div>
            <jsp:include flush="true" page="template/footer.jsp"/>
        </div>
    </body>
</html>