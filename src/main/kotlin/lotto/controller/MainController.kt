package lotto.controller

import lotto.domain.LottoManager
import lotto.domain.WinningManager
import lotto.validation.InputValidation
import lotto.validation.LottoValidation
import lotto.view.InputView
import lotto.view.OutputView

class MainController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputVerifier: InputValidation,
    private val lottoVerifier: LottoValidation
) {
    private lateinit var lottoManager: LottoManager
    private lateinit var winningManager: WinningManager

    fun userFlow() {
        userPurchase()
        makeUserLotto()
        makeWinningLotto()
    }

    private fun userPurchase() {
        while (!::lottoManager.isInitialized) {
            try {
                val price = inputView.inputPurchasePrice()
                inputVerifier.checkAccuracyPurchasePrice(price)

                initLottoManager()

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun makeUserLotto() {
    }

    private fun makeWinningLotto() {
        var numbers = ""

        while (numbers.isEmpty()){
            try{
                numbers = getLottoNumbers()
            } catch (e: IllegalArgumentException){
                println(e.message)
            }

        }

        var bonusNumber = ""

        while(bonusNumber.isEmpty()){
            try {
                bonusNumber = getBonusNumber()
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }

        initWinningManager()
    }

    private fun getLottoNumbers(): String {
        val newNumbers = inputView.inputWinningNumber()
        lottoVerifier.checkAccuracyLottoNumbers(newNumbers)
        return newNumbers
    }

    private fun getBonusNumber(): String {
        val newBonusNumber = inputView.inputBonusNumber()
        lottoVerifier.checkAccuracyBonusNumber(newBonusNumber)
        return newBonusNumber
    }


    private fun initLottoManager() {
        lottoManager = LottoManager()
    }

    private fun initWinningManager() {
        winningManager = WinningManager()
    }
}