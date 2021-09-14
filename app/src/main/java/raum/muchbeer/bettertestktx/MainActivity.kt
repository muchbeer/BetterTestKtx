package raum.muchbeer.bettertestktx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import raum.muchbeer.bettertestktx.adapter.TaskAdapter
import raum.muchbeer.bettertestktx.databinding.ActivityMainBinding
import raum.muchbeer.bettertestktx.presentation.viewmodel.ListVM

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private val viewModel  by viewModels<ListVM>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        adapter = TaskAdapter { toggle ->
            viewModel.toggleTask(toggle)
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        taskList()
        upcomingCount()
    }

    private fun upcomingCount() {
        viewModel.upcomingTodoTask.observe(this) { count ->
            binding.soonValue.text = count.toString()

        }
    }

    private fun taskList() {
     viewModel.allTasks.observe(this) { listOfTask->
          listOfTask?.let {
              adapter.setTask(it)
          }
       }
    }
}