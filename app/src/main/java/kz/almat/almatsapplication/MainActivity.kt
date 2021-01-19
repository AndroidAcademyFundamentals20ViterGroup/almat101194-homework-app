package kz.almat.almatsapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kz.almat.almatsapplication.ui.fragments.interfaces.FragmentClickListener
import kz.almat.almatsapplication.ui.fragments.FragmentMoviesDetails
import kz.almat.almatsapplication.ui.fragments.FragmentMoviesList

class MainActivity : AppCompatActivity(), FragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    addToBackStack(null)
                    add(R.id.main_container, FragmentMoviesList())
                    commit()
                }
        }else {
            supportFragmentManager.beginTransaction()
                .apply {
                    supportFragmentManager.fragments.map {
                        add(R.id.main_container, it)
                    }
                    commit()
                }
        }
    }

    override fun onMoveNextDetaielsClicked(id: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, FragmentMoviesDetails())
            .commit()

    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1) {
            val lastFragment = supportFragmentManager.fragments.last()
            supportFragmentManager.beginTransaction()
                .apply {
                    remove(lastFragment)
                    commit()
                }
        } else {
            super.onBackPressed()
        }
    }

}