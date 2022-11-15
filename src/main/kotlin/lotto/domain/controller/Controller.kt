package lotto.domain.controller

abstract class Controller {
    abstract fun run()
    open fun finish() { return }
}