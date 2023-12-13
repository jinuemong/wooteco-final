package baseball.util

object Error {

    private const val ERR_MSG = "[ERROR]"

    const val NOT_VALID_NUMBER = "$ERR_MSG 유효하지 않은 입력값 입니다."

    const val NOT_VALID_RESTART = "$ERR_MSG ${GameRule.RESTART_OK_CODE}또는 ${GameRule.RESTART_NO_CODE}를 입력해야 합니다."

    const val NOT_NUMBER_COUNT = "$ERR_MSG ${GameRule.NUMBER_SIZE}가지 숫자를 입력해야 합니다."

}