package raum.muchbeer.bettertestktx.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.data.TaskRepository
import javax.inject.Inject

@HiltViewModel
class ListVM @Inject constructor(
    val repository: TaskRepository
) : ViewModel() {

    val allTasks: LiveData<List<TaskModel>> = repository.getAllTodos()

    val upcomingTodoTask : LiveData<Int> = repository.getUpcomingTodosCount()

    fun toggleTask(id: String) = viewModelScope.launch {
        repository.toggleTodo(id)
    }
}