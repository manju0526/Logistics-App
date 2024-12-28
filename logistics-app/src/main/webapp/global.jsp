<!-- global.jsp -->
<%@ taglib uri="http://www.logistics.com/ui" prefix="logistics"%>


<%-- Session-related settings (optional) --%>
<%
//Disable caching for this JSP page
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Prevent caching
%>

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleall.css">

