package fr.ugatir.cda1_android

import android.os.Bundle
import android.widget.TextView

class TabbarActivity : BaseActivity() {

    val tab1Fragment= Tab1Fragment.newInstance("","")
    val tab2Fragment= Tab2Fragment.newInstance("","")
    val tab3Fragment= Tab3Fragment.newInstance("","")
    val toto="Toto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbar)
        showBack()
        setHeaderTitle(getString(R.string.txtTabbar))

        val tab1= findViewById<TextView>(R.id.textViewTab1)
        val tab2= findViewById<TextView>(R.id.textViewTab2)
        val tab3= findViewById<TextView>(R.id.textViewTab3)

       showTab1()

        tab1.setOnClickListener {
            showTab1()
        }

        tab2.setOnClickListener {
            showTab2()
        }

        tab3.setOnClickListener {
            showTab3()
        }
        tab1Fragment.epsitText
    }

    fun showTab1(){
        val frManager=supportFragmentManager
        val fragmentTra= frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab1")
        fragmentTra.replace(R.id.layoutContent,tab1Fragment)
        fragmentTra.commit()
    }

    fun showTab2(){
        val frManager=supportFragmentManager
        val fragmentTra= frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab2")
        fragmentTra.replace(R.id.layoutContent,tab2Fragment)
        fragmentTra.commit()
    }
    fun showTab3(){
        val frManager=supportFragmentManager
        val fragmentTra= frManager.beginTransaction()
        fragmentTra.addToBackStack("Tab3")
        fragmentTra.replace(R.id.layoutContent,tab3Fragment)
        fragmentTra.commit()
    }
}