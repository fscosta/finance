<html>
	<head>
		<title>Listagem de rankings</title>
	</head>
	<body>
		<h1>Meus Rankings</h1>

		<a href="edit.do">Novo ranking</a>

		<table>
			<thead>
				<th>ID</th>
				<th>Titulo</th>
				<th>Tipo</th>
				<th>&nbsp;</th>
			</thead>
			<tbody>
			<#list rankings as ranking>
				<tr>
					<td>${ranking.id}</td>
					<td>${ranking.title}</td>
					<td>${ranking.date}</td>
					<td><a href="show.do?id=${ranking.id}">Ver ranking</a></td>
				</tr>
			</#list>
			</tbody>
		</table>
		
	</body>
</html>