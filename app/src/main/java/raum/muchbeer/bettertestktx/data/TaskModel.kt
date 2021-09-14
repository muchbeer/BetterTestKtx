package raum.muchbeer.bettertestktx.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_tbl")
data class TaskModel(
    @PrimaryKey var id: String,
    var title: String,
    var dueDate: Long?,
    var completed: Boolean,
    var created: Long
)