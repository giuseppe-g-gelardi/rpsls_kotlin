open class Human(
    var name: String,
    var score: Int = 0,
    val moves: Array<String> = arrayOf("rock", "paper", "scissors", "lizard", "spock"),
    var choice: String = ""
) : Player(name, score, moves, choice) {
    fun gestures() {
        println("Please choose: rock, paper, scissors, lizard, spock")
        this.choice = readLine().toString()

        if (this.choice !in this.moves) {
            println("invalid choice, please try again")
        } else {
            println(this.choice)
        }

    }
}

