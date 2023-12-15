package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.model.Category
import menu.domain.utils.Error
import menu.domain.utils.Rule

class MenuSelector {

    fun selectCategory(): Category{
        return Category.getCategoryFromNumber(makeRandomNum())
    }

    fun selectCategoryMenu(category: Category): String {
        require(category.getMenus().isNotEmpty()){
            Error.ERR_SELECT_MENU
        }
        return Randoms.shuffle(category.getMenus())[0]
    }

    private fun makeRandomNum(): Int{
        return Randoms.pickNumberInRange(Rule.MIN_MENU_NUM, Rule.MAX_MENU_NUM)
    }
}