<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="css/header_done.css">
<html>
<body>
	<div class="menu">
		<a href="top.jsp" class="header-comment">　　＊”すべてが、かわいい。”アンティークの家具なら、「ごちかぐ」でご注文をどうぞ！＊</a>
		<div align="right">
			<table>
				<tr>
					<th>
						<s:form action="LogoutAction" class="header-form">
							<input type=submit name=submit value=<s:text name="lang.headerDone.logout"/>>
						</s:form>
					</th>
					<th>
						<s:form action="MyPageAction" class="header-form">
							<s:hidden name="userId" value="%{#session.userId}" />
							<s:submit value="%{getText('lang.headerDone.mypage')}" />
						</s:form>
					</th>
					<th>
						<div class="header-form">
							<a href="info.jsp"><s:text name="lang.headerDone.contact"/></a>
						</div>
					</th>
					<th>
						<s:form action="CartSelectAction" class="header-form">
							<s:submit value="%{getText('lang.headerDone.cart')}"/>
						</s:form>
					</th>
				</tr>
			</table>
		</div>
		<hr color="Salmon" width="100%" size="10" />
		<div class="back-img">
			<div class="logo">
				<a href="main.jsp"><img class="logo" src="img/top-header-mainimg/logo.png"></a>
			</div>
		</div>
	</div>

</body>
</html>