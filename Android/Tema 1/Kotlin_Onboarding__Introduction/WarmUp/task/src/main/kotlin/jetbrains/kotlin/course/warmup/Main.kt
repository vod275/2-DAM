package jetbrains.kotlin.course.warmup

// You will use this function later
fun getGameRules(wordLength: Int, maxAttemptsCount: Int, secretExample: String) =
    "Welcome to the game! $newLineSymbol" +
            newLineSymbol +
            "Two people play this game: one chooses a word (a sequence of letters), " +
            "the other guesses it. In this version, the computer chooses the word: " +
            "a sequence of $wordLength letters (for example, $secretExample). " +
            "The user has several attempts to guess it (the max number is $maxAttemptsCount). " +
            "For each attempt, the number of complete matches (letter and position) " +
            "and partial matches (letter only) is reported. $newLineSymbol" +
            newLineSymbol +
            "For example, with $secretExample as the hidden word, the BCDF guess will " +
            "give 1 full match (C) and 1 partial match (B)."

fun main() {
    // Write your solution here

    val wordLength = 4
    val maxAttemptsCount = 3
    val secretExample = "ACEB"
    val secret = "BCDF"
    val guess = "ACEB"


    println(getGameRules(wordLength, maxAttemptsCount, secretExample))

    playGame(secret, wordLength, maxAttemptsCount)
    val exactMatches = countExactMatches(secret, guess)


}
fun generateSecret(): String = "ABCD"
fun countPartialMatches(secret: String, guess: String): Int = TODO("Not implemented yet")
fun countExactMatches(secret: String, guess: String): Int {
    return secret.filterIndexed { index, c -> c == guess[index] }.count()
}

fun isComplete(secret: String, guess: String): Boolean {
    return secret == guess
}


fun playGame(secret: String, wordLength: Int, maxAttemptsCount: Int) {
    var complete: Boolean
    do{
        println("Please input your guess. It should be of length $wordLength.")
        val guess = safeReadLine()
        complete = isComplete(secret, guess)

    } while (!complete)
}









