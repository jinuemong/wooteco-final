package menu.view

import menu.domain.model.Category
import menu.domain.utils.Message

class OutputView {

    fun outputStart(){
        println(Message.START)
    }

    fun outputResult(){
        println(Message.RESULT)
        println(Message.TOP_CATEGORY)
    }

    fun outputCategory(category: List<Category>){

    }

    fun outputEnd(){
        println(Message.END_RESULT)
    }

}