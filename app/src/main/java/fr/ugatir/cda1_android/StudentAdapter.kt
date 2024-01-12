package fr.ugatir.cda1_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter (private val students: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        val textViewZipcode = view.findViewById<TextView>(R.id.textViewZipcode)
        val textViewPhone = view.findViewById<TextView>(R.id.textViewPhone)
        val imageViewStudent = view.findViewById<ImageView>(R.id.imageViewStudent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_student, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student=this.students.get(position)
        holder.textViewName.text=student.name
        holder.textViewEmail.text=student.email
        holder.textViewPhone.text=student.phone
        holder.textViewCity.text=student.city
        holder.textViewZipcode.text=student.zipcode
        Glide.with(holder.imageViewStudent.context).load(student.imgUrl).into(holder.imageViewStudent);
    }
}
