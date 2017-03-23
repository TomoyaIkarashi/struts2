<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<fmt:setLocale value="${pageContext.request.locale.language}" />
	<fmt:setBundle basename="property.admin" var="lang" />
	<title><s:text name="lang.admin.admin"/></title>
</head>
<body>

<a href="admin_item_register.jsp"><s:text name="lang.admin.regi"/></a>

<a href="admin_item_manage.jsp"><s:text name="lang.admin.manage"/></a>

<s:form action="AdminInfoAction">
	<s:hidden name="" value=""/>
	<s:submit value="お問い合わせ管理"/>
</s:form>

</body>
</html>