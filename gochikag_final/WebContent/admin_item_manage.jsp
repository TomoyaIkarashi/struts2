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
	<fmt:setBundle basename="property.adminItemManage" var="lang" />
	<title><s:text name="manage"/></title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		.direction{
			text-align: center;
			margin: 20px auto;
		}

		.phase1{
			width: 80%;
			margin: 20px auto;
		}
		.phase2{
			width: 80%;
			margin: 20px auto;
		}
		.phase3{
			width: 80%;
			margin: 20px auto;
		}



	</style>

</head>
<body>
	<div class="direction">
		<h1><s:text name="lang.admin_item_manage.up&del"/></h1>
	</div>

	<div class="phase1">
		<form action="AdminItemManageAction">
			<input type="hidden" name="phase" value="1">
			<select name="category" onChange="this.form.submit()" class="form-control">
				<option value="" selected="selected"><s:text name="lang.admin_item_manage.chooseCate"/></option>
				<option value="kagu"><s:text name="lang.admin_item_manage.furniture"/></option>
				<option value="kaden"><s:text name="lang.admin_item_manage.electricMachine"/></option>
				<option value="sale"><s:text name="lang.admin_item_manage.sale"/></option>
			</select>
		</form>
	</div>

	<s:if test="%{phase == 2 || phase == 3}">
		<div class="phase2">
			<form action="AdminItemManageAction">
				<input type="hidden" name="category" value="<s:property value="category" />"/>
				<input type="hidden" name="phase" value="2">
				<s:select name="itemName" list="nameList" onChange="this.form.submit()"
						  placeholder='商品を選択してください' cssClass="form-control" theme="css_xhtml"/>
			</form>
		</div>
	</s:if>

	<s:if test="%{phase == 3}" >
		<div class="phase3">
			<table class="table table-bordered">
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>現在の在庫数</th>
					<th>新しい在庫数</th>
					<th>削除</th>
				</tr>
				<tr>
					<td>
						<s:property value="%{dto.getItemId()}" />
					</td>
					<td>
						<s:property value="%{dto.getItemName()}" />
					</td>
					<td>
						<s:property value="%{dto.getPrice()}" />
					</td>
					<td>
						<s:property value="%{dto.getStockNumber()}" /> :
					</td>
					<td>
						<s:form action="AdminItemManageAction">
							<input type="hidden" name="phase" value="3" />
							<input type="hidden" name="category" value="<s:property value="category" />"/>
							<input type="hidden" name="itemName" value="<s:property value="%{dto.getItemName()}" />" >
							<input type="hidden" name="itemId" value="<s:property value="%{dto.getItemId()}" />" >
							<s:select name="stockNumber" list="newStockNumberList" onChange="this.form.submit()"
						          	  cssClass="form-control" theme="css_xhtml"/>
						</s:form>
					</td>
					<td>
						<s:form>
							<input type="hidden" name="phase" value="4" />
							<input type="hidden" name="itemId" value="<s:property value="%{dto.getItemId()}" />" />
							<input type="submit" value="削除する">
						</s:form>
					</td>
				</tr>
			</table>
		</div>
	</s:if>


</body>
</html>