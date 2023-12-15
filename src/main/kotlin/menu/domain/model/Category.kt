package menu.domain.model

import menu.domain.utils.Error

enum class Category(
    private val categoryName: String,
    private val categoryNumber: Int,
    private val menus: List<String>
) {

    JAPANESE(
        categoryName = "일식",
        categoryNumber = 1,
        menus = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    ),
    KOREAN(
        categoryName = "한식",
        categoryNumber = 2,
        menus = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    ),
    CHINESE(
        categoryName = "중식",
        categoryNumber = 3,
        menus = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    ),
    ASIAN(
        categoryName = "아시안",
        categoryNumber = 4,
        menus = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    ),
    WESTERN(
        categoryName = "양식",
        categoryNumber = 5,
        menus = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    );

    fun getMenus() = this.menus

    companion object {

        fun getCategoryFromNumber(number: Int): Category {
            return entries.find { it.categoryNumber == number }
                ?: throw IllegalArgumentException(Error.INVALID_CATEGORY)
        }

        fun getCategoryFromName(name: String): Category {
            return entries.find { it.categoryName == name }
                ?: throw IllegalArgumentException(Error.INVALID_CATEGORY)
        }
    }

}