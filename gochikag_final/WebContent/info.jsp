<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>お問い合わせ</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<style>
		body{
		  background-color:  #F9F8F4;
		}
		.contents {
		width: 600px;
		margin: 0 auto;
		}
		.contents h1 {
		text-align: center;
		}
		.contents h2 {
		text-align: center;
		}
		.submit {
		text-align: center;
		}
	</style>
</head>
<body>
	<s:if test="%{#session.id != 0}">
		<s:include value="header_done.jsp" />
	</s:if>
	<s:else>
		<s:include value="header.jsp" />
	</s:else>


	<s:form action="InfoAction">
		<div class="container">
			<div class="contents">
				<h1><s:text name="lang.info.contact"/></h1>
				<div>
					<h2> <s:textfield name="name" label = "名前"/></h2>
					<h2> <s:textfield name="email" label = "メールアドレス"/></h2>
					<h2>
						<s:textfield name="info" size="45" label = "内容"/>
					</h2>
				</div>
			</div>
		</div>

	    <s:submit value="%{getText('lang.info.submit')}"/>
	</s:form>

	<s:property value="name"/>
	<s:property value="email"/>
	<s:property value="info"/>



</body>
</html>