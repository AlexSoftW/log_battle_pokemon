package trainer

import pokemon.Pokemon
import kotlin.random.Random

class Treinador(
    val name: String,
    private var qtdWin: Int = 0,
    private var qtdLose: Int = 0,
    private var equipe: MutableList<Pokemon> = mutableListOf()
) {

    fun escolherPokemon(): Pokemon {
        val qtdDePokemonNaEquipe = this.equipe.size
        if (qtdDePokemonNaEquipe == 1) {
            return this.equipe[0]
        } else {
            val escolherPokemonAleatorio = Random.nextInt(0, qtdDePokemonNaEquipe)
            return return this.equipe[escolherPokemonAleatorio]
        }
    }

    fun capturar(pokemon: Pokemon) {
        this.equipe.add(pokemon)
    }

    fun vitoria(){
        this.qtdWin++
    }

    fun derrota() {
        this.qtdLose++
    }

}