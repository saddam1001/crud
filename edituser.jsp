
	<%@page import="com.saddam.dao.UserDao"%>
	<jsp:useBean id="u" class="com.saddam.bean.User"></jsp:useBean>
	<jsp:setProperty property="*" name="u"/>
	<%
		int i=UserDao.edit(u);
		response.sendRedirect("viewusers.jsp");
	%>
