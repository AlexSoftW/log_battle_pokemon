package safari

import pokemon.Pokemon
import trainer.Treinador
import kotlin.random.Random

class Montanha(
    private val treinadorInicial: Treinador,
    private val name: String = "Montanha",
    private val pokemonTypes: List<String> = listOf("Fire", "Ground", "Rock"),
    private var pokemonList: List<Pokemon> = emptyList()
) {

    fun adicionarPokemonNaFloresta() {
        this.pokemonList = adicionarPokemon()
    }

    fun adicionarPokemon(): List<Pokemon> {
        val listPokemon = listOf(
            Pokemon(
                "Charmander",
                15,
                10,
                10,
                110.0,
                hashMapOf("Arranhão" to 10),
                hashMapOf("Rajada de Fogo" to 20),
                1
            ), Pokemon(
                "Sandshrew",
                8,
                12,
                6,
                90.0,
                hashMapOf("Desaterrar" to 8),
                hashMapOf("Colisão Rolante" to 16),
                1
            ),
            Pokemon(
                "Machop",
                10,
                10,
                10,
                100.0,
                hashMapOf("Soco" to 10),
                hashMapOf("Pancada Dupla" to 20),
                1
            )
        )

        return listPokemon
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