class WinConditions {
    var win = 0
    fun checkWin(pTotal: Int, bTotal: Int, bet: Int,): Int {

        if ((pTotal > 21) and (bTotal <= 21)) {
            println("You busted -$bet dollars")
            win = 2
        } else if ((bTotal > 21) and (pTotal <= 21)) {
            println("Dealer busted +$bet dollars")
            win = 1
        } else if ((pTotal == bTotal) or (pTotal == bTotal)) {
            println("Push +0 dollars")
            win = 3
        } else if ((pTotal == 21) and (bTotal < 21)) {
            println("Blackjack +$bet dollars")
            win = 1
        } else if ((pTotal < 21) and (bTotal == 21)) {
            println("Dealer Blackjack -$bet dollars")
            win = 2
        } else if ((pTotal > bTotal) and (pTotal < 21)) {
            println("You win +$bet dollars")
            win = 1
        } else if ((pTotal < bTotal) and (bTotal < 21)) {
            println("You lose -$bet dollars")
            win = 2
        }
        return win
    }
}

