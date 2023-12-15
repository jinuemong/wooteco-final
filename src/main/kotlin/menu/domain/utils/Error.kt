package menu.domain.utils

object Error {

    private const val ERR_MSG = "[ERROR]"

    const val INVALID_CATEGORY = "$ERR_MSG 유효하지 않은 카테고리 입니다."

    const val FEWER_COACHES = "$ERR_MSG 코치는 최소 2명 이상 입력해야 합니다"
    const val LARGE_COACHES = "$ERR_MSG 코치는 최대 5명 이하 입력해야 합니다."

    const val FEWER_COACH_NAME ="$ERR_MSG 코치 이름은 최소 2글자 이상 입력해야 합니다."
    const val LARGE_COACH_NAME ="$ERR_MSG 코치 이름은 최대 4글자 이하 입력해야 합니다."
    const val INACCURATE_COACH_NAME = "$ERR_MSG 부적절한 코치 이름입니다."

    const val ERR_SELECT_MENU = "$ERR_MSG 메뉴 선정에 실패 했습니다."
}