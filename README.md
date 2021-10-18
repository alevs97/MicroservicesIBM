# Microservices Academy IBM
El siguiente repositorio es para mostrar el ejercicio numero uno de evaluacion de la academia de microservicios

## Objetivo 
Construir un __Micro Servicio \ API__ donde el usuario o sistema pasa la información para definir el perfil de tarjetas de crédito.

## Descripcion Microservicio
El microservicio esta implementado para dos perfiles:
* Administrador 

El perfil de administrado cuenta con la conexion a la base de datos. Y ademas, cuenta con servicios que el usuario no cuenta, como
el listado de perfiles por _Pasion_, _Salario_ y _Edad_. Cabe mencionar que para entrar a este perfil solo se debe de hacer uso del _Microservice Admin_

* Usuario

El perfil de usuario cuenta con menos funcionalidades que el usuario. En este perfil solo esta permitido que segun su perfil obtine un listado de 
tarjetas a las que se amolda su perfil. Cabe mencionar que para entrar a este perfil solo se debe de hacer uso del _Microservice User_

## Arquitectura propuesta

![Arquitectura MIcroservicio](https://github.com/alevs97/MicroservicesIBM/blob/main/Untitled%20Diagram.drawio.png)

### Explicacion de la arquitectura
Se implemento esta arquitectura con el fin de utilizar los conceptos vistos en clase. Donde el _Microservicio User_ por medio de 
_Naming Server_ balancea la carga en dos microservicios de tipo _Microservice Admin_. Esto da redundancia a la solucion permitiendo que si 
se aumenta la cantidad de Usuarios, estos puedan ser mejor atendidos.

## Endoints


