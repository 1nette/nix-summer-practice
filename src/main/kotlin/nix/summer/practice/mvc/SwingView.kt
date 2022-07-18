package nix.summer.practice.mvc

import java.awt.FlowLayout
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*
import kotlin.system.exitProcess

class SwingView(override val controller: Controller) : JFrame(), View {

    private lateinit var jFrame: JFrame

    private lateinit var orderPanel: JPanel
    private lateinit var fillPanel: JPanel
    private lateinit var moneyPanel: JPanel

    private lateinit var waterLabel: JLabel
    private lateinit var milkLabel: JLabel
    private lateinit var coffeeBeansLabel: JLabel
    private lateinit var disposableCupsLabel: JLabel
    private lateinit var moneyLabel: JLabel
    private lateinit var moneyValue: JLabel
    private lateinit var orderLabel: JLabel
    private lateinit var emptyLabel: JLabel

    private lateinit var waterInput: JTextField
    private lateinit var milkInput: JTextField
    private lateinit var coffeeBunsInput: JTextField
    private lateinit var disposableCupsInput: JTextField

    init {
        createUI()
    }

    private fun createUI() {
        title = SwingView::class.java.toString()

        fillPanel = JPanel().apply {
            layout = GridLayout(5, 2, 100, 0)
            border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        }

        moneyPanel = JPanel().apply {
            layout = GridLayout(2, 2, 100, 10)
            border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        }

        orderPanel = JPanel().apply {
            layout = FlowLayout(FlowLayout.CENTER, 10, 10)
            border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        }

        orderLabel = JLabel("Coffee machine is ready", SwingConstants.CENTER)
        orderLabel.font = Font("Verdana", Font.PLAIN, 18)

        emptyLabel = JLabel("")

        jFrame = JFrame("Swing View").apply {
            setSize(500, 500)
            layout = GridLayout(4, 1)
            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(e: WindowEvent?) {
                    exitProcess(0)
                }
            })
            add(fillPanel)
//            add(FooterPanel)
            add(moneyPanel)
            add(orderPanel)
//            add(StatusPanel)
            add(orderLabel)
            isVisible = true
        }

        val espressoButton = JButton("Make espresso").apply {
            actionCommand = "espresso"
            addActionListener(OrderButtonClick())
        }
        orderPanel.add(espressoButton)

        val latteButton = JButton("Make latte").apply {
            actionCommand = "latte"
            addActionListener(OrderButtonClick())
        }
        orderPanel.add(latteButton)

        val cappuccinoButton = JButton("Make cappuccino").apply {
            actionCommand = "cappuccino"
            addActionListener(OrderButtonClick())
        }
        orderPanel.add(cappuccinoButton)

        waterInput = JTextField("0",3)
        milkInput = JTextField("0",3)
        coffeeBunsInput = JTextField("0",3)
        disposableCupsInput = JTextField("0",3)

        waterLabel= JLabel("Water: ")
        milkLabel = JLabel("Milk: ")
        coffeeBeansLabel = JLabel("Coffee beans: ")
        disposableCupsLabel = JLabel("Cups: ")
        moneyLabel = JLabel("Money: ")
        moneyValue = JLabel("0")


        fillPanel.add(waterLabel)
        fillPanel.add(waterInput)

        fillPanel.add(milkLabel)
        fillPanel.add(milkInput)

        fillPanel.add(coffeeBeansLabel)
        fillPanel.add(coffeeBunsInput)

        fillPanel.add(disposableCupsLabel)
        fillPanel.add(disposableCupsInput)

        val fillButton = JButton("Fill").apply {
            addActionListener {
                fill()
            }
        }
        fillPanel.add(emptyLabel)
        fillPanel.add(fillButton)

        val infoButton = JButton("Update info").apply {
            actionCommand = "remaining"
            addActionListener(ButtonClick())
        }

        moneyPanel.add(moneyLabel)
        val takeButton = JButton("Take money").apply {
            actionCommand = "take"
            addActionListener(ButtonClick())
        }
        moneyPanel.add(infoButton)
        moneyPanel.add(moneyValue)
        moneyPanel.add(takeButton)

        jFrame.isVisible = true
    }

    inner class ButtonClick : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            if (e != null) {
                controller.commandHandler(e.actionCommand)
            }
        }
    }

    inner class OrderButtonClick : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            if (e != null) {
                orderAnswer(controller.buyOptions(e.actionCommand))
            }
        }
    }

    fun orderAnswer(answer: String) {
        orderLabel.text = answer
    }

    override fun start() {
        println("Start")
    }

    override fun fill() {
        val resources = Resources(
            waterInput.text.toInt(),
            milkInput.text.toInt(),
            coffeeBunsInput.text.toInt(),
            disposableCupsInput.text.toInt())

        waterInput.text = "0"
        milkInput.text = "0"
        coffeeBunsInput.text = "0"
        disposableCupsInput.text = "0"

        controller.fill(resources)
    }

    override fun info(resources: Resources) {
        waterLabel.text = "Water: ${resources.water}"
        milkLabel.text = "Milk: ${resources.milk}"
        coffeeBeansLabel.text = "Coffee beans: ${resources.coffeeBeans}"
        disposableCupsLabel.text = "Disposable cups: ${resources.disposableCups}"
        moneyValue.text = resources.money.toString()

        orderLabel.text = "Coffee machine is ready"
    }

    override fun take(money: Int) {
        orderLabel.text = "Gave you $money"
    }

    override fun buy() {

    }
}