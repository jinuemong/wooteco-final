package christmas.domain.model.dessert

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Dessert(
    menuType: MenuType,
     menuInfo: MenuInfo
): Menu(menuType,menuInfo) {

    class ChocolateCake(menuType: MenuType,menuInfo: MenuInfo) : Dessert(menuType,menuInfo)
    class IceCream(menuType: MenuType,menuInfo: MenuInfo): Dessert(menuType,menuInfo)
}