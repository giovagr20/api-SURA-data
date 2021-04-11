# api-SURA-data

# API expuestas para el consumo en otras aplicaciones, es un middleware que manejará los gastos

# PARA CORRER TU APLICACION DEBES INSTALAR MAVEN EN TU EQUIPO y en la carpeta raiz colocar el siguiente comando

## mvn spring-boot:run

Luego de ejecutado el comando dentro de la app hacer la siguiente peticion

#URL/api/init -> este se encarga de asociar los gastos a los usuarios

Para tener presente

- Base de datos utilizado MySQL
- User un servidor local como XAMPP para tener mirar el comportamiento en base de datos

# Tecnologias Usadas

- Spring boot -- Un framework de Java enfocado a base de datos
- JPA - Java persistence application, se encarga de manejar los datos relacionales
- Hibernate herramienta de mapeo ORM (Object Relation Mapped)


#rutas a tener presente

/api/users
- Obtiene todos los usuarios existentes

/api/users({id}
- Obtiene un usuario según su id asociado en Base de datos

/api/users/getUserBillTotal/{id}
- Obtiene el gasto total de los usuarios y este validará si procede o no el empleador a pagar los gastos
