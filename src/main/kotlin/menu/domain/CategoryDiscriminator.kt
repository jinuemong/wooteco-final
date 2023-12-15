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

}