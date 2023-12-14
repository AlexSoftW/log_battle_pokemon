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

    private var atkBasicOrSpecial: Boolean = false

    fun atacar(): Double {
        val chanceDeUsarAtkEspecial = Random.nextInt(1, 11)

        return if (chanceDeUsarAtkEspecial in 1..8) {
            ataqueBasico()
        } else {
            ataqueEspecial()
        }
    }

    fun defender(): Int {
        return ((Random.nextInt(1, 11)) * this.def) / 10
    }

    fun sofrerDano(dano: Double) {
        this.hp -= dano
    }

    fun ataqueBasico(): Double {
        val poder = this.power * 0.10
        val velocidade: Int = when (this.stage) {
            1 -> vel / 10
            2 -> vel / 8
            3 -> vel / 6
            else -> 0
        }
        atkBasicOrSpecial = false

        return (basicAtk[this.basicAtk.keys.first()]!! + poder + velocidade)
    }

    fun ataqueEspecial(): Double {
        val poder = this.power * 0.20
        val velocidade: Int = when (this.stage) {
            1 -> vel / 6
            2 -> vel / 4
            3 -> vel / 2
            else -> 0
        }
        atkBasicOrSpecial = true

        return (specialAtk[this.specialAtk.keys.first()]!! + poder + velocidade)
    }

    fun nameTagAtaquePokemon(): String {
        return if (!atkBasicOrSpecial) this.basicAtk.keys.first() else this.specialAtk.keys.first()
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

}