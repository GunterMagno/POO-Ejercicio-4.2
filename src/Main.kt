import kotlin.math.pow // Para poder poner algo al cuadrado y exponentes en general

class Persona(var peso :Double, var altura :Double){

    var nombre: String = ""

    constructor(peso: Double,altura: Double,nombre :String) : this(peso, altura){
        this.nombre = nombre
    }

    val imc: Double = peso / (altura.pow(2.0))

    override fun toString(): String {
        return ("Nombre: $nombre:\n -> Peso: $peso\n -> Altura: $altura\n -> IMC: $imc")
    }

}

fun pedirNombre() :String{
    try {
        println("Dime tu nombre: ")
        val nombre = readln().toString()
        if (nombre.isBlank() or nombre.isEmpty()) {
            throw Exception
        }
        return nombre
    }catch (e :Exception){
        println("ERROR, intentelo de nuevo.")
        return pedirNombre()
    }
}

fun main(){

    val persona1 = Persona(60.0,1.75)
    persona1.nombre = pedirNombre()

}