package kz.almat.almatsapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var moveToSecActivvity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToSecActivvity = findViewById(R.id.nextToSecActivity)

        moveToSecActivvity.setOnClickListener{
            moveToMovieActivity()
        }
    }

    fun moveToMovieActivity(){
        val intent = Intent(this, MovieDetailsActivity::class.java)
        startActivity(intent)

    }


}