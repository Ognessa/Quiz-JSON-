package car.elan.test

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuizType (val questionText: String,
                     val answers: ArrayList<String>,
                     val correctAnswerIndex: Int)