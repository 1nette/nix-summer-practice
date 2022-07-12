package nix.summer.practice.chatbot
import java.util.*

fun main() {
    val scanner  = Scanner(System.`in`)

    // 1st stage
    print("Please enter the chatbot's name:\n>> ")
    val botName = scanner.nextLine()
    print("Please enter the chatbot's year of creation:\n>> ")
    val yearOfCreating = scanner.nextInt()
    scanner.nextLine()

    println("\n$botName: Hello! My name is $botName. I was created in $yearOfCreating.")

    // other stages
    secondStage(botName, scanner)
    thirdStage(botName, scanner)
    fourthStage(botName, scanner)
    fifthStage(botName, scanner)

    println("$botName: Goodbye, have a nice day!")
}

fun secondStage(botName: String, scanner: Scanner){
    print("$botName: Please, remind me your name.\n>> ")
    val yourName = scanner.nextLine()

    println("\n$botName: What a great name you have, $yourName!")
}

fun thirdStage(botName: String, scanner: Scanner){
    print("$botName: Let me guess your age.\n$botName: Enter remainders of dividing your age by 3, 5 and 7.\n>> ")
    val remainder3 = scanner.nextInt()
    print(">> ")
    val remainder5 = scanner.nextInt()
    print(">> ")
    val remainder7 = scanner.nextInt()
    scanner.nextLine()

    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105

    println("\n$botName: Your age is $age; that's a good time to start programming!")
}

fun fourthStage(botName: String, scanner: Scanner){
    print("\n$botName: I will prove to you that I can count to any number you want:\n>> ")
    val number = scanner.nextInt()

    for (i in 1..number){
        println("$i !")
    }
}

fun fifthStage(botName: String, scanner: Scanner){
    println("\n$botName: Let's pass a little math quiz!")
    while (true){
        print("\nFirst question. 2 + 2 = ?\n1. 2\n2. 5\n3. 4\n>> ")
        var answer = scanner.nextInt()
        when (answer){
            1 -> { println("\n$botName: Please, try again")
                continue }
            2 -> { println("\n$botName: Please, try again")
                continue }
        }

        print("\nSecond question. 2 + 5 = ?\n1. 2\n2. 7\n3. 4\n>> ")
        answer = scanner.nextInt()
        when (answer){
            1 -> { println("\n$botName: Please, try again")
                continue }
            3 -> { println("\n$botName: Please, try again")
                continue }
        }

        print("\nThird question. 3 * 9 = ?\n1. 27\n2. 13\n3. 35\n>> ")
        answer = scanner.nextInt()
        when (answer){
            2 -> { println("\n$botName: Please, try again")
                continue }
            3 -> { println("\n$botName: Please, try again")
                continue }
        }

        print("\nFourth question. 6 * 10 = ?\n1. 48\n2. 60\n3. 121\n>> ")
        answer = scanner.nextInt()
        when (answer){
            1 -> { println("\n$botName: Please, try again")
                continue }
            3 -> { println("\n$botName: Please, try again")
                continue }
        }

        print("\nFifth question. 35 / 5 = ?\n1. 5\n2. 6\n3. 7\n>> ")
        answer = scanner.nextInt()
        when (answer){
            1 -> { println("\n$botName: Please, try again")
                continue }
            2 -> { println("\n$botName: Please, try again")
                continue }
        }
        break
    }
    println("\n$botName: Great, you're right!")
}