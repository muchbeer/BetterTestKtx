package raum.muchbeer.bettertestktx.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskModel::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object {
        private var todoRoomInstance: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase? {
            if (todoRoomInstance == null) {
                synchronized(TaskDatabase::class.java) {
                    if (todoRoomInstance == null)
                        todoRoomInstance = Room.databaseBuilder<TaskDatabase>(
                            context.applicationContext,
                            TaskDatabase::class.java,
                            "todo_database"
                        )
                        .build()
                }
            }

            return todoRoomInstance
        }
    }
}