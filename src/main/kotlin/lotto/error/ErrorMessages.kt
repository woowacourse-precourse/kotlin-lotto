package lotto.error

object ErrorMessages {

    private const val PREFIX = "[ERROR]"

    private fun String.applyPrefix(): String = "$PREFIX $this"

}