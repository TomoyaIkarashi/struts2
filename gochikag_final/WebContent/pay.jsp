<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>お支払い方法確認画面</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/pay.css">
</head>
<body>

	<div align="center">
		<h1>クレジットカード認証入力</h1>
	</div>
	
	<s:form action="CreditConfirmAction">
		<div class="cover cover1">
			<p class="form-text">苗字:</p>
			<s:textfield name="lastName" size ="10" maxlength="10" cssClass="lastName" theme="css_xhtml"/>
		</div>
		<div class="cover cover1">
			<p class="form-text">名前:</p>
			<s:textfield name="firstName" size="10" maxlength="10" cssClass="firstName" theme="css_xhtml"/>
		</div>
		
		<div class="cover">
			<p class="choose-credit choose-credit-text">クレジットカード選択:</p>
			<div class="choose-credit">
				<select name="cardBrand" class="choose-credit-select">
					<option value="visa">Visa</option>
					<option value="master">Master</option>
					<option value="amex">American Express</option>
				</select>
			</div>
    	</div>
		
		<div class="cover">
			<p class="card-number-text">クレジット番号:</p>
			<div class="card-number-box">
				<s:textfield name="creditNumber1" placeholder="0000" size ="4" maxlength='4' cssClass="card-number card-number-1" theme="css_xhtml"/>
				<s:textfield name="creditNumber2" placeholder="0000" size ="4" maxlength='4' cssClass="card-number card-number-2" theme="css_xhtml"/>
				<s:textfield name="creditNumber3" placeholder="0000" size ="4" maxlength='4' cssClass="card-number card-number-3" theme="css_xhtml"/>
				<s:textfield name="creditNumber4" placeholder="0000" size ="4" maxlength='4' cssClass="card-number card-number-4" theme="css_xhtml"/>
			</div>
		</div>
		
		<div class="cover">
			<p class="card-security-text">セキュリティ番号</p>
			<div class="card-security-number">
				<s:textfield name="securityCode" placeholder="000" size="3" maxlength="3" cssClass="card-security" theme="css_xhtml"/>
			</div>
		</div>
		
		<div class="cover">
			<p class="card-expiration-text">クレジットカード有効期限</p>
			<div class="card-expiration-box">
				<select name="expirationYear" class="card-expiration">
					<option value="2017">2017</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2020">2021</option>
					<option value="2020">2022</option>
				</select>
				<select name="expirationMonth" class="card-expiration">
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>	
			</div>
		</div>
		<div class="cover">
	 		<input type="submit" value="次へ" />
	 	</div>
	</s:form>

<script src="js/pay.js"> </script>	
</body>
</html>