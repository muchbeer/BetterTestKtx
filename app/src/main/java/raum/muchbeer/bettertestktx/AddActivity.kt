package raum.muchbeer.bettertestktx

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import raum.muchbeer.bettertestktx.databinding.ActivityAddBinding
import raum.muchbeer.bettertestktx.presentation.viewmodel.AddViewModel
import java.util.*

@AndroidEntryPoint
class AddActivity : AppCompatActivity() {

    private val viewModel: AddViewModel by viewModels()
    private lateinit var binding : ActivityAddBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
     //   DataBindingUtil.setContentView(this,   R.layout.activity_add)

        constant()
        saveTask()
    }

    private fun constant() {
        binding.due.date = System.currentTimeMillis()
        binding.due.setOnDateChangeListener { _, year, month, day ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            viewModel.todo.dueDate = calendar.timeInMillis
            binding.clearDue.visibility = View.VISIBLE
        }
    }

    private fun saveTask() {
        binding.save.setOnClickListener {
            viewModel.todo.title = binding.txtTitle.text.toString()
            viewModel.todo.copy(title = binding.txtTitle.text.toString())
            viewModel.insertTask()
            it.clearFocus()
            if (viewModel.checkInserted() == "Success") {
                Snackbar.make(it, "Value inserted", Snackbar.LENGTH_LONG).show()  } else {
                finish()
            }
        }

        binding.clearDue.setOnClickListener {
            viewModel.todo.dueDate = null
            binding.clearDue.visibility = View.INVISIBLE
            binding.due.visibility = View.INVISIBLE
                binding.setDue.visibility = View.VISIBLE
        }

        binding.setDue.setOnClickListener {
            binding.clearDue.visibility = View.VISIBLE
            binding.due.visibility = View.VISIBLE
            binding.setDue.visibility = View.INVISIBLE
        }
    }

}