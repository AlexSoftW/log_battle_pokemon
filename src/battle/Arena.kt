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
            placar(pokemonLiderDoGinasio, pokemonTreinadorDesafiante)
            Thread.sleep(5000)

            if (escolherTreinadorParaAtacar() in 1..6) {
                //Pokémon do lider de ginásio ataca.
                val atacar = pokemonLiderDoGinasio.atacar()
                println(
                    "${pokemonLiderDoGinasio.name} usou " +
                            "${pokemonLiderDoGinasio.nameTagAtaquePokemon()} | " +
                            "Dano = $atacar"
                )
                Thread.sleep(3000)

                //Pokémon do treinador desafiante defende.
                val defender = pokemonTreinadorDesafiante.defender()
                println("${pokemonTreinadorDesafiante.name} defendeu | Defesa = $defender")
                Thread.sleep(3000)

                //Vida atual do Pokémon do treinador desafiante.
                pokemonTreinadorDesafiante.sofrerDano(atacar - defender)
                println("${pokemonTreinadorDesafiante.name} perdeu ${atacar - defender} HP")
                Thread.sleep(3000)
            } else {
                //Pokémon do treinador desafiante ataca.
                val atacar = pokemonTreinadorDesafiante.atacar()
                println(
                    "${pokemonTreinadorDesafiante.name} usou " +
                            "${pokemonTreinadorDesafiante.nameTagAtaquePokemon()} | " +
                            "Dano = $atacar"
                )
                Thread.sleep(3000)

                //Pokémon do lider de ginásio defende.
                val defender = pokemonLiderDoGinasio.defender()
                println("${pokemonLiderDoGinasio.name} defendeu | Defesa = $defender")
                Thread.sleep(3000)

                //Vida atual do Pokémon do lider de ginásio.
                pokemonLiderDoGinasio.sofrerDano(atacar - defender)
                println("${pokemonLiderDoGinasio.name} perdeu ${atacar - defender} HP")
                Thread.sleep(3000)
            }
        }

        finalDaPartida(pokemonLiderDoGinasio, pokemonTreinadorDesafiante)
    }

    private fun finalDaPartida(pokemonLiderDoGinasio: Pokemon, pokemonTreinadorDesafiante: Pokemon) {
        println(
            "\n_________________" +
                    "Partida encerrada!" +
                    "___________________\n"
        )
        Thread.sleep(3000)

        if (pokemonTreinadorDesafiante.hp <= 0.0) {
            liderDoGinasio.derrota()
            treinadorDesafiante.vitoria()
            println("O treinador ${liderDoGinasio.name} perdeu a partida!")
            println("O treinador ${treinadorDesafiante.name} ganhou a partida!")
        } else {
            liderDoGinasio.vitoria()
            treinadorDesafiante.derrota()
            println("O treinador ${liderDoGinasio.name} ganhou a partida!")
            println("O treinador ${treinadorDesafiante.name} perdeu a partida!")
        }
        println(
            "\n⠸⣷⣦⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⠀⠀⠀\n" +
                    "⠀⠙⣿⡄⠈⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠔⠊⠉⣿⡿⠁⠀⠀⠀\n" +
                    "⠀⠀⠈⠣⡀⠀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠁⠀⠀⣰⠟⠀⠀⠀⣀⣀\n" +
                    "⠀⠀⠀⠀⠈⠢⣄⠀⡈⠒⠊⠉⠁⠀⠈⠉⠑⠚⠀⠀⣀⠔⢊⣠⠤⠒⠊⠉⠀⡜\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⡽⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠩⡔⠊⠁⠀⠀⠀⠀⠀⠀⠇\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⡇⢠⡤⢄⠀⠀⠀⠀⠀⡠⢤⣄⠀⡇⠀⠀⠀⠀⠀⠀⠀⢰⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢀⠇⠹⠿⠟⠀⠀⠤⠀⠀⠻⠿⠟⠀⣇⠀⠀⡀⠠⠄⠒⠊⠁⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢸⣿⣿⡆⠀⠰⠤⠖⠦⠴⠀⢀⣶⣿⣿⠀⠙⢄⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢻⣿⠃⠀⠀⠀⠀⠀⠀⠀⠈⠿⡿⠛⢄⠀⠀⠱⣄⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢸⠈⠓⠦⠀⣀⣀⣀⠀⡠⠴⠊⠹⡞⣁⠤⠒⠉⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⣠⠃⠀⠀⠀⠀⡌⠉⠉⡤⠀⠀⠀⠀⢻⠿⠆⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠰⠁⡀⠀⠀⠀⠀⢸⠀⢰⠃⠀⠀⠀⢠⠀⢣⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢶⣗⠧⡀⢳⠀⠀⠀⠀⢸⣀⣸⠀⠀⠀⢀⡜⠀⣸⢤⣶⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠈⠻⣿⣦⣈⣧⡀⠀⠀⢸⣿⣿⠀⠀⢀⣼⡀⣨⣿⡿⠁⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⠻⠿⠿⠓⠄⠤⠘⠉⠙⠤⢀⠾⠿⣿⠟⠋"
        )
    }

    private fun placar(pokemonLiderDoGinasio: Pokemon, pokemonTreinadorDesafiante: Pokemon) {
        println(
            "\n---Vida atual---------------\n" +
                    "|${pokemonLiderDoGinasio.name} HP: " +
                    "${pokemonLiderDoGinasio.hp}|\n" +
                    "|${pokemonTreinadorDesafiante.name} HP: " +
                    "${pokemonTreinadorDesafiante.hp}|\n" +
                    "___________________________"
        )
    }

    private fun locutor(pokemonTreinadorDesafiante: Pokemon, pokemonLiderDoGinasio: Pokemon) {
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
                    "o brilhante e destemido lider de ginasio ${liderDoGinasio.name}\n" +
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
            "Do outro lado temos o corajoso desafiante que irá infrentar nosso lider de ginásio " +
                    "para conquistar sua insígnia.\n" +
                    "Aplausos para o desafiante ${treinadorDesafiante.name}\n" +
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
        println("Os Pokémon utilizados para esse combate são...")
        Thread.sleep(3000)
        println("${pokemonLiderDoGinasio.name} do treinador: ${this.liderDoGinasio.name}")
        Thread.sleep(3000)
        println("${pokemonTreinadorDesafiante.name} do treinador: ${this.treinadorDesafiante.name}")
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

    private fun escolherTreinadorParaAtacar(): Int {
        return Random.nextInt(1, 11)
    }

}