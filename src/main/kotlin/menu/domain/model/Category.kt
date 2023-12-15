package menu.domain.model

enum class Category(
    private val menuName: String,
    private val menuNumber: Int,
    private val menus: List<String>
) {

    JAPANESE(
        menuName = "일식",
        menuNumber = 1,
        menus = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    ),
    KOREAN(
        menuName = "한식",
        menuNumber = 2,
        menus = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    ),
    CHINESE(
        menuName = "중식",
        menuNumber = 3,
        menus = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    ),
    ASIAN(
        menuName = "아시안",
        menuNumber = 4,
        menus = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    ),
    WESTERN(
        menuName = "양식",
        menuNumber = 5,
        menus = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    );

    fun getMenus() = this.menus

    companion object {

        fun getCategoryFromNumber(number: Int): Category {
            return entries.find { it.menuNumber == number }
                ?: throw IllegalArgumentException()
        }

        fun getCategoryFromName(name: String): Category {
            return entries.find { it.menuName == name }
                ?: throw IllegalArgumentException()
        }
    }

}