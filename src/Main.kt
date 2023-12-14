import battle.Arena
import pokemon.Pokemon
import trainer.Treinador

fun main() {

    val liderGinasio = Treinador("Ash Ketchum")
    val treinador = Treinador("Alex")

    treinador.capturar(
        Pokemon(
            "Charmander",
            15,
            10,
            10,
            20.0,
            hashMapOf("Arranhao" to 10),
            hashMapOf("Rajada de Fogo" to 20),
            1
        )
    )
    liderGinasio.capturar(
        Pokemon(
            "Bulbassaur",
            10,
            15,
            10,
            20.0,
            hashMapOf("Chicote de Vinha" to 10),
            hashMapOf("Bomba de Veneno" to 20),
            1
        )
    )

    val arena = Arena(liderGinasio, treinador)

    arena.batalha()
}
