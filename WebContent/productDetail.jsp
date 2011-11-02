<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List" %>
<%@page import="domain.Products"%>
<%@page import="domain.Producttype"%>
<%@page import="bol.IProductBO"%>
<%@page import="bol.IProductTypeBO"%>
<%@page import="lib.*"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% 
if(session.getAttribute("adminLogin") == null){
   	response.sendRedirect("login.jsp");
}%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NamVT Spring Test</title>
        <jsp:include flush="true" page="template/scripts.jsp"/>
        <script src="ckeditor/ckeditor.js" type="text/javascript"></script>
        <script src="ckeditor/config.js" type="text/javascript"></script>
        <script>
	        function AddTextArea()
	        {
	            var oEditor = CKEDITOR.replace("content");
	        }
            $(document).ready(function(){
                $("#commentForm").validate();
            });
        </script>
    </head>
    <body>
        <div id="wrap">
            <jsp:include flush="true" page="template/header.jsp"/>
            <div id="maincontent">
            	<s:actionerror/>
                <%
                	IProductTypeBO productTypeBO = (IProductTypeBO) ServiceFinder.getContext(request).getBean("productTypeAOP");
                	List<Producttype> productType = productTypeBO.getAll();
                	pageContext.setAttribute("productType",productType);
                	
                	if(request.getParameter("action") != null){
	                String action = request.getParameter("action");
		                if(action.equals("edit")){
			                int ID = Integer.parseInt(request.getParameter("id").toString());
			                IProductBO productBO = (IProductBO) ServiceFinder.getContext(request).getBean("productAOP");
		            		Products product;
		            		product = productBO.getById(ID);
		            		//out.print("<br />"+action);
		            		pageContext.setAttribute("products",product);
		                }
                %>
                <%
                	if(action.equals("edit")){
                %>
	                <s:form id="commentForm" action="edit" method="post" namespace="/" enctype="multipart/form-data">
	                <table width="100%" cellpadding="0" cellspacing="0" class="tbl-list">
            			<tr>
                         	<td width="15%">
                         		<span>Product name</span>
                        	</td>
                            <td >
                            	<input type=text name="name" class="required" value="${products.name}"/>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Images</span>
                        	</td>
                            <td >
                            	<img name="images" alt="${products.name}" style="height: auto; width: 400px; border-width: 0px;"
                                         src="images/cars/${products.images}"/>
                                <br />
                            	<input type="hidden" name="images" value="${products.images}">
                            	<!--<s:file name="upload"></s:file>-->
                            	<input type="file" name="upload" /> name
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product price</span>
                        	</td>
                            <td >
                            	<input type=text name="price" class="required number" value="${products.price}"/>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product Type</span>
                        	</td>
                            <td >
                            	<select name="productTypeID">
                            	<c:forEach items="${productType}" var="item">
                            		<c:if test="${products.producttype.id == item.id}" >
                                		<option selected="selected" value="${item.id}">${item.name}</option>
                                	</c:if>
                                	<c:if test="${products.producttype.id != item.id}" >
                                		<option value="${item.id}">${item.name}</option>
                                	</c:if>
                                </c:forEach>
                                </select>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product content</span>
                        	</td>
                            <td >
                            	<textarea cols="40" rows="20" name="content" >
                            		${products.content}
                            	</textarea>
                                <script type="text/javascript">
                                	AddTextArea();
                                </script>
                            </td>
                 		</tr>
                 		<tr>
                           <td width="15%"></td>
                            <td align="left">
                            	<input type="hidden" name="id" value="${products.id}" />
                                <input type="submit" value="Submit" />
                                <input type="reset" value="Reset" />
                            </td>
            		</table>	
	                </s:form>
                <%} } 
                	else {
                %>
                	<s:form id="commentForm" action="create" method="post" namespace="/" enctype="multipart/form-data">
	                <table width="100%" cellpadding="0" cellspacing="0" class="tbl-list">
            			<tr>
                         	<td width="15%">
                         		<span>Product name</span>
                        	</td>
                            <td >
                            	<input type=text name="name" class="required"/>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Images</span>
                        	</td>
                            <td >
                            	<s:file name="upload"></s:file>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product price</span>
                        	</td>
                            <td >
                            	<input type=text name="price" class="required number"/>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product Type</span>
                        	</td>
                            <td >
                            	<select name="productTypeID">
                            	<c:forEach items="${productType}" var="item">
                                	<option value="${item.id}">${item.name}</option>
                                </c:forEach>
                                </select>
                            </td>
                 		</tr>
                 		<tr>
                         	<td width="15%">
                         		<span>Product content</span>
                        	</td>
                            <td >
                            	<textarea cols="40" rows="20" name="content" >
                            		Enter content here ^^
                            	</textarea>
                                <script type="text/javascript">
                                	AddTextArea();
                                </script>
                            </td>
                 		</tr>
                 		<tr>
                           <td width="15%"></td>
                            <td align="left">
                                <input type="submit" value="Submit" />
                                <input type="reset" value="Reset" />
                            </td>
            		</table>
	                </s:form>
                <%} %>
            </div>
            <jsp:include flush="true" page="template/footer.jsp"/>
        </div>
    </body>
</html>