package raum.muchbeer.bettertestktx

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import raum.muchbeer.bettertestktx.common.determineCardColor

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(Parameterized::class)
class TaskListTest(
    private val expected : Int,
    private val dueDate : Long?,
    private val done : Boolean,
    private val scenario: String
) {

    companion object {
        val now = System.currentTimeMillis()
        val day = 1000 * 60 * 60 * 24

        @JvmStatic
        @Parameterized.Parameters(name = "determineColorCard : {3}")
        fun tasks() = listOf(arrayOf(R.color.todoDone, null, true, "Done, no date"),
            arrayOf(R.color.todoNotDue, null, false, "Not done, no date"),
                arrayOf(R.color.todoOverDue, now - day, false, "Not done, due yesterday"))
    }

    @Test
    fun test_determineColorCard() {

        val actual = determineCardColor(dueDate, done)

        assertEquals(expected, actual)
    }

    @Test
    fun test_determineColorCardOverDue() {

        val expected = R.color.todoOverDue
        val dueDate = now - day
        val done= false

        val actual = determineCardColor(dueDate, done)

        assertEquals(expected, actual)
    }

}