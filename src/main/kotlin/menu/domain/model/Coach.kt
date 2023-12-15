package menu.domain.model

class Coach(
    private val forbiddenFood : Set<String>,
    private val menus: MutableList<String> = mutableListOf()
) {

    fun saveMenu(menu: String){
        menus.add(menu)
    }

    fun checkIsForbiddenFood(menu:String): Boolean{
        return forbiddenFood.contains(menu)
    }
}