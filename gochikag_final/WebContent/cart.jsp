<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<fmt:setLocale value="${pageContext.request.locale.language}" />
		<fmt:setBundle basename="property.cart" var="lang" />
		<title><s:text name="lang.cart.cart"/></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/cart.css">
	</head>

	<body>
	<s:if test="%{#session.id != 0}">
		<s:include value="header_done.jsp" />
	</s:if>
	<s:else>
		<s:include value="header.jsp" />
	</s:else>

		<s:if test="%{itemList.isEmpty()}">
			<p> <s:text name="lang.cart.empty"/></p>
			<a href="main.jsp"><s:text name="lang.cart.continue"/></a>
		</s:if>

		<s:else>
			<div>
				<h1><s:text name="lang.cart.cart"/></h1>
			</div>

			<div class="table-wrapper">
				<table class="table table-bordered">
					<tr>
						<th class="text-center"><p>アイテム名<p></th>
						<th class="text-center"><p>単価(円)</p></th>
						<th class="text-center"><p>数量</p></th>
						<th class="text-center"><p>小計</p></th>
						<th class="text-center"><p>削除</p></th>
					</tr>

					<s:iterator value="itemList">
						<s:iterator>
							<tr>
								<td class="text-center"><p><s:property value="itemName"/></p></td>
								<td class="text-center"><p><s:property value="price"/><p></td>
								<td class="text-center">
									<form action="CartUpdateAction">
										<input type="hidden" name="itemId" value="<s:property value="itemId" />"/>
										<input type="hidden" name="price" value="<s:property value="price" />" />
										<input type="hidden" name="amount" value="<s:property value="amount" />" />
										<s:select name="itemCount" list="%{itemStockList.get(index)}"
										          onChange="this.form.submit()" cssClass="form-control" theme="css_xhtml"/>
									</form>
								</td>
								<td class="text-center"><p><s:property value="amount"/></p></td>
								<td class="text-center">
									<form action="CartDeleteAction">
										<input type="hidden" name="itemId" value="<s:property value="itemId" />"/>
										<input type="submit" type="button" value="カートから削除する" class="form-control"/>
									</form>
								</td>
							</tr>
						</s:iterator>
					</s:iterator>
				</table>
			</div>
			<div class="container">
				<div class="bottom-wrapper">
					<h1><s:text name="lang.cart.amount"/> ：<s:property value="totalPrice"/></h1>
					<!-- 購入を続ける画面へ遷移 -->
					<p><a href="main.jsp"><s:text name="lang.cart.continue"/></a></p>
					<!-- 購入画面へ遷移 -->
					<!-- カートが空のとき、クレジットカード入力画面へ進もうとするとエラーメッセージを表示 -->
					<form action="PayAction">
						<input type="submit" value="購入画面へ"/>
					</form>
				</div>
			</div>
		</s:else>
</body>
</html>