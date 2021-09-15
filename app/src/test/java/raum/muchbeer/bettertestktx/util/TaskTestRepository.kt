package raum.muchbeer.bettertestktx.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.data.TaskRepository

class TaskTestRepository(private val todos : ArrayList<TaskModel>) : TaskRepository {
    override fun getAllTodos(): LiveData<List<TaskModel>> {
       return MutableLiveData(todos)
    }

    override suspend fun insert(todo: TaskModel) {
        TODO("Not yet implemented")
    }

    override suspend fun toggleTodo(id: String) {
        TODO("Not yet implemented")
    }

    override fun getUpcomingTodosCount(): LiveData<Int> {

        val count =
            todos.count {
                !it.completed &&
                        it.dueDate !=null &&
                        it.dueDate!! >= System.currentTimeMillis()
            }
        return MutableLiveData(count)
    }
}