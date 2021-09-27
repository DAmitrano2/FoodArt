<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
		<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="./assets/images/icon.png" type="image/icon type">
    <title>FoodArt - Bad Request</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page_error.css">
		
  </head>


  <body>

<div class="conatiner"><span class="numer">4</span>
  <div class="circle">
    <div class="drops"></div>
    <div class="drops"></div>
    <div class="hand"></div>
    <div class="hand rgt"></div>
    <div class="holder">
      <div class="bob">
        <div class="nose"></div>
        <div class="face">
          <div class="mouth">
            <div class="tongue"></div>
          </div>
        </div>
        <div class="ear"></div>
        <div class="ear rgt"></div>
        <div class="neck"></div>
      </div>
    </div>
  </div>
  <span class="numer">0</span><br>
  <span class="text"><!-- %= exception.getMessage()% --></span><br>
  <span class="link"><a href="${pageContext.request.contextPath}/index">Clicca qui per tornare al sito!</a></span>
</div>

</body>
</html>