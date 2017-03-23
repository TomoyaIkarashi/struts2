<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/sakura.css">
	<title>トップ</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/slider.js"></script>
	<!-- ファビコンです　米島 -->
	<link rel="shortcut icon" href="img/favcon.ico">
</head>
<body>
	<!--  <script src="js/sakura.js"></script> -->
	<!-- ヘッダー読み込み -->
	<s:include value="header.jsp" />

	<div class="container">
		<table
			style="width: 800px; padding-left: 50px; margin-left: auto; margin-right: auto;">
			<tr>
				<!-- kagu.jspへ遷移 : 実装済み -->
				<s:form action="CategoryAction" cssClass="btn_a" theme="css_xhtml">
					<s:hidden name="category" value="kagu" />
					<td><input class="btn_a" type="submit" name="submit" value="" /></td>
				</s:form>

				<!-- kaden.jspへ遷移 : 実装済み -->
				<s:form action="CategoryAction" cssClass="btn_a" theme="css_xhtml">
					<s:hidden name="category" value="kaden" />
					<td><input class="btn_b" type="submit" name="submit" value="" /></td>
				</s:form>

				<!-- sale.jspへ遷移 : 実装済み -->
				<s:form action="CategoryAction" cssClass="btn_a" theme="css_xhtml">
					<s:hidden name="category" value="sale" />
					<td><input class="btn_c" type="submit" name="submit" value="" /></td>
				</s:form>
			</tr>
		</table>
	</div>
	<div class="wrapper">
		<ul id="slideshow">
			<li class="current"><img src="img/top-header-mainimg/interia.jpg" class="img"></li>
			<li><img src="img/top-header-mainimg/child.jpg" class="img"></li>
			<li><img src="img/top-header-mainimg/usagi.jpg" class="img"></li>
		</ul>
	</div>
	<div align="center">
	<%-- <c:import url="http://localhost:8080/openconnect/footer.jsp" /> --%>
	</div>

</body>
</html>