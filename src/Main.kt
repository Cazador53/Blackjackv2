import kotlin.random.Random

fun main() {
    val app = BlackJackApp()
    app.run()
}
class BlackJackApp {

    fun run() {
        val bot = Bot()
        val player = Player()
        var money = 1000
        var restart = 0
        var hit = 0
        var pTemp = 0

        println("WELCOME TO BLACKJACK")
        println("\nPress enter to start the game")
        readLine()

        // Allows user to keep playing until they run out of money or choose to quit
        while (restart != -1) {

            println("You have $money dollars")
            println("How much would you like to bet?")

            // Takes user bet and subtracts from money
            var bet = readLine()!!.toInt()
            money -= bet

            println("You bet $bet dollars")

            // Card drawing and total calculation
            var pCard1 = player.PlayerDraw(1)
            var pCard2 = player.PlayerDraw(1)
            var bCard1 = bot.BotDraw(1)
            var bCard2 = bot.BotDraw(1)
            var bTotal = bCard1 + bCard2
            var pTotal = pCard1 + pCard2

            println("\nYou drew a $pCard1 and a $pCard2")
            println("The dealer drew a $bCard1 and a hidden card")

            // Allows players to keep hitting until they stand or bust
            while (pTotal < 21) {

                println("Your total is $pTotal")

                // Player can "Double Down", doubling their bet and drawing one more card
                if (money - (bet * 2) >= 0) {

                    println("Would you like to double down? Yes - 1 or No - 2")
                    var doubleDown = readLine()!!.toInt()

                    if (doubleDown == 1) {

                        money -= bet * 2
                        bet *= 2

                        pTemp = player.PlayerDraw(1)
                        break
                    }
                }
                println("Would you like to hit - 1 or stand - 2?")

                hit = readLine()!!.toInt()

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

                var bTemp = bot.BotDraw(1)
                bTotal += bTemp

                println("The dealer drew a $bTemp")
                println("Dealer new total is $bTotal")
            }
            println("Your total is $pTotal -- Dealer total is $bTotal")
            if ((pTotal > 21) and (bTotal <= 21)) {
                println("You busted -$bet dollars")
            } else if ((bTotal > 21) and (pTotal <= 21)) {
                println("Dealer busted +$bet dollars")
                money += bet * 2
            } else if ((pTotal == bTotal) or (pTotal == bTotal)) {
                println("Push +0 dollars")
                money += bet
            } else if ((pTotal == 21) and (bTotal < 21)) {
                println("Blackjack +$bet dollars")
                money += bet * 2
            } else if ((pTotal < 21) and (bTotal == 21)) {
                println("Dealer Blackjack -$bet dollars")
            } else if ((pTotal > bTotal) and (pTotal < 21)) {
                println("You win +$bet dollars")
                money += bet * 2
            } else if ((pTotal < bTotal) and (bTotal < 21)) {
                println("You lose -$bet dollars")
            }

            // Asks user if they would like to play again
            println("Would you like to play again? Yes - 1 or No - -1")
            restart = readLine()!!.toInt()

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