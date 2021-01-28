<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script data-search-pseudo-elements defer src="https://use.fontawesome.com/releases/latest/js/all.js" integrity="sha384-L469/ELG4Bg9sDQbl0hvjMq8pOcqFgkSpwhwnslzvVVGpDjYJ6wJJyYjvG3u8XW7" crossorigin="anonymous"></script>

    <style>
      .remember input[type="checkbox"] {
          appearance: none;
          -webkit-appearance: none;
          width: 20px;
          height: 20px;
          background-color: white;
          border: 1px solid black;
          border-radius: 2px;
          cursor: pointer;
          display: flex;
          align-items: center;
          justify-content: center;
          outline: none;
      }
      .remember input[type="checkbox"]:after{
          font-family: "Font Awesome 5 Free";
          font-weight: 900;
          content: "\f00c";
          font-size: 1rem;
          color:black;
          display: none;
      }
      .remember input[type="checkbox"]:checked{
          background-color: #FFC312;
      }
      .remember input[type="checkbox"]:checked:after{
          display: block;
      }
      .remember label{
          margin-bottom: 0;
          color: white;
          font-size: 1rem;
          height: auto;
          cursor: pointer;
      }

    </style>
    <!-- Icon CSS -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
  
    <link rel="icon" href="./images/icon.png" type="image/icon type">
    <title>FoodArt</title>
  </head>
  <body style="background-color: brown;">
    <div class="row align-items-center remember">
      <input type="checkbox" id="remember-check">
        <label for="remember-check">Resta connesso.</label>
    </div>
  </body>
</html>