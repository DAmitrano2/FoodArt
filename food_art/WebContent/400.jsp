<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html lang="it">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="icon" href="${pageContext.request.contextPath}/assets/images/icon.png" type="image/icon type">
	<title>FoodArt - Errore 400</title>

	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/error_page_style.css" />

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>Oops!</h1>
			</div>
			<h2>400 - Bad Request</h2>
			<p><%= exception.getMessage()%></p>
			<a href="${pageContext.request.contextPath}/index">Vai alla pagina iniziale</a>
		</div>
	</div>

</body>
</html>