class WinConditions {
    fun checkWin(){
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
    }
}