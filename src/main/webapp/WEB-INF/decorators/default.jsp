<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><decorator:title default="Finance" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-5">
		<link type="text/css" rel="stylesheet" href="<%= request.getContextPath()  %>/static/css/style.css" />
		<decorator:head />
	</head>
	<body>
		<div id="header">
			<a href="<%= request.getContextPath()  %>/index.jsp"><img src="<%= request.getContextPath()  %>/static/img/logo.jpg" alt="" width="186" height="45" /></a>																																													
			<div id="small">
				<a href="#"><img src="<%= request.getContextPath()  %>/static/img/small1.gif" alt="" width="39" height="41" /></a>																												
				<a href="#"><img src="<%= request.getContextPath()  %>/static/img/small3.gif" alt="" width="39" height="41" /></a>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li>
					<a href="<%= request.getContextPath()  %>/index.jsp">
						<img src="<%= request.getContextPath()  %>/static/img/home_tab.jpg" alt="" width="93" height="29" />
					</a>
				</li>
				<li>
					<a href="<%= request.getContextPath()  %>/ranking/list.do">
						<img src="<%= request.getContextPath()  %>/static/img/halloffame_tab.jpg" alt="" width="93" height="29" />
					</a>
				</li>
				<li>
					<a href="<%= request.getContextPath()  %>/stock/list.do">
						<img src="<%= request.getContextPath()  %>/static/img/contact_tab.jpg" alt="" width="93" height="29" />
					</a>
				</li>
				<li>&nbsp;</li>
			</ul>
		</div>
		<decorator:body />
		<div id="footer">
			<a href="<%= request.getContextPath()  %>/index.jsp">Home</a>  |  <a href="index2.html">About us</a>  |  <a href="index2.html">Solutions</a>  |  <a href="index2.html">Services</a>  |  <a href="index2.html">Clients</a>  |  <a href="index2.html">Partners</a>  |  <a href="index2.html">Contacts</a> <br />
			Copyright &copy;. All rights reserved. Design by <a href="http://www.bestfreetemplates.info" class="bft" title="Best Free Templates" target="_blank">BFT</a>																																																																																																																									<div class="inner_copy"><a href="http://www.beautifullife.info/">beautiful</a><a href="http://www.grungemagazine.com/">grunge</a></div>
		</div>
	</body>
</html>