package lotto.domain.model

enum class ResultState(
    private val matchNumbers: Int,
    private val price: Int,
    private val message: String
) {

    FIFTH(3, 5_000, "3개 일치 (5,000원) -"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) -"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) -"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) -");

    fun getPrice(count: Int): Int = this.price * count

    fun getMessage() = this.message

    companion object {

        fun getResult(matchCount: Int, bonus: Boolean): ResultState? {
            return when (matchCount) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> {
                    if (!bonus) THIRD
                    else SECOND
                }

                6 -> FIRST
                else -> null
            }
        }
    }
}