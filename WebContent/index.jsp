<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="domain.Products"%>
<%@page import="bol.IProductBO"%>
<%@page import="lib.*"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% 
if(session.getAttribute("adminLogin") == null){
   	response.sendRedirect("login.jsp");
}%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <jsp:include flush="true" page="template/scripts.jsp"/>
    </head>
    <body>
    	<div id="wrap">
            <jsp:include flush="true" page="template/header.jsp"/>
            <div id="maincontent">
            <div class="toolbar">
            	<ul>
                   <li class="btn-toolbar">
                   		<span> 
                   			<a href="#" class="btn-cancel" onclick="parent.history.back(); return false;">Back</a>
                   		</span>
                   </li>
                   <li class="btn-toolbar">
                        <span> 
                        	<a href="productDetail.jsp" class="btn-add">Add new</a>
                        </span>
                	</li>
                </ul>
             <div class="clr"></div>
             </div>
             <s:actionerror/>
            <%
           		IProductBO productBO = (IProductBO) ServiceFinder.getContext(request).getBean("productAOP");
            	List<Products> listUser = productBO.getAll();
            	List listU = null;
            	int rows = 5;
            	int totalPages = (int)Math.floor((listUser.size() - 1) / (float)rows) + 1;
            	int pageNumber = 0;
            	int fromIndex = 0;
            	int toIndex = 0;
            	if(request.getParameter("page") != null){
            		pageNumber = Integer.parseInt(request.getParameter("page"));
            		if(pageNumber == totalPages){
            			fromIndex = (pageNumber-1)*rows;
                		toIndex = fromIndex + listUser.size()-(rows*(totalPages-1));
            		} else{
            			fromIndex = (pageNumber-1)*rows;
                		toIndex = fromIndex + rows;
            		}
         			listU = listUser.subList(fromIndex, toIndex);
            	}
            	else{
            		listU = listUser.subList(0, rows);
            	}
        		pageContext.setAttribute("users", listU);
       	 	%>
        	<s:form method="post" name="del" action="delete" namespace="/">
            <table cellspacing="0" cellpadding="3" border="1" rules="cols"
                   style="background-color: White; border: 1px solid rgb(230, 250, 255); font-weight: normal; font-style: normal; text-decoration: none; border-collapse: collapse;"
                   class="tbl-list">
                <tbody>
                    <tr style="font-weight: bold;" class="tbl-header">
                        <td>Name</td>
                        <td>Price</td>
                        <td>Product Type</td>
                        <td width="200px">Images</td>
                        <td>Remove</td>
                    </tr>
                <c:forEach items="${users}" var="item">
                    <tr>
                        <td>
                        	<a href="productDetail.jsp?id=${item.id}&action=edit">
                                <font color="blue">${item.name}</font> 
                            </a>
                        </td>
                        <td>${item.price}</td>
                        <td>${item.producttype.name}</td>
                        <td width="150x">
                        	<a href="productDetail.jsp?id=${item.id}&action=edit"> <img
                               src="images/cars/${item.images}"
                               style="height: auto; width: 125px; border-width: 0px;" /> 
                            </a>
                     	</td>
                        <td>
                        	<input type="checkbox" name="cbRemove" value="${item.id}" />
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                	<td align="right" colspan="5"><input type="submit" value="Remove"></td>
                </tr>
                </tbody>
                
            </table>
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr align="center">
                        <td>
                            <%
                            for (int i = 1; i <= (totalPages); i++) {
                            	if ((request.getParameter("page") != null) && (i == pageNumber) ){
                            %>
                            	<a href="index.jsp?page=<%= i%>"><b><%= i%></b></a>
                            <%
                            	} else {
                            %>
                            	<a href="index.jsp?page=<%= i%>"><b><%= i%></b></a>
                            <%
                            	}
                            }
                            %>
                        </td>
                    </tr>
             </table>
            </s:form>
            </div>
            <jsp:include flush="true" page="template/footer.jsp"/>
        </div>
    </body>
</html>