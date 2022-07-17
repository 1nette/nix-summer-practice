package nix.summer.practice.mvc

import kotlin.system.exitProcess

//import java.util.Scanner

class Controller(private val model: CoffeeMachine) {

    private lateinit var view: View

    fun attachView(_view: View) {
        view = _view
    }

    fun start() {
        view.start()
    }

    fun commandHandler(command: String) : Boolean {
        when (command) {
            "buy" -> view.buy()
            "remaining" -> view.info(model.info())
            "fill" -> view.fill()
            "take" -> take()
            "exit" -> exitProcess(0)
        }
        return true
    }

    fun fill(resourcesToAdd: Resources) {
        model.fill(resourcesToAdd)
    }

    fun buyOptions(option: String): String {
        val result = when (option) {
            "espresso" -> model.buy(CoffeeOptions.ESPRESSO)
            "latte" -> model.buy(CoffeeOptions.LATTE)
            "cappuccino" -> model.buy(CoffeeOptions.CAPPUCCINO)
            else -> "back"
        }
        return result
    }

    private fun take() {
        view.take(model.take())
    }
}