# Getting Started
1.-Se debe tener instalado spring boot 
2.-Se debe abrir la aplicación con spring tool suite 
3.-En el menú file - Open Projects from file system se debe ir a la ruta de la carpeta y presionar el botón finish 
4.-Sobre la carpeta del proyecto se debe hacer click derecho y se debe ir al menu Gradle - Refresh Gradle Project
5.-Esperamos que se bajen las dependencias y se debe hacer click derecho sobre la aplicación - run As -Spring boot app 
6.-Para probar si esta correcta se debe ir a post man 
7.-Se coloca la url http://localhost:8080/saveUsuario en post man y debe salir el mensaje en forma de json acceso denegado,ya que es requerido un token para acceder a la api
8.-Si se requiere generar el token para probar la api en post man se debe hace un post a http://localhost:8080/authenticate con la siguente estructura

{
"username": "pruebaApiRestFull",
"password": "password"

}

9.-El token generado se debe colocar en la opción de menú Authorizartion del postman ,opción-Bearer Token;

10.-Nuevamente se hace el llamado a la api para saber si esta ok con la ruta http://localhost:8080/saveUsuario  y en el body

{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
{
"number": "1234567",
"citycode": "1",
"contrycode": "57"
}
]
}


 