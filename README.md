# Microservices Academy IBM
El siguiente repositorio es para mostrar el ejercicio numero uno de evaluacion de la academia de microservicios

## Objetivo 
Construir un __Micro Servicio \ API__ donde el usuario o sistema pasa la información para definir el perfil de tarjetas de crédito.

## Descripcion Microservicio
El microservicio esta implementado para dos perfiles:
* Administrador 

El perfil de administrado cuenta con la conexion a la base de datos. Y ademas, cuenta con servicios que el usuario no cuenta, como
el listado de perfiles por _Pasion_, _Salario_ y _Edad_. Cabe mencionar que para entrar a este perfil solo se debe de hacer uso del _Admin Microservicio_

* Usuario

El perfil de usuario cuenta con menos funcionalidades que el usuario. En este perfil solo esta permitido que segun su perfil obtine un listado de 
tarjetas a las que se amolda su perfil. Cabe mencionar que para entrar a este perfil solo se debe de hacer uso del _User Microservicio_

## Arquitectura propuesta

![Arquitectura MIcroservicio](https://github.com/alevs97/MicroservicesIBM/blob/main/Untitled%20Diagram.drawio.png)

### Explicacion de la arquitectura
Se implemento esta arquitectura con el fin de utilizar los conceptos vistos en clase. Donde el _User Microservicio_ por medio de 
_Naming Server_ balancea la carga en dos microservicios de tipo _Admin Microservice_. Esto da redundancia a la solucion permitiendo que si 
se aumenta la cantidad de Usuarios, estos puedan ser mejor atendidos.

## Endoints

### Endpoints de _Admin Microservice_

Los endpoints de este microservicio son:
* http://localhost:8000/age/{age} o http://localhost:8001/age/{age}

El siguiente endpoint trae una lista de perfiles que hace match con _age_. Este debe de ser un numero entero entre un rango del 18 al 75. Una respuesta de este endpoint
seria de esta forma:
```
[
    {
        "passion": "shopping",
        "minSalary": 7000.0,
        "maxSalary": 14999.0,
        "minAge": 33,
        "maxAge": 75,
        "creditCards": "Clasica, Office Depot, Cotsco, Best Buy Banamex, The Home Depot"
    },
    {
        "passion": "shopping",
        "minSalary": 15000.0,
        "maxSalary": 34999.0,
        "minAge": 33,
        "maxAge": 75,
        "creditCards": "Oro, Office Depot, Cotsco, Best Buy, Banamex, The Home Depot"
    },
]
```
Una respuesta fuera del rango de 18 a 75 seria:
```
{
    "input": "512",
    "message": "Available ages (18 - 75) - Check your input",
    "service": "Error in service - listOfCardsByAge"
}
```

* http://localhost:8000/passion/{passion} o http://localhost:8001/passion/{passion}

El siguiente endpoint trae una lista de perfiles que hace match con _passion_. Este debe de ser un String con el nombre que haga match con el de la base de datos. Una respuesta de este endpoint
seria de esta forma:
```
[
    {
        "passion": "travels",
        "minSalary": 12000.0,
        "maxSalary": 29999.0,
        "minAge": 18,
        "maxAge": 75,
        "creditCards": "Citi / AAdvantage"
    },
    {
        "passion": "travels",
        "minSalary": 30000.0,
        "maxSalary": 34999.0,
        "minAge": 18,
        "maxAge": 23,
        "creditCards": "Citi / AAdvantage "
    },
]

```

Una respuesta que no coincida seria de este tipo:

```
{
    "input": "travelss",
    "message": "Passion Not Available - Check your input",
    "service": "Error in service - listOfCardsByPassion"
}

```


* http://localhost:8000/salary/{salary} o http://localhost:8001/salary/{salary}

El siguiente endpoint trae una lista de perfiles que hace match con _salary_. Este debe de ser un numero superio a 7000 y no debe de contener comas o caracteres. Una respuesta de este endpoint
seria de esta forma:

```
[
    {
        "passion": "shopping",
        "minSalary": 7000.0,
        "maxSalary": 14999.0,
        "minAge": 18,
        "maxAge": 23,
        "creditCards": "B-Smart, Afinity Card"
    },
    {
        "passion": "shopping",
        "minSalary": 7000.0,
        "maxSalary": 14999.0,
        "minAge": 24,
        "maxAge": 32,
        "creditCards": "B-Smart, Clasica, Afinity Card, Office Depot, Costco, BestBuy Banamex, The Home Depot"
    },
]

```

Una respuesta que no este en este rango seria respondida como:

```
{
    "input": "1234.0",
    "message": "Salary under the range of 7,000 - Check your input",
    "service": "Error in service - listOfCardsBySalary"
}

```


* http://localhost:8000/passion/{passion}/salary/{salary}/age/{age} o http://localhost:8001/passion/{passion}/salary/{salary}/age/{age}

El siguiente endpoint trae un perfil que haga match con _passion_, _salary_ y _age_. Este endpoint debe de cumplir las condiciones de las peticiones anteriores. Una respuesta de este endpoint
seria de esta forma:

```
{
    "passion": "shopping",
    "minSalary": 7000.0,
    "maxSalary": 14999.0,
    "minAge": 18,
    "maxAge": 23,
    "creditCards": "B-Smart, Afinity Card"
}

```

Una respuesta que no este en este rango seria respondida como:

```
{
    "input": "Passion ->shopping|  Salary ->12000.0|  Age ->192",
    "message": "Available ages (18 - 75), Salary under the range of 7,000 or Passion Not Available - Check your inputs",
    "service": "Error in service - listOfCardsByPassionSalaryAge"
}

```
