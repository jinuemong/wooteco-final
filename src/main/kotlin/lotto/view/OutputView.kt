package lotto.view

import lotto.util.Form
import lotto.util.Message

class OutputView {

    fun outputLottoCount(count: Int) {
        println(Message.PURCHASE_LOTTO_COUNT.format(count))
    }

    fun outputLottoNumbers(lottoNumbers: String) {
        println("${Form.FORM_START_LOTTO}${lottoNumbers}${Form.FORM_END_LOTTO}")
    }

    fun outputStartResult() {
        println(Message.START_RESULT)
    }

    fun outputResult(message: String, result: Int) {
        println("$message ${result}${Form.UNIT_COUNT}")
    }

    fun outputRate(rate: Double) {
        println("총 수익률은 ${String.format(RATE_FORMAT, rate)}%입니다.")
    }

    companion object {
        private const val RATE_FORMAT = "%.1f"
        private const val RETURN_FORMAT = "#,###.0"
    }

}