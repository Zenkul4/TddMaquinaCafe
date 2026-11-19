# Máquina de café con TDD

Proyecto Java de consola basado en la guía de la práctica. Permite seleccionar un vaso pequeño (3 oz), mediano (5 oz) o grande (7 oz), indicar las cucharadas de azúcar y recoger el café. Muestra un mensaje si faltan vasos, café o azúcar. Si falta algún recurso, no descuenta ninguno.

## Ejecutar

Se necesita Java 11 o posterior. En Windows, abra PowerShell en esta carpeta y ejecute:

```powershell
java -jar maquina-cafe.jar
```

También se puede compilar desde el código fuente con un JDK 11 o posterior:

```powershell
New-Item -ItemType Directory -Force build/main | Out-Null
javac -encoding UTF-8 -d build/main (Get-ChildItem src/main/java/*.java).FullName
java -cp build/main Main
```

El programa comienza con 100 oz de café, 30 cucharadas de azúcar y 5 vasos de cada tamaño. Las existencias se mantienen durante la ejecución y se reinician al volver a iniciar el programa. La opción 2 permite consultarlas.

## Ejecutar las pruebas

Con JDK 11 o posterior y Maven instalado, desde esta carpeta:

```powershell
mvn test
```

Maven descargará JUnit 4.13.2 y los complementos necesarios si todavía no están en su caché. Las pruebas cubren los casos de la guía y casos adicionales: pedidos sin azúcar, validación de cantidades, consumo proporcional de café y conservación de existencias ante un pedido fallido.

## Diseño y TDD

Las clases `Vaso`, `Cafetera` y `Azucarero` verifican y descuentan sus existencias. `MaquinaDeCafe` coordina la selección y valida todos los recursos antes de entregarlos. `Main` proporciona el menú de consola. Las pruebas se escribieron antes de las clases; la primera compilación falló por clases inexistentes y, después de implementar y refactorizar, se ejecutaron con éxito.

La guía usa vasos de 10, 20 y 30 unidades en los datos de sus pruebas, mientras que los criterios de aceptación indican 3, 5 y 7 oz. Por eso los componentes permiten configurar el contenido, pero el menú usa 3, 5 y 7 oz. En el método `getVasoDeCafe`, la cantidad de azúcar es el total de cucharadas de la solicitud; el menú prepara un vaso por operación. Los textos de respuesta del método conservan los valores de los ejemplos de JUnit de la guía.

