<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<fmt:setLocale value="${pageContext.request.locale.language}" />
	<fmt:setBundle basename="property.adminItemRegister" var="lang" />
	<title><s:text name="lang.admin_item_register.regi"/></title>
	<style>
		.manage {
			display: block;
		}
	</style>
</head>
<body>

	<s:form action="AdminItemRegisterAction">
		<s:textfield name="itemName" label="商品名" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="price" label="価格" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="stockNumber" label="在庫数" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="mainPicture" label="写真" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="subPicture1" label="サブ写真1" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="subPicture2" label="サブ写真2" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="subPicture3" label="サブ写真3" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="detailJa" label="詳細（日本語）" required="required" cssClass="manage" theme="css_xhtml"/>
		<s:textfield name="detailEn" label="詳細（英語）" required="required" cssClass="manage" theme="css_xhtml"/>
		<select name="category">
			<option value="kagu"><s:text name="lang.admin_item_register.furniture"></s:text></option>
			<option value="kaden"><s:text name="lang.admin_item_register.electricMachine"></s:text></option>
			<option value="sale"><s:text name="lang.admin_item_register.sale"></s:text></option>
		</select>
		<s:submit value="送信" cssClass="manage" theme="css_xhtml"/>
	</s:form>
</body>
</html>