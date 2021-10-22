open class Game(
    private var name: String,
) : Player(name) {
    var promptPlayerOneName = println("Hello player1, What is your name?: ")
    var playerOneName = promptPlayerOneName.toString()
    var player1 = Human(playerOneName)
    var player2 = AI("Computer")
    var player2human = Human(name)

    open fun runGame() {
        this.gameMessage()
        this.multiplayer()
        this.outcome()
        this.restart()
    }

    open fun gameMessage() {

        println("${this.player1.name} has entered the fray")
        println("Welcome to rock, paper, scissors, lizard, spock!")
        println("Best of 3 wins!")
        println("THE RULES: \n" +
                "\nScissors cut Paper" +
                "\nPaper covers Rock" +
                "\nRock crushes Lizard" +
                "\nLizard poisons Spock" +
                "\nSpock smashes Scissors" +
                "\nScissors decapitates Lizard")
        this.multiplayer()
    }

    open fun multiplayer() {
        print("Would you like to play multiplayer? yes or no: ")
        var multiplayerPrompt = readLine().toString()

        if (multiplayerPrompt == "yes") {
            println("Hello player2, what is your name?")
            var playerTwoName = readLine().toString()
            this.player2human.name = playerTwoName
            gestureCompareMultiplayer()
        } else if (multiplayerPrompt == "no") {
            gestureCompare()
            // TODO properly reassign player2
        } else {
            print("Invalid input, please type 'yes' or 'no'")
            this.multiplayer()
        }
    }

    open fun gestureCompare() {
        while (this.player1.score < 3 && this.player2.score < 3) {
            this.player1.gestures()
            this.player2.gestures()
            this.gestureDecision()
        }
    }

    open fun gestureCompareMultiplayer() {
        while (this.player1.score < 3 && this.player2human.score < 3) {
            this.player1.gestures()
            this.player2human.gestures()
            this.gestureDecisionMultiplayer()
        }
    }

    open fun gestureDecision() {
        if (this.player1.choice == this.player2.choice) {
            println("Tie! Play again!")
        } else if (
            (this.player1.choice == "rock" && this.player2.choice == "scissors" || this.player2.choice == "lizard") ||
            (this.player1.choice == "scissors" && this.player2.choice == "paper" || this.player2.choice == "lizard") ||
            (this.player1.choice == "paper" && this.player2.choice == "rock" || this.player2.choice == "spock") ||
            (this.player1.choice == "lizard" && this.player2.choice == "spock" || this.player2.choice == "rock") ||
            (this.player1.choice == "spock" && this.player2.choice == "scissors" || this.player2.choice == "rock")
        ) {
            this.player1.score += 1
            println("${this.player1.choice} beats ${this.player2.choice}! Player1 wins!")
            println("The score is Player1: ${this.player1.score}, Player2: ${this.player2.score}")
            this.gestureCompare()
        } else {
            this.player2.score += 1
            println("${this.player2.choice} beats ${this.player1.choice}! Player1 wins!")
            println("The score is Player1: ${this.player1.score}, Player2: ${this.player2.score}")
        }
    }

    open fun gestureDecisionMultiplayer() {
        if (this.player1.choice == this.player2human.choice) {
            println("Tie! Play again!")
        } else if (
            (this.player1.choice == "rock" && this.player2human.choice == "scissors" || this.player2human.choice == "lizard") ||
            (this.player1.choice == "scissors" && this.player2human.choice == "paper" || this.player2human.choice == "lizard") ||
            (this.player1.choice == "paper" && this.player2human.choice == "rock" || this.player2human.choice == "spock") ||
            (this.player1.choice == "lizard" && this.player2human.choice == "spock" || this.player2human.choice == "rock") ||
            (this.player1.choice == "spock" && this.player2human.choice == "scissors" || this.player2human.choice == "rock")
        ) {
            this.player1.score += 1
            println("${this.player1.choice} beats ${this.player2human.choice}! Player1 wins!")
            println("The score is Player1: ${this.player1.score}, Player2: ${this.player2human.score}")
            this.gestureCompare()
        } else {
            this.player2human.score += 1
            println("${this.player2human.choice} beats ${this.player1.choice}! Player1 wins!")
            println("The score is Player1: ${this.player1.score}, Player2: ${this.player2human.score}")
        }
    }

    open fun outcome() {
        if (this.player1.score == 3 || this.player2.score == 3) {
            if (this.player1.score > this.player2.score) {
                println("Player1 wins!")
            } else {
                println("Player2 wins!")
            }
        }
    }

    open fun restart() {
        println("Would you like to play again? yes or no: ")
        var playAgain = readLine().toString()

        if (playAgain == "yes") {
            this.player1.score = 0
            this.player2.score = 0
            this.runGame()
        } else if (playAgain == "no") {
            println("thanks for playing")
        } else {
            println("invalid input, please type 'yes' or 'no'")
            this.restart()
        }
    }

}



