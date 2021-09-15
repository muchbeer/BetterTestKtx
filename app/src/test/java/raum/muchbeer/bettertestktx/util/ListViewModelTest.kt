package raum.muchbeer.bettertestktx.util

import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.data.TaskRepository
import raum.muchbeer.bettertestktx.presentation.viewmodel.ListVM

class ListViewModelTest {

    lateinit var repositoryDummy: TaskRepository

    @Rule
    val expectException = ExpectedException.none()

    @Before
    fun setup() {
        val now = System.currentTimeMillis()
        val day = 1000 * 60 * 60 *24

        val tasks = ArrayList<TaskModel>()
        val todo =TaskModel("1", "Todo 1", null, false, now)
        tasks.add(todo)
        val ted = TaskModel("2", "Taskodo 1", now+day, false, now)
        tasks.add(ted)
        val tep = TaskModel("3", "Tembutu 3", now-day, false, now)
        tasks.add(tep)

         repositoryDummy = TaskTestRepository(tasks)
    }

    @Test
    fun test_allTaskWhenEmpty() {
        val now = System.currentTimeMillis()
        val day = 1000 * 60 * 60 *24

        val expected = 1
        val repository : TaskRepository = mock()

        whenever(repository.getAllTodos())
            .thenReturn(MutableLiveData(arrayListOf(TaskModel("3", "Tembutu 3", now-day, false, now))))

        val model = ListVM(repository)
        val actualTodo = model.allTasks.value
        assertEquals(expected, actualTodo!!.size)
    }

    @Test
    fun test_allTodos() {
        val expected = 3
        val model = ListVM(repositoryDummy)
        val tasks = model.allTasks.value

        assertNotNull(tasks)
        assertEquals(expected, tasks!!.size)
    }

    @Test
    fun test_upComingTodoCount() {
        val expected = 1
        val model = ListVM(repositoryDummy)
        val actual = model.upcomingTodoTask
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun test_toggleCount() {
        val id = "fake"
        val model = ListVM(repositoryDummy)

        // assertThrows(NotImplementedError::class.java)
        // assertTrue(e instanceof)
        expectException.expect(NotImplementedError::class.java)
        model.toggleTask(id)
    }
}