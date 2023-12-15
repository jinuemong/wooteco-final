package christmas.domain.model

import christmas.utils.Error
import christmas.utils.Rule

enum class Badge(
    private val badgeName: String
) {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    fun getBadgeName() = badgeName

    companion object {

        fun getPriceBadge(benefitPrice: Int): Badge{
            return when(benefitPrice){
                in 0 until Rule.MIN_STAR_BADGE_PRICE -> NONE
                in Rule.MIN_STAR_BADGE_PRICE until  Rule.MIN_TREE_BADGE_PRICE -> STAR
                in Rule.MIN_TREE_BADGE_PRICE until Rule.MIN_SANTA_BADGE_PRICE -> TREE
                in Rule.MIN_SANTA_BADGE_PRICE until Int.MAX_VALUE -> SANTA
                else -> throw IllegalArgumentException(Error.NOT_BADGE_DATA)
            }
        }
    }
}