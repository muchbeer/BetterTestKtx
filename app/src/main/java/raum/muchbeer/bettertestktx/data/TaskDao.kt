package raum.muchbeer.bettertestktx.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_tbl ORDER BY created DESC")
    fun getAllTodos(): LiveData<List<TaskModel>>

    @Query("SELECT count(*) FROM task_tbl WHERE completed = 0 AND dueDate >= :date")
    fun getDateCount(date: Long): LiveData<Int>

    @Query("SELECT * FROM task_tbl WHERE id = :id")
    suspend fun getTodo(id: String): TaskModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TaskModel)

    //optionally return an int value indicating
    // the number of rows that were updated successfully
    @Query("UPDATE task_tbl set completed = ~completed WHERE id = :id")
    suspend fun toggleTodo(id: String): Int
}