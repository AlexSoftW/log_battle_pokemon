package pokemon

import kotlin.random.Random

class Pokemon(
    var name: String,
    var power: Int,
    var def: Int,
    var vel: Int,
    var hp: Double,
    var basicAtk: HashMap<String, Int>,
    var specialAtk: HashMap<String, Int>,
    var stage: Int
) {

    fun atacar(ataqueBasico: String): Double {
        val velocidade: Int = when (this.stage) {
            1 -> vel / 10
            2 -> vel / 8
            3 -> vel / 6
            else -> 0
        }
        val poder = this.power * 0.10

        return (basicAtk[ataqueBasico]!! + poder + velocidade)
    }

    fun ataqueEspecial(ataqueEspecial: String): Double {
        val velocidade: Int = when (this.stage) {
            1 -> vel / 6
            2 -> vel / 4
            3 -> vel / 2
            else -> 0
        }
        val poder = this.power * 0.20

        return (specialAtk[ataqueEspecial]!! + poder + velocidade)
    }

    fun defender(): Int {
        return (porcetagemSucessoDef() * this.def) / 10
    }

    fun sofrerDano(dano: Double) {
        this.hp -= dano
    }

    fun evoluir(
        nome: String,
        poder: Int,
        defesa: Int,
        velocidade: Int,
        hp: Double,
        ataqueBasico: HashMap<String, Int>,
        ataqueEspecial: HashMap<String, Int>,
    ) {
        if (this.stage >= 3) {
            println("Seu pokémon não pode mais evoluir!")
        } else {
            this.name = nome
            this.power = poder
            this.def = defesa
            this.vel = velocidade
            this.hp = hp
            this.basicAtk = ataqueBasico
            this.specialAtk = ataqueEspecial
            this.stage++
        }
    }

    fun porcetagemSucessoDef(): Int {
        return Random.nextInt(1, 11)
    }

}