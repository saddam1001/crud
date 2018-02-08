<%@ page import="com.saddam.dao.UserDao" %>
<jsp:useBean id="u" class="com.saddam.bean.User"/>
<jsp:setProperty name="u" property="*"/>

<%
UserDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>