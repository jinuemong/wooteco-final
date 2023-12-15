package menu.domain.utils

object Rule {

    const val SPLIT_SEPARATOR = ","

    const val MIN_MENU_NUM = 1
    const val MAX_MENU_NUM = 5

    const val MIN_NAME = 2
    const val MAX_NAME = 4

    const val MIN_COACH_NUM = 2
    const val MAX_COACH_NUM = 5

    const val MAX_WEEKEND_CATEGORY = 2

    const val NAME_RULE = "^[\\s가-힣a-zA-Z]{${MIN_NAME},${MAX_NAME}}\$"

}