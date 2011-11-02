<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="header">
    <div id="logo">NamVT Project</div>
</div>
<div id="spot">
    <div id="menu">
        <ul>
            <li><a href="index.jsp">Home</a>
                <!--<ul>
                    <li>
                        <a href="OrderManagerment.jsp">Manager Order</a>
                    </li>
                </ul>-->
            </li>
            <li><a href="index.jsp">List product</a></li>
            <li><a href="#">Register</a></li>
            <%if (session.getAttribute("adminLogin") == null) {
            %>
            <li><a href="login.jsp">Login</a></li>
            <%}%>
            <%if (session.getAttribute("adminLogin") != null) {%>
            <li>
                <%String user = (String) session.getValue("adminLogin");
                    out.println("Welcome " + user + " !");%></li>
                <%}%>
        </ul>
        <div id="btn-logout">
            <%if (session.getAttribute("adminLogin") != null) {
            %>
            <a href="logout.do">Logout</a>
            <%}%>

        </div>
        <div class="clr"></div>
    </div>
    <div id="user-board">

    </div>
</div>