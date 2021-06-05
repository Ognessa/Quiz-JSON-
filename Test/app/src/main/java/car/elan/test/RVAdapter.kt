package car.elan.test

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//custom adapter for RecyclerView
class RVAdapter(val context: Context, private val quizList: ArrayList<QuizType>): RecyclerView.Adapter<RVAdapter.MyViewHolder>(){

    //Отримання елеметів з шаблону (цільний елемент списку)
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var questItem: TextView = itemView.findViewById(R.id.question_tv)
        var answGroup: RadioGroup = itemView.findViewById(R.id.rbg_answers)
        var answItem1: RadioButton = itemView.findViewById(R.id.answer1)
        var answItem2: RadioButton = itemView.findViewById(R.id.answer2)
        var answItem3: RadioButton = itemView.findViewById(R.id.answer3)
        var answItem4: RadioButton = itemView.findViewById(R.id.answer4)

    }

    //get custom layout for items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.quiz_row, parent, false)
        return MyViewHolder(itemView)
    }

    //Вставити текст до потрібного елементу
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.questItem.text = quizList[position].questionText
        holder.answItem1.text = quizList[position].answers[0]
        holder.answItem2.text = quizList[position].answers[1]
        holder.answItem3.text = quizList[position].answers[2]
        holder.answItem4.text = quizList[position].answers[3]

        holder.answGroup.setOnCheckedChangeListener { group, checkedId ->
            val rb: RadioButton = group.findViewById(checkedId)
            rb.setTextColor(Color.rgb(255,0,0))
            Toast.makeText(context, "id: $checkedId", Toast.LENGTH_SHORT).show()
        }
    }

    //get count of items
    override fun getItemCount(): Int {
        return quizList.size
    }
}
