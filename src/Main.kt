fun main() {
    val app = BlackJackApp()
    app.run()
}
class BlackJackApp {

    fun run() {
        // Allows taking from other classes
        val bot = Bot()
        val player = Player()
        val winconditions = WinConditions()
        val split = Split()

        var money = 1000
        var restart = 0
        var hit = 0
        var pTemp = 0
        var sHand1 = 0
        var sHand2 = 0
        var pSplit = 0

        println("WELCOME TO BLACKJACK")
        println("\nPress enter to start the game")
        readLine()

        // Allows user to keep playing until they run out of money or choose to quit
        while (restart != -1) {

            println("You have $money dollars")
            println("How much would you like to bet?")

            // Takes user bet and subtracts from money
            var bet = readLine()!!.toInt()

            // Checks if user has enough money to bet
            if(bet > money){
                println("You don't have enough money to bet that amount")
                println("Please enter a valid bet")
                bet = readLine()!!.toInt()
            }else if(bet <= money){
                money -= bet

                println("You bet $bet dollars")
                println("New balance is $money dollars")
            }


            // Card drawing and total calculation
            val pCard1 = player.PlayerDraw(1)
            val pCard2 = player.PlayerDraw(1)
            val bCard1 = bot.BotDraw(1)
            val bCard2 = bot.BotDraw(1)
            var bTotal = bCard1 + bCard2
            var pTotal = pCard1 + pCard2




            println("\nYou drew a $pCard1 and a $pCard2")
            println("The dealer drew a $bCard1 and a hidden card")

            // Allows players to keep hitting until they stand or bust
            while (pTotal < 21) {

                // Checks for blackjack and ends the game if either player has it
                if(pTotal == 21){
                    println("You got blackjack")
                    break
                }else if(bTotal == 21){
                    println("Dealer got blackjack")
                    break
                }

                println("Your total is $pTotal")

                // Allows players to split if they have two of the same card
                if(pCard1 == pCard2){

                    println("You have two of the same card, would you like to split? Yes - 1 or No - 2")
                    pSplit = readLine()!!.toInt()

                    if(pSplit == 1){
                        sHand1 = pCard1
                        sHand2 = pCard2

                        split.split(sHand1, sHand2)



                    }else {}

                }else {}

                // Player can "Double Down", doubling their bet and drawing one more card only if they have not hit yet and have enough money
                if ((money - (bet * 2) >= 0) and (pTemp == 0) and (pSplit == 0)) {

                    println("Would you like to double down? Yes - 1 or No - 2")
                    val doubleDown = readLine()!!.toInt()

                    if (doubleDown == 1) {

                        money -= bet * 2
                        bet *= 2

                        pTemp = player.PlayerDraw(1)
                        pTotal += pTemp

                        println("You drew a $pTemp")
                        println("Your new total is $pTotal")

                        break
                    }
                }
                println("Would you like to hit - 1 or stand - 2?")

                hit = readLine()!!.toInt()

                // Player draws a card
                if (hit == 1) {
                    pTemp = player.PlayerDraw(1)
                    pTotal += pTemp
                    println("You drew a $pTemp")

                // break loop when user stands
                } else if (hit == 2) {
                    println("You stood")
                    break
                }
            }

            println("Your new total is $pTotal")

            // Dealer Turn
            println("\n Dealer's hidden card was a $bCard2")
            println("The dealer's total is $bTotal")

            // Dealer hits until 17 or more
            while (bTotal < 17) {

                val bTemp = bot.BotDraw(1)
                bTotal += bTemp

                println("The dealer drew a $bTemp")
                println("Dealer new total is $bTotal")
            }

            // Determines the winner and adds or subtracts the bet from the money
            println("Your total is $pTotal -- Dealer total is $bTotal")

            if(pSplit == 1){

            }

            if(pSplit == 1) {

                split.splitWin(sHand1, sHand2, bTotal)


            }else {

                winconditions.checkWin(pTotal, bTotal, bet)

                if (winconditions.win == 1) {
                    money += bet * 2
                } else if (winconditions.win == 2) {
                    money -= bet
                }

            }

            // Asks user if they would like to play again
            println("Would you like to play again? Yes - 1 or No - -1")
            restart = readLine()!!.toInt()

            // Does not allow user to play again if they are out of money
            if((restart == 1) and (money <= 0)){
                println("You are out of money. Game over.")
                restart = -1
            }else if((restart == 1) and (money > 0)){

            }else {
                println("You ended with $money dollars")
                println("Thanks for playing!")
            }
        }
    }
}