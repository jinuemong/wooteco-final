package menu.domain.model

class Coach(
    private val name: String,
    private val forbiddenFood: Set<String> = mutableSetOf(),
    private val menus: MutableList<String> = mutableListOf()
) {

    fun saveMenu(menu: String) {
        menus.add(menu)
    }

    fun checkIsForbiddenFood(menu: String): Boolean {
        return forbiddenFood.contains(menu)
    }

    fun checkIsPrevFeed(menu: String): Boolean {
        return menus.contains(menu)
    }
}