package christmas.domain.model

import christmas.domain.model.appetizer.Appetizer
import christmas.domain.model.beverage.Beverage
import christmas.domain.model.dessert.Dessert
import christmas.domain.model.mainMenu.MainMenu
import christmas.utils.Form

enum class MenuInfo(
    private val menuName: String,
    private val price: Int,

    ) {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),

    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_RIB("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),

    ZERO_COLA("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    fun getOrderPrice(): Int = this.price

    companion object {

        private val CURRENT_GIVEAWAY = CHAMPAGNE
        private const val CURRENT_GIVEAWAY_COUNT = 1

        fun getMenu(menuInfo: MenuInfo): Menu {
            return when (menuInfo) {
                // APPETIZER
                MUSHROOM_SOUP -> Appetizer.MushroomSoup(MenuType.APPETIZER, menuInfo)
                TAPAS -> Appetizer.Tapas(MenuType.APPETIZER, menuInfo)
                CAESAR_SALAD -> Appetizer.CaesarSalad(MenuType.APPETIZER, menuInfo)
                // MAIN
                T_BONE_STEAK -> MainMenu.TBoneSteak(MenuType.MAIN, menuInfo)
                BARBECUE_RIB -> MainMenu.TBoneSteak(MenuType.MAIN, menuInfo)
                SEAFOOD_PASTA -> MainMenu.TBoneSteak(MenuType.MAIN, menuInfo)
                CHRISTMAS_PASTA -> MainMenu.TBoneSteak(MenuType.MAIN, menuInfo)
                // DESSERT
                CHOCOLATE_CAKE -> Dessert.ChocolateCake(MenuType.DESSERT, menuInfo)
                ICE_CREAM -> Dessert.ChocolateCake(MenuType.DESSERT, menuInfo)
                // BEVERAGE
                ZERO_COLA -> Beverage.ZeroCola(MenuType.BEVERAGE, menuInfo)
                RED_WINE -> Beverage.ZeroCola(MenuType.BEVERAGE, menuInfo)
                CHAMPAGNE -> Beverage.ZeroCola(MenuType.BEVERAGE, menuInfo)
            }
        }

        fun getMenuInfo(menuName: String): MenuInfo? {
            return entries.find { it.menuName == menuName }
        }

        fun getCurrentGiveawayInfo() =
            "${CURRENT_GIVEAWAY.menuName} ${CURRENT_GIVEAWAY_COUNT}${Form.UNIT_MENU}"
        fun getCurrentGiveawayPrice() = CURRENT_GIVEAWAY.price
    }

}