package lotto.util

object Error {

    const val ERR_MSG = "[ERROR]"

    const val INSUFFICIENT_AMOUNT = "$ERR_MSG 구매 금액이 부족합니다."
    const val INCORRECT_AMOUNT = "$ERR_MSG ${Rule.LOTTO_PRICE}원 단위로 입력해야 합니다."

    const val INCORRECT_LOTTO_NUM = "$ERR_MSG 정확하지 않은 로또 번호가 있습니다."
    const val INCORRECT_LOTTO_COUNT = "$ERR_MSG 로또 수가 ${Rule.LOTTO_COUNT} 아닙니다."

}