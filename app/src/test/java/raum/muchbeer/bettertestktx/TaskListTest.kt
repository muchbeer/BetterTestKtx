package raum.muchbeer.bettertestktx

import org.junit.Test

import org.junit.Assert.*
import raum.muchbeer.bettertestktx.common.determineCardColor

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TaskListTest {
    @Test
    fun test_determineColorCard() {

        val expected = R.color.todoDone
        val dueDate = null
        val done= true

        val actual = determineCardColor(dueDate, done)

        assertEquals(expected, actual)
    }
}