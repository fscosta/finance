<#import "ranking.ftl" as rnk>
<html>
	<head>
		<title>${ranking.title}</title>
	</head>
	<body>
		<h1>${ranking.title}</h1>
		
		<form action="save.do" method="post">
			<input type="hidden" name="id" value="${ranking.id}"
			<span>Novo nome: </span><input type="text" name="title" />
			
			<div>
				<span>ORDENACAO</span>
				
				<#list ranking.sortingRules as s>
					<@rnk.sortingRule attributes="${stockAttributes}" sort="${s}" />
				</#list>
			</div>
			
			<div>
				<span>FILTROS</span>
			</div>
			
			<input type="submit" name="Enviar" />
		</form>
		
		<div id="ruleComponent" class="hidden">
			<@rnk.sortingRule attributes=stockAttributes />
		</div>
		
	</body>
</html>