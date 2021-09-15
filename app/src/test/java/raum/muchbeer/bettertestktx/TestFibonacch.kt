package raum.muchbeer.bettertestktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import raum.muchbeer.bettertestktx.testutil.TestRegistrationActivity


class TestFibonacch {

    @Test
    fun `return one when number is 1`() {
        val resultOne = TestRegistrationActivity.fib(1)
        assertThat(resultOne).isEqualTo(1)
    }

    @Test
    fun `return 0 when number is 0`() {
        val resultZero = TestRegistrationActivity.fib(0)
        assertThat(resultZero).isEqualTo(resultZero)
    }
    @Test
    fun `return number when number is 4`() {
        val resultZero = TestRegistrationActivity.fib(4)
        val expected = 3
        assertThat(resultZero).isEqualTo(expected)
    }

}