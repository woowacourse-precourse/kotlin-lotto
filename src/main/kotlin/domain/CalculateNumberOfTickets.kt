package domain

private val TICKET_PRICES = 1000

class CalculateNumberOfTickets {
    fun calculateNumberOfTickets(money:Long): Long{
        return money/TICKET_PRICES
    }
}