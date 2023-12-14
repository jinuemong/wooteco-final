package lotto.domain.model

import lotto.util.Form

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun convertOutputValue() =
        numbers.sorted().joinToString("${Form.LOTTO_SEPARATOR} ")

    fun convertSetVale() = numbers.toSet()

}