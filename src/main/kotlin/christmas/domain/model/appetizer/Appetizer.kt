package christmas.domain.model.appetizer

import christmas.domain.model.Menu
import christmas.domain.model.MenuInfo
import christmas.domain.model.MenuType

sealed class Appetizer(
    menuType: MenuType,
    menuInfo: MenuInfo
): Menu(menuType,menuInfo) {

    class MushroomSoup(menuType: MenuType,menuInfo:MenuInfo): Appetizer(menuType,menuInfo)
    class Tapas(menuType: MenuType,menuInfo:MenuInfo): Appetizer(menuType,menuInfo)
    class CaesarSalad(menuType: MenuType,menuInfo:MenuInfo): Appetizer(menuType,menuInfo)

}