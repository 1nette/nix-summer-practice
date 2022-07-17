package nix.summer.practice.mvc

enum class CoffeeOptions(val costs: Resources) {
    ESPRESSO(costs = Resources(250, 0, 16, 1, 4)),
    LATTE(costs = Resources(350, 75, 20, 1, 7)),
    CAPPUCCINO(costs = Resources(200, 100, 12, 1, 6))
}