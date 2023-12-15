package menu.domain.model

import menu.domain.utils.Message

enum class MenuDay(
    dayName: String
) {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    companion object {

        fun getMenuDayMessage(): String{
            return entries.joinToString(Message.SEPARATOR) { it.name }
        }

    }
}