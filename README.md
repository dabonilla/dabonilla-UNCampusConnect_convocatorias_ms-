# dabonilla-UNCampusConnect_convocatorias_ms

## Opción 1: con docker compose

Entrar en la carpeta UN-CampusConnect_convocatorias_ms y ejecutar el siguiente comando: ```docker-compose up -d```
Es necesario tener instalado docker compose.

## Opción 2: 

Es necesario crear una red:  ```docker network create miRed ```
### Contenedor ms

Entrar en la carpeta UB-CampusConnect_convocatorias_ms y ejecutar el siguiente comando para crear la imagen:
```docker build -t convocatorias_ms . ```

El siguiente comando es para crear el contenedor y ejecutarlo:
``` docker run --network miRed -p 8080:8080 --name UN-CampusConnect_convocatorias_ms convocatorias_ms ```

### Contenedor db

Entrar en la carpeta UB-CampusConnect_convocatorias_db y ejecutar el siguiente comando para crear la imagen:
docker build -t mi-imagen-neo4j .

El siguiente comando es para crear el contenedor y ejecutarlo:

``` docker run -d --name UNCampusConnectConvocatoriasDB --network miRed -p 7474:7474 -p7687:7687  mi-imagen-neo4j``` 




