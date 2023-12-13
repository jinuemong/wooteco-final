package baseball.util

object Message {

    const val GAME_START = "숫자 야구 게임을 시작합니다."
    const val GAME_NUM_INPUT = "숫자를 입력해주세요 : "
    const val RESULT_STRIKE_AND_BALL = "%d볼 %d스트라이크"
    const val RESULT_ONLY_BALL = "%d볼"
    const val RESULT_NOTTING = "낫싱"
    const val RESULT_ONLY_STRIKE = "%d스트라이크"
    const val GAME_END = "${GameRule.NUMBER_SIZE}개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val GAME_RESTART = "게임을 새로 시작하려면 ${GameRule.RESTART_OK_CODE}, 종료하려면 ${GameRule.RESTART_NO_CODE}를 입력하세요."

}