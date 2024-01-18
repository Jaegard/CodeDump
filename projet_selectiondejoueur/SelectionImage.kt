package com.example.projet_selectiondejoueur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.projet_selectiondejoueur.databinding.ActivityMainBinding
import com.example.projet_selectiondejoueur.databinding.ActivityPartieEnCoursBinding
import com.example.projet_selectiondejoueur.databinding.ActivitySelectionImageBinding

class SelectionImage : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionImageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_selection_image)

        val cercle = findViewById<ImageView>(R.id.imvCercle)
        val croix = findViewById<ImageView>(R.id.imvCroix)
        val triangle = findViewById<ImageView>(R.id.imvTriangle)
        val intent = Intent(this, MainActivity::class.java)
        val go = Intent(this, PartieEnCours::class.java)

        when{
            MainActivity.JoueurAdapter.imgdel == 1 -> cercle.visibility = View.INVISIBLE
            MainActivity.JoueurAdapter.imgdel == 2 -> croix.visibility = View.INVISIBLE
            MainActivity.JoueurAdapter.imgdel == 3 -> triangle.visibility = View.INVISIBLE
        }

        cercle.setOnClickListener {

            when{
                MainActivity.JoueurAdapter.cpt == 1 ->{
                    PartieEnCours.imageJoueur1 = R.drawable.circle
                    MainActivity.JoueurAdapter.imgdel = 1
                    startActivity(intent)
                }
                MainActivity.JoueurAdapter.cpt == 2 -> {
                    PartieEnCours.imageJoueur2 = R.drawable.circle
                    startActivity(go)
                }
            }
        }

        croix.setOnClickListener {
            when{
                MainActivity.JoueurAdapter.cpt == 1 ->{
                    PartieEnCours.imageJoueur1 = R.drawable.cross
                    MainActivity.JoueurAdapter.imgdel = 2
                    startActivity(intent)

                }
                MainActivity.JoueurAdapter.cpt == 2 -> {

                    PartieEnCours.imageJoueur2 = R.drawable.cross
                    startActivity(go)

                }
            }
        }

        triangle.setOnClickListener {
            when{
                MainActivity.JoueurAdapter.cpt == 1 -> {
                    PartieEnCours.imageJoueur1 = R.drawable.triangle
                    MainActivity.JoueurAdapter.imgdel = 3
                    startActivity(intent)

                }
                MainActivity.JoueurAdapter.cpt == 2 -> {

                    PartieEnCours.imageJoueur2 = R.drawable.triangle
                    startActivity(go)

                }
            }
        }
    }
}
