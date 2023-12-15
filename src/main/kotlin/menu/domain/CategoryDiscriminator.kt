package menu.domain

import menu.domain.model.Category
import menu.domain.utils.Rule

class CategoryDiscriminator(
    private val weekCategory: MutableMap<Category, Int> = mutableMapOf()
) {

    fun checkCategory(category: Category): Boolean {
        return (weekCategory[category] ?: 0) < Rule.MAX_WEEKEND_CATEGORY
    }

    fun addCategory(category: Category) {
        weekCategory[category] = (weekCategory[category] ?: 0) + 1
    }

    fun checkIsEnoughCategoryCount(): Boolean {
        return weekCategory.size == Rule.MAX_MENU_NUM
    }

    fun getCategory(): List<Category> {
        val currentCategory: MutableList<Category> = mutableListOf()
        weekCategory.map { (category, count) ->
            repeat(count) {
                currentCategory.add(category)
            }
        }
        return currentCategory
    }

}