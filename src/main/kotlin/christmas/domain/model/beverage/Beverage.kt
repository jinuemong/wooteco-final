package christmas.domain.model.beverage

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Beverage(
    menuType: MenuType,
    menuInfo: MenuInfo
) : Menu(menuType, menuInfo) {

    class ZeroCola(menuType: MenuType,menuInfo: MenuInfo) : Beverage(menuType,menuInfo)
    class RedWine(menuType: MenuType,menuInfo: MenuInfo) : Beverage(menuType,menuInfo)
    class Champagne(menuType: MenuType,menuInfo: MenuInfo) : Beverage(menuType,menuInfo)

}