<#import "../ranking.ftl" as rnk>
<#import "../spring.ftl" as spring />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
	<head>
		<title>Novo ranking</title>
		<link type="text/css" rel="stylesheet" href="<@spring.url '/static/css/finance.css'/>" />
		<script type="text/javascript" src="<@spring.url '/static/js/jquery/jquery-1.4.4.js'/>"></script>
		<script type="text/javascript" src="<@spring.url '/static/js/finance.js'/>"></script>
	</head>
	<body>
		<h1>Novo ranking</h1>
		
		<@form.form modelAttribute="ranking" action="save.do" method="post">
			<span>Novo nome: </span><input type="text" name="title" />
			
			<div>
				<span>ORDENACAO</span><a id="addSort" href="#">+</a>
				<div id="sortingRules">
				</div>
			</div>
			
			<div>
				<span>FILTROS</span><a id="addFilter" href="#">+</a>
				<div id="filters">
				</div>
			</div>
			
			<input type="submit" value="Enviar" />
		</@form.form>
		
		<div id="ruleComponent" class="hidden">
			<@rnk.sortingRule attributeOptions=stockAttributes ascendingOptions={"true":"Crescente", "false":"Decrescente"} />
		</div>
		
		<div id="filterComponent" class="hidden">
			<@rnk.filter attributeOptions=stockAttributes operatorOptions={"0":"<", "1":">"} />
		</div>
		
	</body>
</html>