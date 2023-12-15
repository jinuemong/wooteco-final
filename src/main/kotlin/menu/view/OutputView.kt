package menu.view

import menu.domain.model.Category
import menu.domain.model.MenuDay
import menu.domain.utils.Message

class OutputView {

    fun outputStart(){
        println(Message.START)
    }

    fun outputResult(){
        println(Message.RESULT)
        println(Message.MSG_START_DAY+MenuDay.getMenuDayMessage()+Message.UNIT_END)
    }

    fun outputCategory(category: List<Category>){
        val categoryMessage = category.joinToString(Message.SEPARATOR)
        println(Message.MSG_START_CATEGORY+categoryMessage+Message.UNIT_END)
    }

    fun outputCoachMenu(menus: List<String>){
        val menuMessage = menus.joinToString(Message.SEPARATOR)
        println(Message.MSG_START_COACH+menuMessage+Message.UNIT_END)
    }

    fun outputEnd(){
        println(Message.END_RESULT)
    }

}