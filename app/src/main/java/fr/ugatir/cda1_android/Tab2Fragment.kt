package fr.ugatir.cda1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tab2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tab2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as TabbarActivity).setHeaderTitle(getString(R.string.txtTab2))
        val students= arrayListOf<Student>()
        val jsStudents= JSONObject((activity?.application as AppEpsi).data)
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


        val recyclerViewStudents= view.findViewById<RecyclerView>(R.id.recyclerViewStudents)
        recyclerViewStudents.layoutManager= LinearLayoutManager(activity)
        val studentAdapter=StudentAdapter(students)
        recyclerViewStudents.adapter=studentAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tab2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}