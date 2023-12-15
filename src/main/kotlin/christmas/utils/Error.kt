package christmas.utils

object Error {

    private const val ERR_MSG ="[ERROR]"

    const val INCORRECT_DATE = "$ERR_MSG 유효하지 않은 날짜입니다. 다시 입력해 주세요."

    const val WRONG_MENU = "$ERR_MSG 유효하지 않은 주문입니다. 다시 입력해 주세요."
    const val WRONG_MENU_COUNT = "$ERR_MSG 유효하지 않은 주문입니다. 다시 입력해 주세요."
    const val WRONG_MENU_FORM ="$ERR_MSG 유효하지 않은 주문입니다. 다시 입력해 주세요."
    const val DUPLICATE_MENU = "$ERR_MSG 유효하지 않은 주문입니다. 다시 입력해 주세요."

    const val NOT_BADGE_DATA = "$ERR_MSG 유효하지 않은 해택 금액입니다."

}