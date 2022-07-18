package nix.summer.practice.coffeemachine
import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        print("Write action (buy, fill, take, remaining, exit):\n> ")
        if (!CoffeeMachine.actionsHandler(scanner.nextLine(), scanner))
            break
    }
}

enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val money: Int) {
    ESPRESSO(250, 0, 16,  4),
    LATTE(350, 75, 20,  7),
    CAPPUCCINO(200, 100, 12,  6)
}

object CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var disposableCups = 9
    private var money = 550

    fun actionsHandler(action: String, scanner: Scanner): Boolean {
        when (action) {
            "buy" -> buyAction(scanner)
            "remaining" -> remaining()
            "fill" -> fillAction(scanner)
            "take" -> take()
            "exit" -> return false
        }
        return true
    }

    private fun buyAction(scanner: Scanner) {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ")

        when (scanner.nextLine()) {
            "1" -> makeACoffee(Coffee.ESPRESSO)
            "2" -> makeACoffee(Coffee.LATTE)
            "3" -> makeACoffee(Coffee.CAPPUCCINO)
            "back" -> return
        }
    }

    private fun makeACoffee(coffee: Coffee) {
        val checkingResult = checkingIngredients(coffee.water, coffee.milk, coffee.coffeeBeans)
        if (checkingResult == "no problems") {
            println("I have enough resources, making you a coffee!")
            this.money += coffee.money
        }
        else {
            println(checkingResult)
        }
    }

    private fun fillAction(scanner: Scanner) {
        print("\nWrite how many ml of water do you want to add:\n> ")
        val water = scanner.nextInt()
        print("Write how many ml of milk do you want to add:\n> ")
        val milk = scanner.nextInt()
        print("Write how many ml of coffee beans do you want to add:\n> ")
        val coffeeBeans = scanner.nextInt()
        print("Write how many ml of disposable cups do you want to add:\n> ")
        val disposableCups = scanner.nextInt()
        println()

        fill(water, milk, coffeeBeans, disposableCups)
    }

    private fun checkingIngredients(water: Int, milk: Int, coffeeBeans: Int): String {
        if (this.water - water < 0) {
            return "Sorry, not enough water!"
        }
        if (this.milk - milk < 0) {
            return "Sorry, not enough milk!"
        }
        if (this.coffeeBeans - coffeeBeans < 0) {
            return "Sorry, not enough coffee beans!"
        }
        if (this.disposableCups - 1 < 0) {
            return "Sorry, not enough disposable cups!"
        }
        else {
            this.water -= water
            this.milk -= milk
            this.coffeeBeans -= coffeeBeans
            this.disposableCups -= 1

            return "no problems"
        }
    }

    private fun remaining() {
        println("\nThe coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$disposableCups of disposable cups")
        println("$money of money\n")
    }

    private fun fill(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int) {
        this.water += water
        this.milk += milk
        this.coffeeBeans += coffeeBeans
        this.disposableCups += disposableCups
    }

    private fun take() {
        println("\nI gave you $money")
        money = 0
    }
}