<html>
	<head>
		<title>Finance - ${ranking.title}</title>
	</head>
	<body>
		<h1>${ranking.title}</h1>

		<p>Última atualização: ${ranking.date}</p>
		<a href="edit.do?id=${ranking.id}">Renomear...</a>|
		<a href="refresh.do?id=${ranking.id}">Atualizar</a>|
		<a href="delete.do?id=${ranking.id}">Remover</a>
		
		<table>
			<thead>
				<th>Posição</th>
				<th>Titulo</th>
				<th>Tipo</th>
				<th>&nbsp;</th>
			</thead>
			<tbody>
			<c:forEach items="${ranking.items}" var="item">
				<tr>
					<td>${item.rankingPosition}</td>
					<td>${item.stock.code}</td>
					<td><a href="../stock/show.do?code=${item.stock.code}">Ver papel</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>