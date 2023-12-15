package menu.domain.model

import menu.domain.utils.Rule

class Coach(
    private val name: String,
    private val forbiddenFood: MutableSet<String> = mutableSetOf(),
    private val menus: MutableList<String> = mutableListOf()
) {

    fun saveMenu(menu: String) {
        menus.add(menu)
    }

    fun checkIsEnoughMenuCount(): Boolean{
        return menus.size == Rule.MAX_MENU_NUM
    }

    fun saveForbiddenFood(food:List<String>){
        forbiddenFood.addAll(food.toSet())
    }

    fun checkIsForbiddenFood(menu: String): Boolean {
        return forbiddenFood.contains(menu)
    }


    fun checkIsPrevFeed(menu: String): Boolean {
        return menus.contains(menu)
    }

    fun getCoachName(): String = name
}