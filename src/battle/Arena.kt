package battle

import pokemon.Pokemon
import trainer.Treinador
import java.time.LocalDateTime
import kotlin.random.Random

class Arena(
    private val liderDoGinasio: Treinador,
    private val treinadorDesafiante: Treinador,
    private val name: String = "Ginásio de Johto"
) {
    fun batalha() {
        val pokemonLiderDoGinasio = liderDoGinasio.escolherPokemon()
        val pokemonTreinadorDesafiante = treinadorDesafiante.escolherPokemon()

        locutor(pokemonLiderDoGinasio, pokemonTreinadorDesafiante)

        while (pokemonLiderDoGinasio.hp > 0.0 && pokemonTreinadorDesafiante.hp > 0.0) {
            println(
                "---------------------------\n" +
                        "|${pokemonLiderDoGinasio.name} HP: ${pokemonLiderDoGinasio.hp}|\n" +
                        "|${pokemonTreinadorDesafiante.name} HP: ${pokemonTreinadorDesafiante.hp}|\n" +
                        "___________________________"
            )
            Thread.sleep(5000)

            if (escolherTreinadorParaAtacar() in 1..6) {
                //Pokemon do lider de ginasio ataca.
                if (chanceAtkEspecialPokemon() in 8..11) {
                    val ataqueEspecial =
                        pokemonLiderDoGinasio.ataqueEspecial(pokemonLiderDoGinasio.specialAtk.keys.first())
                    println(
                        "${pokemonLiderDoGinasio.name} usou ${pokemonLiderDoGinasio.specialAtk.keys.first()} | " +
                                "Dano = $ataqueEspecial"
                    )
                    Thread.sleep(3000)

                    //Pokemon do treinador desafiante defende.
                    val defender = pokemonTreinadorDesafiante.defender()
                    println("${pokemonTreinadorDesafiante.name} defendeu | Defesa = $defender")
                    Thread.sleep(3000)

                    //Vida do pokemon do treinador desafiante
                    pokemonTreinadorDesafiante.sofrerDano(ataqueEspecial - defender)
                    println("${pokemonTreinadorDesafiante.name} perdeu ${ataqueEspecial - defender} HP")
                    Thread.sleep(3000)

                } else {
                    val ataqueBasico = pokemonLiderDoGinasio.atacar(pokemonLiderDoGinasio.basicAtk.keys.first())
                    println(
                        "${pokemonLiderDoGinasio.name} usou ${pokemonLiderDoGinasio.basicAtk.keys.first()} | " +
                                "Dano = $ataqueBasico"
                    )
                    Thread.sleep(3000)

                    //Pokemon do treianador desafiante defende.
                    val defender = pokemonTreinadorDesafiante.defender()
                    println("${pokemonTreinadorDesafiante.name} defendeu | Defesa = $defender")
                    Thread.sleep(3000)

                    //Vida do pokemon do treinador desafiante.
                    pokemonTreinadorDesafiante.sofrerDano(ataqueBasico - defender)
                    println("${pokemonTreinadorDesafiante.name} perdeu ${ataqueBasico - defender} HP")
                    Thread.sleep(3000)
                }

            } else {
                //Pokemon do treinador desafiante ataca.
                if (chanceAtkEspecialPokemon() in 8..11) {
                    val ataqueEspecial =
                        pokemonTreinadorDesafiante.ataqueEspecial(pokemonTreinadorDesafiante.specialAtk.keys.first())
                    println(
                        "${pokemonTreinadorDesafiante.name} usou ${pokemonTreinadorDesafiante.specialAtk.keys.first()} | " +
                                "Dano = ${pokemonTreinadorDesafiante.ataqueEspecial(pokemonTreinadorDesafiante.specialAtk.keys.first())}"
                    )
                    Thread.sleep(3000)

                    //Pokemon do lider de ginasio defende.
                    val defender = pokemonLiderDoGinasio.defender()
                    println("${pokemonLiderDoGinasio.name} defendeu | Defesa = $defender")
                    Thread.sleep(3000)

                    //Vida do pokemon do lider de ginasio.
                    pokemonLiderDoGinasio.sofrerDano(ataqueEspecial - defender)
                    println("${pokemonLiderDoGinasio.name} perdeu ${ataqueEspecial - defender} HP")
                    Thread.sleep(3000)
                } else {
                    val ataqueBasico =
                        pokemonTreinadorDesafiante.atacar(pokemonTreinadorDesafiante.basicAtk.keys.first())
                    println(
                        "${pokemonTreinadorDesafiante.name} usou ${pokemonTreinadorDesafiante.basicAtk.keys.first()} | " +
                                "Dano = $ataqueBasico"
                    )
                    Thread.sleep(3000)

                    //Pokemon do lider de ginasio defende.
                    val defender = pokemonLiderDoGinasio.defender()
                    println("${pokemonLiderDoGinasio.name} defendeu | Defesa = $defender")
                    Thread.sleep(3000)

                    //Vida do pokemon do lider de ginasio.
                    pokemonLiderDoGinasio.sofrerDano(ataqueBasico - defender)
                    println("${pokemonLiderDoGinasio.name} perdeu ${ataqueBasico - defender} HP")
                    Thread.sleep(3000)
                }
            }


        }

        if (pokemonTreinadorDesafiante.hp == 0.0) {
            println("treinador desafiante perdeu")
        } else if (pokemonLiderDoGinasio.hp == 0.0) {
            println("lider de ginasio perdeu")
        }

    }

    fun escolherTreinadorParaAtacar(): Int {
        return Random.nextInt(1, 11)
    }

    fun chanceAtkEspecialPokemon(): Int {
        return Random.nextInt(1, 11)
    }

    fun locutor(pokemonDesafiante: Pokemon, pokemonLider: Pokemon) {

        println(
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠟⠋⠉⠉⠉⠉⠛⢿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⠇⢀⣾⡄⠀⠀⠀⠀⠀⠀⣷⡄⠈⢿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡟⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⣿⣿⠀⢸⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⡇⠀⠈⠛⠁⠀⠀⠀⠀⠀⠀⠉⠁⠀⢸⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⡇⠰⣿⣿⠆⠀⠀⠀⠀⠀⠰⠿⠿⠗⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⡇⠀⠠⠤⠀⠀⠀⠀⠀⠀⠀⠒⠒⠀⢸⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡇⠀⢰⣿⡆⠀⠀⠀⠀⠀⠀⢸⣿⡆⢸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⢸⡿⠀⢸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⡆⠀⢹⠁⠀⠀⠀⠀⠀⠀⠸⠁⠀⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠺⠿⠿⠿⠿⠟⠀⢀⣿⣿⣿⣿⣿⣿⡆⠀''Seja muito bem-vindo ao torneio Pokémon''\n" +
                    "⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠤⠤⠄⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣤⣤⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀\n"
        )

        Thread.sleep(5000)

        println(
            "Nesse grande dia ensolarado que está fazendo hoje no ${this.name}, " +
                    "do dia ${dataHoraAtual()}, temos a ilustre estrela do nosso torneio\n" +
                    "o brilhante e destemido lider de ginasio: ${liderDoGinasio.name}\n" +
                    "*aplausos e gritos...*"
        )
        println(
            "⠀⠀⠀⠀⠀⠀⠀⢀⠀⠔⡀⠀⢀⠞⢰⠂⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢸⠘⢰⡃⠔⠩⠤⠦⠤⢀⡀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢀⠄⢒⠒⠺⠆⠈⠀⠀⢐⣂⠤⠄⡀⠯⠕⣒⣒⡀⠀\n" +
                    "⠀⠀⢐⡡⠔⠁⠆⠀⠀⠀⠀⠀⢀⠠⠙⢆⠀⠈⢁⠋⠥⣀⣀\n" +
                    "⠈⠉⠀⣰⠀⠀⠀⠀⡀⠀⢰⣆⢠⠠⢡⡀⢂⣗⣖⢝⡎⠉⠀\n" +
                    "⢠⡴⠛⡇⠀⠐⠀⡄⣡⢇⠸⢸⢸⡇⠂⡝⠌⢷⢫⢮⡜⡀⠀\n" +
                    "⠀⠀⢰⣜⠘⡀⢡⠰⠳⣎⢂⣟⡎⠘⣬⡕⣈⣼⠢⠹⡟⠇⠀\n" +
                    "⠀⠠⢋⢿⢳⢼⣄⣆⣦⣱⣿⣿⣿⣷⠬⣿⣿⣿⣿⠑⠵⠀⠀\n" +
                    "⠀⠀⠀⡜⢩⣯⢝⡀⠁⠀⠙⠛⠛⠃⠀⠈⠛⠛⡿⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⣿⠢⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢀⣀⡇⠀⠑⠀⠀⠀⠀⠐⢄⠄⢀⡼⠃⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢸⣿⣷⣤⣀⠈⠲⡤⣀⣀⠀⡰⠋⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣶⣤⣙⣷⣅⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⢀⣾⣿⣿⣿⣿⣻⢿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⡠⠟⠁⠙⠟⠛⠛⢿⣿⣾⣿⣿⣿⣿⣧⡀⠀\n"
        )
        Thread.sleep(15000)
        println(
            "Do outro lado temos o corajoso desafiante que irá infrentar nosso lider de ginasio para conquistar sua insignea.\n" +
                    "Aplausos para o desafiante: ${treinadorDesafiante.name}\n" +
                    "*muitos aplausos...*"
        )
        println(
            "⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⡠⠒⢁⠤⠒⠊⠉⠉⠉⡉⠉⠁⠒⠤⢀⠑⠢⡀⠀⠀\n" +
                    "⠀⡔⢀⠴⠁⠀⡰⡇⠀⠀⢠⠻⡀⠀⠀⠀⠀⠑⢆⠈⢄⠀\n" +
                    "⡘⢀⠞⠀⠀⡜⠁⢳⠀⠀⡎⠀⠘⢆⠀⡀⠀⠀⠀⢣⠈⡄\n" +
                    "⠀⡜⢁⠀⣼⡤⢄⠈⢧⢀⡇⢀⡔⠲⣷⣷⡀⠀⠀⠘⡄⠀\n" +
                    "⠀⡇⢈⡜⡎⠀⠈⡇⠀⠑⣧⡸⠀⠀⠸⡈⢳⡀⠀⠀⡇⠀\n" +
                    "⠀⡷⢞⠀⡏⠀⠀⡇⠀⠀⠀⢁⠀⠀⢀⡇⠀⡇⣮⣝⡄⠀\n" +
                    "⠢⠄⠈⡇⠑⠄⠠⠏⠀⠀⠀⠘⠄⠠⠞⠀⠀⠏⡏⢧⡇⠀\n" +
                    "⠀⡀⢀⠃⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⣄⣀⠜⢁⠌\n" +
                    "⠀⠀⢾⡀⠀⠀⠈⡀⠀⠀⠀⠀⠀⠀⡇⢀⣴⠁⢸⠀⢇⠀\n" +
                    "⠀⠑⢤⠈⡹⠒⢲⡁⠀⠀⠀⠀⠀⠀⡿⡅⠀⣒⢕⣣⣈⠰\n" +
                    "⠀⠐⢁⡴⠧⠶⡎⠧⠤⠤⠤⠤⠤⠄⠃⠘⡖⠸⠦⠀⠀⠀\n" +
                    "⠀⠐⠀⠀⠀⢰⠁⡄⠀⠀⠀⠀⠀⠀⡄⠀⠹⡄⢠⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠁⣌⠀⢣⢤⠤⠤⠤⠤⡄⣼⠀⠀⢳⠈⡄⠀⠀\n" +
                    "⠀⠀⠀⡈⢀⠏⠀⢸⢸⢀⣀⠄⡏⢹⠹⡀⠀⠈⡇⠸⠀⠀\n" +
                    "⠀⠀⠀⠁⡸⠀⠀⢸⡼⣀⣀⣀⣣⣻⣰⡇⠀⠀⠸⡀⠃⠀\n" +
                    "⠀⠀⠠⡐⠓⡦⣤⡾⠀⠀⠀⠀⠀⠀⠀⠱⢤⡶⠒⡅⢀⠀\n" +
                    "⠀⠀⠀⡌⢠⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⠀⢣⠈⠄\n" +
                    "⠀⠀⠀⠀⡜⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⢸⡄⠀\n" +
                    "⠀⠀⠀⠀⠁\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
        )
        Thread.sleep(15000)
        println("Os pokemon utilizados para esse combate são...")
        Thread.sleep(3000)
        println("${pokemonLider.name} do treinador: ${this.liderDoGinasio.name}")
        Thread.sleep(3000)
        println("${pokemonDesafiante.name} do treinador: ${this.treinadorDesafiante.name}")
        Thread.sleep(5000)
        println("Treinadores apostos...")
        Thread.sleep(3000)
        println("em 5...")
        Thread.sleep(1000)
        println("4...")
        Thread.sleep(1000)
        println("3...")
        Thread.sleep(1000)
        println("2...")
        Thread.sleep(1000)
        println("1...")
        Thread.sleep(1000)
        println("INICIE O COMBATE!")
        Thread.sleep(3000)
    }

    private fun dataHoraAtual(): String {
        val dateNow = LocalDateTime.now()

        val dia = dateNow.dayOfMonth
        val mes = dateNow.monthValue
        val ano = dateNow.year
        val hora = dateNow.hour
        val minuto = dateNow.minute

        return "$dia/$mes/$ano às $hora:$minuto"
    }

}