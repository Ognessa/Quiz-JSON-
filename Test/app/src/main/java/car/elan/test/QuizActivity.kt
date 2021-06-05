package car.elan.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class QuizActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val quizRV: RecyclerView = findViewById(R.id.quiz_list)

        var quizList: ArrayList<QuizType> = arrayListOf()

        //connect layout
        quizRV.layoutManager = LinearLayoutManager(this)

        try{
            val obj = JSONObject(loadJSONFromAsset())
            val list = obj.getJSONArray("questions")
            for(i in 0 until list.length()){
                val detail = list.getJSONObject(i)

                val name: String = detail.getString("questionText")

                val aList: ArrayList<String> = arrayListOf()
                val answList = detail.getJSONArray("answers")
                for(i in 0 until answList.length()){
                    aList.add(answList.getJSONObject(i).getString("answerText"))
                }

                val correctAnsw: Int = detail.getInt("correctAnswerIndex")

                quizList.add(QuizType(name, aList, correctAnsw))
            }
        }catch(e: JSONException){
            e.printStackTrace()
        }

        //connect to custom adapter and add click listener
        quizRV.adapter = RVAdapter(this, quizList)

    }

    private fun loadJSONFromAsset(): String{
        val json: String?
        try{
            val inputStream = assets.open("quiz.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }catch(ex: IOException){
            ex.printStackTrace()
            return ""
        }
        return json
    }

}