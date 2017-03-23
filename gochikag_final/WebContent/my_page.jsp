<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>マイページ</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<style>
  		.my-page-header-wrapper{
  			width: 80%;
  			margin: 10px auto;
  			text-align: center;
  		}
  	
  		.table-wrapper{
  			width: 80%;
  			margin: 10px auto;
  		}
  		
  		.message-wrapper{
  			width: 80%;
  			margin: 10px auto;
  			text-align: center;
  		}
  		
  		.my-page-footer{
  			width: 80%;
  			margin: 10px auto;
  			text-align: center;
  		}
  		
  	</style>
</head>
<body>
	<s:include value="header_done.jsp" />
	
	<div class="my-page-header-wrapper">
		<h1>購入履歴</h1>
	</div>
	
	<!-- 購入履歴の処理にD3.jsを加える予定 -->
	<s:if test="%{!myInfo.isEmpty()}">
		<div class="table-wrapper">
			<table class="table table-bordered">
				<tr class="something">
					<th class="text-center col-md-4">購入日</th>
					<th class="text-center col-md-4">商品名</th>
					<th class="text-center col-md-4">合計金額</th>
				</tr>
				<s:iterator value="myInfo">
					<s:iterator>
						<tr class="something">
							<td class="text-center col-md-4"><s:property value="date" /></td>
							<td class="text-center col-md-4"><s:property value="itemName" /></td>
							<td class="text-center col-md-4"><s:property value="amount" /></td>
						<tr>
					</s:iterator>
				</s:iterator>
			</table>
		</div>
	</s:if>
	<s:else>
		<div class="message-wrapper">
			<h3>購入履歴はありません。</h3>
		</div>
	</s:else>
	
	<div class="my-page-footer">
		<a href="main.jsp">トップへ</a>
	</div>
</body>
</html>