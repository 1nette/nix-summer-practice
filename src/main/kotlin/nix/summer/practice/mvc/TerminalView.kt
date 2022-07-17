package nix.summer.practice.mvc
import java.util.Scanner

class TerminalView(override val controller: Controller) : View {
    private val scanner = Scanner(System.`in`)

    override fun start() {
        while (true) {
            print("\nWrite action (buy, fill, take, remaining, exit):\n> ")
            controller.commandHandler(scanner.nextLine())
        }
    }

    override fun fill() {
        val resourcesToAdd = Resources()

        print("\nWrite how many ml of water do you want to add:\n> ")
        resourcesToAdd.water = scanner.nextInt()
        print("Write how many ml of milk do you want to add:\n> ")
        resourcesToAdd.milk = scanner.nextInt()
        print("Write how many coffee beans do you want to add:\n> ")
        resourcesToAdd.coffeeBeans = scanner.nextInt()
        print("Write how many disposable cups do you want to add:\n> ")
        resourcesToAdd.disposableCups = scanner.nextInt()
        scanner.nextLine()

        controller.fill(resourcesToAdd)
    }

    override fun info(resources: Resources) {
        println("\nThe coffee machine has:")
        println("${resources.water} of water")
        println("${resources.milk} of milk")
        println("${resources.coffeeBeans} of coffee beans")
        println("${resources.disposableCups} of disposable cups")
        println("${resources.money} of money")
    }

    override fun take(money: Int) {
        println("\nI gave you $money")
    }

    override fun buy() {
        print("\nWhat do you want to buy? Espresso, latte or cappuccino? Type 'back' to return to main menu:\n> ")
        val result = controller.buyOptions(scanner.nextLine())
        if (result != "back") {
            println("\n$result")
        }
    }
}