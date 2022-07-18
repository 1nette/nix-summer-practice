package nix.summer.practice.mvc

interface View {
    val controller: Controller

    fun start()

    fun fill()

    fun info(resources: Resources)

    fun take(money: Int)

    fun buy()
}