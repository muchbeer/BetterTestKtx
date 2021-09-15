package raum.muchbeer.bettertestktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import raum.muchbeer.bettertestktx.testutil.TestRegistrationActivity

class TestRegistration {

    @Test
    fun `test empty username or password return false`() {
        val checkResult = TestRegistrationActivity.validateRegistrationInput(
            "",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(checkResult).isFalse()
    }

    @Test
    fun `test username or password exist return false`() {
        val checkResult = TestRegistrationActivity.validateRegistrationInput(
            "Gadiel",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(checkResult).isTrue()
    }

    @Test
    fun `test password with less than 2 digit return false`() {
        val checkResult = TestRegistrationActivity.validateRegistrationInput(
            "Gadiel",
            password = "siansisidn1",
            confirmedPassword = "123"
        )
        assertThat(checkResult).isFalse()
    }
}