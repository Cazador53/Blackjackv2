open class Split {
    fun split(sHand1: Int, sHand2: Int): Pair<Int, Int> {
        val x = 0
        var hand1 = sHand1
        var hand2 = sHand2
        println("You have split your hand")

        while (x != 3) {

            println("Hand 1 is $sHand1 and hand 2 is $sHand2")
            println("Would you like to hit on hand 1 - 1, hit on hand 2 - 2, or stand on both - 3?")
            val choice = readLine()!!.toInt()

            if (choice == 1) {
                hand1 += Player().PlayerDraw(1)

            } else if (choice == 2) {
                hand2 += Player().PlayerDraw(1)

            } else {
                break
            }

        }
        return Pair(hand1, hand2)
    }

    fun splitWin(sHand1: Int, sHand2: Int, bTotal: Int): Int {
        var win = 0

        if((sHand1 > 21) and (sHand2 > 21) and (bTotal <= 21)) {
            println("You busted on both hands")
            win = 2
        }else if((sHand1 > 21) and (sHand2 < 21) and (bTotal <= 21)){
            println("Hand 1 busted")
            win = 2

        return win
    }
}