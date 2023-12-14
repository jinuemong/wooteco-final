package lotto.controller

import lotto.domain.LottoManager
import lotto.domain.WinningManager
import lotto.util.Form
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
        matchingLotto()
        resultInfo()
    }

    private fun userPurchase() {
        while (!::lottoManager.isInitialized) {
            try {
                val price = inputView.inputPurchasePrice()
                inputVerifier.checkAccuracyPurchasePrice(price)

                initLottoManager(price.toInt())

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun makeUserLotto() {
        println()
        outputView.outputLottoCount(lottoManager.lottoCount())
        val lottoNumbers = lottoManager.makeOutputValues()
        lottoNumbers.forEach { lottoNumber ->
            outputView.outputLottoNumbers(lottoNumber)
        }
        println()
    }

    private fun makeWinningLotto() {

        var numbers = ""

        while (numbers.isEmpty()) {
            try {
                numbers = getLottoNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }

        println()

        var bonusNumber = ""

        while (bonusNumber.isEmpty()) {
            try {
                bonusNumber = getBonusNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        initWinningManager(makeWinningNumbers(numbers), bonusNumber.toInt())

    }

    private fun matchingLotto() {
        lottoManager.makeLottoSets().forEach { numbers ->
            winningManager.confirmWinning(numbers)
        }

    }

    private fun resultInfo() {
        outputView.outputStartResult()
        val totalRate = lottoManager.getTotalRate(winningManager.getTotalPrice())
        winningManager.getLottoResults().forEach { result ->
            outputView.outputResult(result.first, result.second)
        }
        outputView.outputRate(totalRate)
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

    private fun initLottoManager(price: Int) {
        lottoManager = LottoManager(
            lottoVerifier = lottoVerifier,
            price = price
        )
    }

    private fun makeWinningNumbers(input: String): Set<Int> {
        return input.split(Form.LOTTO_SEPARATOR).map { it.toInt() }.toSet()
    }

    private fun initWinningManager(
        numbers: Set<Int>,
        bonusNumber: Int
    ) {
        winningManager = WinningManager(numbers, bonusNumber)
    }

}