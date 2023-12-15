package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.model.Category

class MenuSelector {

    fun selectCategory(){
       Randoms.pickNumberInRange(1, 5)
    }
}