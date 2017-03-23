<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>購入完了</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/confirm_done.css">
</head>
<body>
	<s:include value="header_done.jsp" />

	<div align="center">
		<h1>ご注文承りました.</h1>
	</div>
	
	<div class="bottom-wrapper">
		<div class="bottom-left">
			<form action="MyPageAction">
				<input type="hidden" name="userId" value="<s:property value="#session.userId" />" >
				<button type="submit" class="btn btn-success">マイページで確認</button>
			</form>
		</div>
		<div class="bottom-right">
			<a href="main.jsp"><button class="btn btn-success">トップへ戻る</button></a>
		</div>
	</div>
	
</body>
</html>