<%@page import="com.saddam.dao.UserDao"%>
<jsp:useBean id="u" class="com.saddam.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int x=UserDao.save(u);
if(x>0)
{
	response.sendRedirect("useradded.jsp");
}
else
{
	response.sendRedirect("error.jsp");
}
%>