package nix.summer.practice.mvc

class CoffeeMachine {
    private var resources = Resources(400, 540, 120, 9, 550)

    fun fill(resourcesToAdd: Resources) {
        resources.water += resourcesToAdd.water
        resources.milk += resourcesToAdd.milk
        resources.coffeeBeans += resourcesToAdd.coffeeBeans
        resources.disposableCups += resourcesToAdd.disposableCups
    }

    fun info(): Resources {
        return  resources
    }

    fun take(): Int {
        val money = resources.money
        resources.money = 0
        return money
    }

    private fun checkingIngredients(water: Int, milk: Int, coffeeBeans: Int): String {
        if (resources.water - water < 0) {
            return "Sorry, not enough water!"
        }
        if (resources.milk - milk < 0) {
            return "Sorry, not enough milk!"
        }
        if (resources.coffeeBeans - coffeeBeans < 0) {
            return "Sorry, not enough coffee beans!"
        }
        if (resources.disposableCups - 1 < 0) {
            return "Sorry, not enough disposable cups!"
        }
        else {
            resources.water -= water
            resources.milk -= milk
            resources.coffeeBeans -= coffeeBeans
            resources.disposableCups -= 1

            return "no problems"
        }
    }

    fun buy(option: CoffeeOptions): String {
        val checkingResult = checkingIngredients(option.costs.water, option.costs.milk, option.costs.coffeeBeans)
        if (checkingResult == "no problems") {
            resources.money += option.costs.money
            return "I have enough resources, making you a coffee!"
        }
        else {
            return checkingResult
        }
    }
}