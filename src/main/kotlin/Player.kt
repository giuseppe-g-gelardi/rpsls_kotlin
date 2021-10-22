open class Player(
    private var name: String,
    private var score: Int = 0,
    private val moves: Array<String> = arrayOf("rock", "paper", "scissors", "lizard", "spock"),
    private var choice: String = ""
) {}

