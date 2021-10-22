open class AI(
    var name: String,
    var score: Int = 0,
    val moves: Array<String> = arrayOf<String>("rock", "paper", "scissors", "lizard", "spock"),
    var choice: String = ""
) : Player(name, score, moves, choice){

    fun gestures() {
        val rand: Int = (0..4).random()
        this.choice = this.moves[rand]
        println("player picked $choice")
    }
}


