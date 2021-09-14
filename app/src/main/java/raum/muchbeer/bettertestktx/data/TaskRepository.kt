package raum.muchbeer.bettertestktx.data

import androidx.lifecycle.LiveData

interface TaskRepository {

        fun getAllTodos(): LiveData<List<TaskModel>>

        suspend fun insert(todo: TaskModel)

       suspend fun toggleTodo(id: String)

       fun getUpcomingTodosCount(): LiveData<Int>
    }
