
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC</title>
<style>
body {
	margin-top: 20px;
	margin-bottom: 20px;
	background-color: #DFDFDF;
}

#menu li {
	display: inline;
	list-style-type: none;
	padding-right: 20px;
}
</style>
</head>
<body>
	<div class="container"
		style="border: #C1C1C1 solid 1px; border-radius: 10px;">
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- Menu Page -->
		<div class="span-5  border" id="menu"
			style="height: 40px; background-color: #FCFCFC;">
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- Body Page -->
		<div class="span-19 last">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- Footer Page -->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>