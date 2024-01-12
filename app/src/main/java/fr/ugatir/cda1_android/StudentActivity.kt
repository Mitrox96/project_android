package fr.ugatir.cda1_android

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBack()
        setHeaderTitle(getString(R.string.txtStudents))

        val students= arrayListOf<Student>()
        val jsStudents= JSONObject((application as AppEpsi).data)
        val jsArrayStudents= jsStudents.getJSONArray("items")
        for(i in 0 until jsArrayStudents.length()){
            val js=jsArrayStudents.getJSONObject(i)
            val student=Student(js.optString("name",""),
                js.optString("email",""),
                js.optString("phone",""),
                js.optString("city",""),
                js.optString("zipcode",""),
                js.optString("picture_url",""))
            students.add(student)
        }


        val recyclerViewStudents= findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerViewStudents.layoutManager=LinearLayoutManager(this)
        val studentAdapter=StudentAdapter(students)
        recyclerViewStudents.adapter=studentAdapter
    }
}