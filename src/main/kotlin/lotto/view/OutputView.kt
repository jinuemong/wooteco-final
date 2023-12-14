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

    fun outputRate(rate: String){
        println(Message.TOTAL_RATE.format(rate))
    }

}