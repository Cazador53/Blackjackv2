class Player {
        fun PlayerDraw(a: Int): Int {

            // Generates a random number between 2 and 14
            var result = (2..14).random()

            // If the result is greater than 11, it is set to 10 to simulate the value of face cards
            if(result > 11){
                result = 10
            }

            // If the result is 11, the user is prompted to choose between 1 or 11 for the Ace
            if(result == 11){

                println("You drew an Ace. Would you like it to be a 1 or 11?")
                var Ace = when(readLine()!!.toInt()) {

                    1 -> result = 1
                    11 -> result = 11
                    else -> println("Invalid input. Please enter 1 or 11")
                }
            }

            return result
        }

    }
