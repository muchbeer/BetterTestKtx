package raum.muchbeer.bettertestktx.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.data.TaskRepository
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
private val repository: TaskRepository
) : ViewModel() {

    private val _checkInsertion = MutableLiveData<String>()

    init {
        _checkInsertion.value = "Fail"
    }
    val todo = TaskModel(
        UUID.randomUUID().toString(),
        "",
        null,
        false,
        0
    )
    fun insertTask()  {
        viewModelScope.launch {
            if (todo.title.isNotEmpty()) {
                todo.created = System.currentTimeMillis()
                repository.insert(todo)
                _checkInsertion.value = "Success"
            } else Log.d("AddVM", "The value is not there")
        }

    }

    fun checkInserted() : String {
        return if(_checkInsertion.value =="Success") "Success" else "Fail"
    }

}