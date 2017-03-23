<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>購入手続き確認画面</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/confirm.css">

</head>
<body>
	<div align="center">
		<h1><s:text name="lang.confirm.orderConfirmation"/></h1>
	</div>

	<div class="credit-wrapper">
		<div class="pay">
			<h2><s:text name="lang.confirm.paymentMethod"/></h2>
			<p><s:text name="lang.confirm.creditCard"/>: <s:property value="cardBrand" /></p>
			<p><s:text name="lang.confirm.lastFourDigits"/>: <s:property value="lastFourDigits" /></p>
		</div>
		<div class="detail">
			<h2><s:text name="lang.confirm.detail"/></h2>
			<p><s:text name="lang.confirm.total"/>: <s:property value="totalPrice" /><s:text name="lang.confirm.yen"/></p>
			<form action="PayConfirmAction">
				<s:hidden name="loginId" value="%{loginId}" />
				<s:hidden name="lastName" value="%{lastName}" />
				<s:hidden name="firstName" value="%{firstName}" />
				<s:hidden name="nameE" value="%{nameE}" />
				<s:hidden name="cardBrand" value="%{cardBrand}" />
				<s:hidden name="firstSixDigits" value="%{firstSixDigits}" />
				<s:hidden name="totalPrice" value="%{totalPrice}"/>
				<input type="submit" value=<s:text name="lang.confirm.submit"/> class="btn btn-success submit-btn"/>
			</form>
		</div>
	</div>
	<div class="btn-wrapper">
		<form action="GoBackCartSelectAction" class="form1">
			<input type="submit" value=<s:text name="lang.confirm.backToCart"/> class="btn btn-danger"/>
		</form>
		<form action="GoBackCreditConfirmAction" class="form2">
			<input type="submit" value=<s:text name="lang.confirm.backToPurchase"/> class="btn btn-danger"/>
		</form>
	</div>
</body>
</html>