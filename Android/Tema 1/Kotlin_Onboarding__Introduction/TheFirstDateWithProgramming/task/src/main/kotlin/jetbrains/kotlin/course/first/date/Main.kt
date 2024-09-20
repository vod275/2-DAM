package jetbrains.kotlin.course.first.date

fun main() {
    println("Hello! I will ask you several questions.")
    println("Please answer all of them and be honest with me!")
    println("What is TROTEN?")
    val firstUserAnswer = readlnOrNull()
    // You need to ask two others questions bellow

    println("How did you spend your graduation?")
    val secondUserAnswer =  readlnOrNull()

    println("Why does a spider need eight legs?")
    val thirdUserAnswer =  readlnOrNull()


    println("Now let's have fun!")


    println("What is Kotlin?")
    println(firstUserAnswer)

    println("How was Kotlin invented?")
    println(secondUserAnswer)


    println("Why are you learning Kotlin?")
    println(thirdUserAnswer)


}