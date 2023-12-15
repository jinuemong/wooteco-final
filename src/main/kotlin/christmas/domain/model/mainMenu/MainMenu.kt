package christmas.domain.model.mainMenu

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class MainMenu(
    menuType: MenuType,
    menuInfo: MenuInfo
) : Menu(menuType, menuInfo) {

    class TBoneSteak(menuType: MenuType, menuInfo: MenuInfo) : MainMenu(menuType, menuInfo)
    class BarbecueRib(menuType: MenuType, menuInfo: MenuInfo) : MainMenu(menuType, menuInfo)
    class SeafoodPasta(menuType: MenuType, menuInfo: MenuInfo) : MainMenu(menuType, menuInfo)
    class ChristmasPasta(menuType: MenuType, menuInfo: MenuInfo) : MainMenu(menuType, menuInfo)

}