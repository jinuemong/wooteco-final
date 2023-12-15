package christmas.domain.model

open class Menu(
    private val menuType: MenuType,
    private val menuInfo: MenuInfo
) {

    fun getMenuPrice(): Int = menuInfo.getOrderPrice()
    fun getMenuType(): MenuType = menuType

}