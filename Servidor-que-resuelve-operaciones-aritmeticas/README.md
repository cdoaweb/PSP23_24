## Servidor que resuelva operaciones aritméticas

Implementar un Cliente/Servidor, en la que el cliente mande operaciones del tipo operando1 operacion operando2. El servidor deberá mandar la solución al cliente. El cliente podrá pedir tantas operaciones como requiera, hasta que sea fin de línea.
El ejemplo será del tipo Cliente -> 10+5 y el Servidor responde con ->(fecha y hora de la respuesta) res:20. Tener en cuenta, que si el cliente manda una operacion del tipo 10:0, el servidor deberá mandar una respuesta del tipo -> (fecha y hora de la respuesta) res:err.
Como consejo, utilizar los Parseos, ya que el cliente podrá mandar tanto enteros, como reales con o sin espacios en blanco. El servidor, deberá mandar en todo momento la fecha y hora de la respuesta, junto al resultado

Mandar capturas de pantalla tanto del cliente como del servidor.