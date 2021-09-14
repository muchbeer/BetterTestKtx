package raum.muchbeer.bettertestktx.adapter

import android.os.Build
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import raum.muchbeer.bettertestktx.common.determineCardColor
import raum.muchbeer.bettertestktx.data.TaskModel
import raum.muchbeer.bettertestktx.databinding.TodoItemBinding
import java.util.*
import kotlin.collections.ArrayList

class TaskAdapter(val clickListener: (String)->Unit) :
    RecyclerView.Adapter<TaskAdapter.TaskVH>() {

    private var allTask: List<TaskModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {

        val itemView = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
                        parent, false)

        return TaskVH(itemView)
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
     holder.bindData(allTask[position])    }

    override fun getItemCount(): Int {
        return allTask.size ?: 0
    }

    fun setTask(todo : List<TaskModel>) {
        this.allTask = todo
        notifyDataSetChanged()
    }

   inner class TaskVH(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(task: TaskModel) {
            binding.completed.isChecked = task.completed
            binding.completed.setOnClickListener {
               clickListener(task.id) }

            binding.title.text = task.title
            val calendar = Calendar.getInstance()
            val dateFormat = DateFormat.getDateFormat(itemView.context)

            calendar.timeInMillis = task.created
            binding.start.text = dateFormat.format(calendar.time)

            if (task.dueDate != null) {
                calendar.timeInMillis = task.dueDate!!
                binding.due.text = dateFormat.format(calendar.time)
            } else {
                binding.due.visibility = View.INVISIBLE
                binding.dueLabel.visibility = View.INVISIBLE
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                binding.card.setCardBackgroundColor(
                    binding.root.context.getColor(
                        determineCardColor(
                            task.dueDate,
                            task.completed
                        )
                    )
                )
            }
        }
    }
 }