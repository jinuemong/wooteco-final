package christmas.domain.model.beverage

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Beverage(
    menuInfo: MenuInfo
) : Menu(MenuType.BEVERAGE, menuInfo) {

    class ZeroCola(menuInfo: MenuInfo) : Beverage(menuInfo)
    class RedWine(menuInfo: MenuInfo) : Beverage(menuInfo)
    class Champagne(menuInfo: MenuInfo) : Beverage(menuInfo)

}