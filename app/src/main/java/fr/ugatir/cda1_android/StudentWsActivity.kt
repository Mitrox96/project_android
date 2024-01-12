package fr.ugatir.cda1_android

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.CacheControl
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class StudentWsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBack()
        setHeaderTitle(getString(R.string.txtStudentsWs))
        val students= arrayListOf<Student>()
        val recyclerViewStudents= findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerViewStudents.layoutManager= LinearLayoutManager(this)
        val studentAdapter=StudentAdapter(students)
        recyclerViewStudents.adapter=studentAdapter
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility=View.VISIBLE

        val okHttpClient:OkHttpClient=OkHttpClient.Builder().build()
        val mRequestUrl="https://www.ugarit.online/epsi/list.json"
        val request= Request.Builder().url(mRequestUrl).get().cacheControl(CacheControl.FORCE_NETWORK).build()
        okHttpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data=response.body?.string()
                if(data!=null){
                    val jsStudents= JSONObject(data)
                    val jsArrayStudents= jsStudents.getJSONArray("items")
                    for(i in 0 until jsArrayStudents.length()){
                        val js=jsArrayStudents.getJSONObject(i)
                        val student=Student(js.optString("name",""),
                            js.optString("email",""),
                            js.optString("phone","18"),
                            js.optString("city","Paris"),
                            js.optString("zipcode","75000"),
                            js.optString("picture_url",""))
                        students.add(student)
                    }
                    runOnUiThread{
                        studentAdapter.notifyDataSetChanged()
                        progressBar.visibility=View.GONE
                    }

                }
            }
        })
    }
}