package raum.muchbeer.bettertestktx.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import raum.muchbeer.bettertestktx.data.TaskDao
import raum.muchbeer.bettertestktx.data.TaskDatabase
import raum.muchbeer.bettertestktx.data.TaskRepository
import raum.muchbeer.bettertestktx.repository.TaskRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : TaskDatabase {
        return TaskDatabase.getInstance(context)!!  }

    @Singleton
    @Provides
    fun provideTaskDao(dataDB: TaskDatabase) : TaskDao {
        return dataDB.taskDao()   }

    @Singleton
    @Provides
    fun provideRepository(taskDao: TaskDao) : TaskRepository {
        return TaskRepositoryImpl(taskDao)
    }

}