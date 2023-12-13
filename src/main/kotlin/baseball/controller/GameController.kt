package baseball.controller

import baseball.domain.Computer
import baseball.domain.Referee
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var computer: Computer
    private lateinit var referee: Referee

    fun userFlow(){
        gameStart()
        gameProgress()
    }

    private fun gameStart(){
        outputView.enterGame()
        gameAssignment()
    }

    private fun gameProgress(){
        while (true){
            val userNumber = mutableListOf<Int>().apply{
                inputView.enterNumber()
                // 여기서 생성 후 적용
            }
        }
    }

    private fun checkRestart(){

    }


    private fun gameAssignment(){
        computer = Computer()
        referee = Referee(computer.getComputerNumbers())
    }


}