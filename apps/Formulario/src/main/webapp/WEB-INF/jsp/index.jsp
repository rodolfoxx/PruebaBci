<html>
<head>
<title>Prueba bci</title>
<style type="text/css" media="screen">
      /*la directiva include copia el contenido de un archivo y lo incrusta en la pagina*/
  *{
    background-image:url(wallpaper1024x768.png);
    color:black;
}
</style>
</head>
<body>

<form action="/datos" method="post">
    Nombre:
    <input type="text" name="name">
    <br/>
    email:
    <input type="text" name="email">
    <br/>
    password:
    <input type="password" name="password">
       <br/>
    number:
    <input type="number" name="number" id="number" >
       <br/>
    citycode:
    <input type="number" name="citycode" id="citycode" >
       <br/>
     contrycode:
    <input type="number" name="contrycode" "contrycode" >
       <br/>
  
    <p><input type="submit" value="Enviar"></p>
</form>
 
 <b>${resultado}</b>
</body>
</html>