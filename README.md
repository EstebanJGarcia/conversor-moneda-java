# Challange conversor de moneda Alura-Latam | Oracle Next Education

# Conversor de Moneda en Java

Este es un proyecto de conversión de monedas desarrollado en Java, que permite convertir entre diversas monedas (Dólar, Peso argentino, Real brasileño, Peso chileno) utilizando la API de ExchangeRate-API. Además, registra cada conversión realizada en un archivo log y genera un archivo JSON con el resultado

## Requisitos
    - Java 17 o superior
    - Librerías externas:
    - Gson (para manipulación de archivos JSON)
    Puedes incluir estas dependencias en tu pom.xml si usas Maven:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>

```

## Configuración

### API Key de ExchangeRate-API: Necesitas registrarte en [ExchangeRate-API](https://www.exchangerate-api.com/) y obtener tu clave API. Esta clave se utiliza para realizar las solicitudes de tasa de cambio entre las distintas monedas.

Configuración del proyecto: Asegúrate de haber importado las dependencias de Gson y cualquier otra librería que uses para manejar solicitudes HTTP.


### Estructura del Proyecto

PrincipalConversor.java
Es el archivo principal que gestiona la interacción con el usuario. Permite seleccionar la conversión de moneda y solicita el valor a convertir. Dependiendo de la opción seleccionada, se hace una consulta a la API y muestra el resultado.

GenerarJson.java
Se encarga de generar un archivo JSON con los detalles de la conversión y de registrar cada conversión en un archivo de log (registro_conversiones.log). Usa la librería Gson para crear el archivo JSON.

ConversorApi.java
Contiene la lógica de conexión con la API de ExchangeRate-API y la obtención de la tasa de cambio entre las monedas seleccionadas.

DivisasApi.java
Es la clase que contiene la estructura de los resultados de la conversión, como el valor convertido y la tasa de cambio.


Ejemplo de ejecución:
```
Conversor de Moneda
Selecciona una conversión:
    1- Dólar => Peso argentino
    2- Peso argentino => Dólar
    3- Dólar => Real brasileño
    4- Real brasileño => Dólar
    5- Dólar => Peso chileno
    6- Peso Chileno => Dólar
    0- Salir.
Ingrese una opción [1-6]: 1
Ingrese el valor que desea convertir (debe ser un número mayor a 0): 100
El valor de 100 [USD] equivale a 10650.0 [ARS]
```

### Ejemplo del archivo Json que se genera:
```
(USD-ARS.json)
{
  "base_code": "USD",
  "target_code": "ARS",
  "conversion_rate": 1044.5,
  "conversion_result": 1044500.0
}
```
### Ejemplo del archivo log que se actualiza al salir del conversor:
(registro_conversiones.log)

```
[2025-01-18 02:20:39] Conversión realizada: USD -> ARS
[2025-01-18 02:21:20] Conversión realizada: ARS -> USD
[2025-01-18 02:25:56] Conversión realizada: ARS -> USD
```


