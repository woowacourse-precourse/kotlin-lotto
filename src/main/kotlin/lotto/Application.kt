package lotto

fun main() {
    val machine = Machine()
    val broadcast = Broadcast()

    machine.operate()
    broadcast.broadcast(machine.issuedLottery)

}
