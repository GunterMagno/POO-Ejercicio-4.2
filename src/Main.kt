import kotlin.math.pow

class Persona(var peso: Double, var altura: Double) {

    var nombre: String = ""

    val imc: Double = peso / (altura.pow(2.0))

    constructor(peso: Double, altura: Double, nombre: String) : this(peso, altura) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Nombre: $nombre\n -> Peso: $peso kg\n -> Altura: $altura m\n -> IMC: %.2f".format(imc)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return peso == other.peso && altura == other.altura && nombre == other.nombre
    }

    override fun hashCode(): Int {
        var result = peso.hashCode()
        result = 31 * result + altura.hashCode()
        result = 31 * result + nombre.hashCode()
        return result
    }
}

fun pedirNombre(): String {
    print("Dime tu nombre: ")
    val nombre = readln().trim()

    return if (nombre.isNotBlank()) {
        nombre
    } else {
        println("ERROR, intentelo de nuevo.")
        pedirNombre()
    }
}

fun main() {

    val persona1 = Persona(60.0, 1.75)
    persona1.nombre = pedirNombre()

    val persona2 = Persona(75.0, 1.80, "Jose Mari")
    val persona3 = Persona(90.0, 1.85, "Mafita")

    println("\nDatos de las personas creadas:")
    println(persona1)
    println(persona2)
    println(persona3)

    persona3.altura = 1.80
    println("\nPersona 3 después del cambio de altura - Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${"%.2f".format(persona3.imc)}")

    persona2.altura = persona3.altura

    println("\nPersona 2 después del cambio de altura:")
    println(persona2)
    println("\nPersona 3:")
    println(persona3)

    println("\n¿Persona 2 y Persona 3 son iguales? ${persona2 == persona3}")
}
