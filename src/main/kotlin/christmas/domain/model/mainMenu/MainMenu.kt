package christmas.domain.model.mainMenu

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class MainMenu(
    private val menuInfo: MenuInfo
) : Menu(MenuType.MAIN, menuInfo) {

    class TBoneSteak(menuInfo: MenuInfo) : MainMenu(menuInfo)
    class BarbecueRib(menuInfo: MenuInfo) : MainMenu(menuInfo)
    class SeafoodPasta(menuInfo: MenuInfo) : MainMenu(menuInfo)
    class ChristmasPasta(menuInfo: MenuInfo) : MainMenu(menuInfo)

}