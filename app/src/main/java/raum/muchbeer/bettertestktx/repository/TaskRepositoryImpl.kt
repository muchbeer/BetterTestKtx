package raum.muchbeer.bettertestktx.repository

import androidx.lifecycle.LiveData
import raum.muchbeer.bettertestktx.data.TaskDao
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.data.TaskRepository

class TaskRepositoryImpl(private val taskDao : TaskDao) : TaskRepository{

    private var allTodos: LiveData<List<TaskModel>> = taskDao.getAllTodos()

    override fun getAllTodos(): LiveData<List<TaskModel>> {
        return allTodos
    }

    override suspend fun insert(todo: TaskModel) {
       taskDao.insert(todo)
    }

    //optionally return an int value indicating
    // the number of rows that were updated successfully
    override suspend fun toggleTodo(id: String) {
        //Will execute only taskDao.toggleTodo is equal to one otherwise
        //throw Task not found must be ==1
        require(taskDao.toggleTodo(id) == 1) { "Task not found must equal to 1" }
    }

    //when you see the equal sign means it return value
    override fun getUpcomingTodosCount(): LiveData<Int> =
        taskDao.getDateCount(System.currentTimeMillis())

}