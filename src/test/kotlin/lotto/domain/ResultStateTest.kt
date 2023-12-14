package lotto.domain

import lotto.domain.model.ResultState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ResultStateTest {

    @Test
    fun `정확한 1등 측정에 대한 테스트`(){
        assertThat(ResultState.getResult(6,false) == ResultState.FIRST)
    }

    @Test
    fun `정확한 2등 측정에 대한 테스트`(){
        assertThat(ResultState.getResult(5,true)==ResultState.SECOND)
    }

    @Test
    fun `정확한 3등 측정에 대한 테스트`(){
        assertThat(ResultState.getResult(5,false)==ResultState.THIRD)
    }

    @Test
    fun `정확한 4등 측정에 대한 테스트`(){
        assertThat(ResultState.getResult(4,false)==ResultState.FOURTH)
    }

    @Test
    fun `정확한 5등 측정에 대한 테스트`(){
        assertThat(ResultState.getResult(3,false)==ResultState.FIFTH)
    }

    @Test
    fun `예외 처리에 대한 테스트`(){
        assertThrows<NullPointerException> {
            ResultState.getResult(2,false)!!.getMessage()
        }

    }


}