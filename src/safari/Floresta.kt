package safari

import pokemon.Pokemon
import trainer.Treinador
import kotlin.random.Random

class Floresta(
    private val treinadorInicial: Treinador,
    private val name: String = "Floresta",
    private val pokemonTypes: List<String> = listOf("Grass", "Flying", "Bug"),
    private var pokemonList: List<Pokemon> = emptyList()
) {

    fun adicionarPokemonNaFloresta() {
        val listPokemon = listOf(
            Pokemon(
                "Bulbassaur",
                10,
                15,
                10,
                110.0,
                hashMapOf("Chicote de Vinha" to 10),
                hashMapOf("Bomba de Veneno" to 20),
                1
            ), Pokemon(
                "Caterpie",
                5,
                5,
                5,
                50.0,
                hashMapOf("Investida" to 5),
                hashMapOf("Picada" to 8),
                1
            ),
            Pokemon(
                "Gloom",
                8,
                8,
                8,
                80.0,
                hashMapOf("Pó do Sono" to 0),
                hashMapOf("Absorção" to 20),
                2
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