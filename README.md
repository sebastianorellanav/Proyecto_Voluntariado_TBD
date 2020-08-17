# Aplicación de Voluntariado

## Estructura del Código 📃 ⚙️

El código de la aplicación de divide en dos partes -Frontend y Backend- las cuales deben compilarse y ejecutarse por separado. La sección se Frontend contiene las vistas de la aplicación. La parte de Backend contiene la lógica de la aplicación. 

**IMPORTANTE:** se debe utilizar la base de datos *voluntariadodb_backup_contrigger* ubicada en la carpeta raíz del proyecto. 


## Como Ejecutar el Backend ✈️

Antes de ejecutar el backend se debe modificar el archivo application.properties ubicado en */Backend/src/main/resources/apliccation.properties* con las credenciales de la base de datos (usuario y contraseña).

El backend se puede ejecutar utilizando el entorno de desarrollo Intellij o utilizando la terminal de Linux con el siguiente comando:

```
gradle Bootrun
```
Si ejecuta el backend con el comando indicado se debe ubicar en la carpeta backend del proyecto

## Como Ejecutar el Frontend 🚀 

Se debe ubicar en la carpeta Frontend del proyecto y utilizar el siguiente comando en la terminal:

```
npm install
```
y Luego:

```
npm run serve
```

**IMPORTANTE:** se debe ejecutar primero el backend y luego el frontend para evitar conflictos con los puertos. 

