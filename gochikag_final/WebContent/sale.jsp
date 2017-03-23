<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<fmt:setLocale value="${pageContext.request.locale.language}" />
	<fmt:setBundle basename="property.sale" var="lang" />

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>セール</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/header_done.css">
	<link rel="stylesheet" type="text/css" href="css/kagu_kaden_sale.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<s:if test="%{#session.id != 0}">
		<s:include value="header_done.jsp" />
	</s:if>
	<s:else>
		<s:include value="header.jsp" />
	</s:else>


<div class="top-wrapper">
	<h1><s:text name="lang.sale.saleItemList" /> </h1>
</div>

<div class="form-wrapper">
	<s:iterator value="items">
		<s:iterator>
			<s:if test="%{itemCount % 2 == 0}">
				<form action="ItemAction" class="form1">
					<input type="hidden" name="itemId" value="<s:property value="itemId"/>" />
					<input type="image" src="<s:property value="url"/>" class="image" />
					<div class="message">
						<p><s:text name="lang.sale.itemName"/>: <s:property value="itemName" /></p>
						<p><s:text name="lang.sale.price"/>: <s:property value="price" /><s:text name="lang.sale.yen"/></p>
					</div>
				</form>
			</s:if>
			<s:else>
				<form action="ItemAction" class="form2">
					<input type="hidden" name="itemId" value="<s:property value="itemId"/>" />
					<input type="image" src="<s:property value="url"/>" class="image"/>
					<div class="message">
						<p><s:text name="lang.sale.itemName"/>: <s:property value="itemName" /></p>
						<p><s:text name="lang.sale.price"/>: <s:property value="price" /><s:text name="lang.sale.yen"/></p>
					</div>
				</form>
			</s:else>
		</s:iterator>
	</s:iterator>
</div>
</body>
</html>