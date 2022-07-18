package nix.summer.practice.mvc
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val model = CoffeeMachine()
    val controller = Controller(model)

    print("Which view to use? Terminal or graphic?\n> ")
    val view = when (scanner.nextLine()) {
        "terminal" -> TerminalView(controller)
        else -> SwingView(controller)
    }

    controller.attachView(view)

    controller.start()
}