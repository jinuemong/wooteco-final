package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.model.CarState
import racingcar.util.Rule

class Processor() {

    fun getProcess(): CarState {
        return if (makeRandomProcess() >= Rule.MIN_PROCESS_NUM) CarState.FORWARD
        else CarState.STOP
    }

    private fun makeRandomProcess(): Int {
        return Randoms.pickNumberInRange(Rule.MIN_RANDOM_NUM, Rule.MAX_RANDOM_NUM)
    }

}