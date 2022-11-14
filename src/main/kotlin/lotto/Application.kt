package lotto

import data.StringResource

fun main() {
    try {
        Winning().createYield(8000)
    } catch (exception: IllegalArgumentException) {
        println(StringResource.ERROR.resource)
    }

}
