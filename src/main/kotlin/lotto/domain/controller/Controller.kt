package lotto.domain.controller

abstract class Controller {
    open fun run() {}
    open fun finish() { return }
}