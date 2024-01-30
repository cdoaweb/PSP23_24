Crear clase cuenta bancaria, con los iguientes atributos:
    iban: String
    Saldo: double
    Get y Set sincronizados (ingresar saldo, sacar saldo)

clase tranferencia
    Méteno estático transferencia(cuenta1, cuenta2, cantidad). Ese Método debe sitcronizar cuenta1 para 
    sacar esa cantidad y después sincronizar cuenta2 para ingresar.
clase hilo implementa de runnable: 
    el constructor recibe las dos cuentas. Tiene atributo privado 
    : nombre, el run debe hacer mil transferencias de cuenta1 a la cuenta2 por una cantidad de 10 euros.
    Debes generar una situaci-n de intrerblequeo. jps(muest@a los precesos java en ejecución junto a su pid. ejecutamos jstack pid )



Como solucionario: dentro del hilo 