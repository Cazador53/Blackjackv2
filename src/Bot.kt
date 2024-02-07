class Bot {
    fun BotDraw(a: Int): Int {

        // Generates a random number between 2 and 14
        var result = (2..14).random()

        // If the result is greater than 11, it is set to 10 to simulate the value of face cards
        if (result > 11) {
            result = 10
        }

        // If result is 11 then it flips a coin to decide if it should be 1 or 11
        if (result == 11) {
            result = if ((1..2).random() == 1) 1 else 11
        }
        return result
    }
}