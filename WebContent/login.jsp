<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NamVT_Spring Test</title>
        <link rel="stylesheet" href="style/login.css" />
        <script src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script>
            $(document).ready(function(){
                $("#commentForm").validate();
            });
        </script>
    </head>
    <body>
        <div id="content">
            <h1>NamVT_SpringTest Login System</h1>
            <div id="wrapper">
                <div id="steps">
                	<s:form id="commentForm" action="login" method="post" namespace="/">
                        <fieldset class="step">
                            <legend>Account</legend>
                            <s:actionerror/>
                            <p>
                                <label for="username">Username</label>
                                <input type="text" name="username" class="required"/>
                            </p>
                            <p>
                                <label for="password">Password</label>
                                <input type="password" name="password" class="required"/>
                            </p>
                            <p class="submit">
                                <input id="submitBtn" type="submit" value="Login"/>
                            </p>
                        </fieldset>
                    </s:form>
                </div>

            </div>
        </div>
    </body>
</html>
