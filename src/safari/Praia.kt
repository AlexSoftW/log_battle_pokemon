package safari

import pokemon.Pokemon
import trainer.Treinador
import kotlin.random.Random

class Praia(
    private val treinadorInicial: Treinador,
    private val name: String = "Praia",
    private val pokemonTypes: List<String> = listOf("Water", "Flying"),
    private var pokemonList: List<Pokemon> = emptyList()
) {

    fun adicionarPokemonNaFloresta() {
        val listPokemon = listOf(
            Pokemon(
                "Squirtle",
                10,
                10,
                15,
                110.0,
                hashMapOf("Bolha" to 12),
                hashMapOf("Chuva Borrifante" to 20),
                1
            ), Pokemon(
                "Psyduck",
                8,
                8,
                8,
                100.0,
                hashMapOf("Arranhão" to 10),
                hashMapOf("Onda de Confusão" to 15),
                1
            ),
            Pokemon(
                "Poliwag",
                6,
                6,
                10,
                70.0,
                hashMapOf("Irrigação" to 8),
                hashMapOf("Jato Dágua" to 20),
                1
            )
        )
        this.pokemonList = listPokemon
    }

    fun chanceDeCaptura(): Int {
        return Random.nextInt(1, 11)
    }

    fun tentativaDeCapturar() {
        if (chanceDeCaptura() > 3) {
            this.treinadorInicial.capturar(pokemonSelvagemApareceu())
        } else {
            println("Pokémon selvagem fugiu!")
        }
    }

    fun pokemonSelvagemApareceu(): Pokemon {
        val raridadePokemon = Random.nextInt(1, 11)

        return when (raridadePokemon) {
            in 1..5 -> this.pokemonList[1]
            in 5..8 -> this.pokemonList[2]
            else -> this.pokemonList[0]
        }
    }

}