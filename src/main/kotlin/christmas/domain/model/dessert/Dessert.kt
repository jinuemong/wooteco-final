package christmas.domain.model.dessert

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Dessert(
    private val menuInfo: MenuInfo
): Menu(MenuType.DESSERT,menuInfo) {

    class ChocolateCake(menuInfo: MenuInfo) : Dessert(menuInfo)
    class IceCream(menuInfo: MenuInfo): Dessert(menuInfo)
}