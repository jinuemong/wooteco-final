package lotto.domain.model

import lotto.util.Form

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun convertOutputValue() = numbers.joinToString("${Form.LOTTO_SEPARATOR} ")
}