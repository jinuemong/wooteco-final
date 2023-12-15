package christmas.domain.model.appetizer

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Appetizer(
    menuInfo: MenuInfo
): Menu(MenuType.APPETIZER,menuInfo) {

    class MushroomSoup(menuInfo:MenuInfo): Appetizer(menuInfo)
    class Tapas(menuInfo:MenuInfo): Appetizer(menuInfo)
    class CaesarSalad(menuInfo:MenuInfo): Appetizer(menuInfo)

}