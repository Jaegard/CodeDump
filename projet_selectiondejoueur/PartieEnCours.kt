package com.example.projet_selectiondejoueur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import com.example.projet_selectiondejoueur.MainActivity.JoueurAdapter.Companion.Joueur1
import com.example.projet_selectiondejoueur.MainActivity.JoueurAdapter.Companion.Joueur2
import com.example.projet_selectiondejoueur.MainActivity.JoueurAdapter.Companion.initActivity
import com.example.projet_selectiondejoueur.databinding.ActivityMainBinding
import com.example.projet_selectiondejoueur.databinding.ActivityPartieEnCoursBinding
import java.util.IllegalFormatCodePointException


class PartieEnCours : AppCompatActivity() {
    private lateinit var binding: ActivityPartieEnCoursBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartieEnCoursBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)

        binding.nomJoueur1.text = J1.Prenom
        binding.nomJoueur2.text = J2.Prenom
        binding.PointsJ1.text = Joueur1.Pointage.toString()
        binding.PointsJ2.text = Joueur2.Pointage.toString()
        binding.txtAnnonceur.text = "Au tour de : ${J1.Prenom}"


        //detecte les clicks et envoie l'id a la fonction
        binding.C1.setOnClickListener { jeux(binding.C1) }
        binding.C2.setOnClickListener { jeux(binding.C2) }
        binding.C3.setOnClickListener { jeux(binding.C3) }
        binding.C4.setOnClickListener { jeux(binding.C4) }
        binding.C5.setOnClickListener { jeux(binding.C5) }
        binding.C6.setOnClickListener { jeux(binding.C6) }
        binding.C7.setOnClickListener { jeux(binding.C7) }
        binding.C8.setOnClickListener { jeux(binding.C8) }
        binding.C9.setOnClickListener { jeux(binding.C9) }

        binding.btnRecommencer.setOnClickListener { recommencer() }
        binding.btnQuit.setOnClickListener { quitter() }

    }


    var tourJ1 = true
    var C1 = true
    var C2 = true
    var C3 = true
    var C4 = true
    var C5 = true
    var C6 = true
    var C7 = true
    var C8 = true
    var C9 = true
    var J1_Case = arrayListOf<Int>()
    var J2_Case = arrayListOf<Int>()
    var win = false
    var nbCoups =0


    companion object{
        var imageJoueur2 = 0
        var imageJoueur1 = 0
        var  J1: MainActivity.Joueur = MainActivity.Joueur("testeur",0)
        var J2: MainActivity.Joueur = MainActivity.Joueur("testeur",0)
    }


    //fonction de partie en cours
    fun jeux(imageView: ImageView) {


        var Annonce = binding.txtAnnonceur
        if (!win) {
            when (imageView.id) {
                R.id.C1 ->
                    if (C1) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C1 = false
                            J1_Case.add(1)
                            nbCoups++
                            WinCheck()


                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C1 = false
                            J2_Case.add(1)
                            nbCoups++
                            WinCheck()

                        }
                    }

                R.id.C2 ->
                    if (C2) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C2 = false
                            J1_Case.add(2)
                            nbCoups++
                            WinCheck()

                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C2 = false
                            J2_Case.add(2)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C3 ->
                    if (C3) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C3 = false
                            J1_Case.add(3)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C3 = false
                            J2_Case.add(3)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C4 ->
                    if (C4) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C4 = false
                            J1_Case.add(4)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C4 = false
                            J2_Case.add(4)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C5 ->
                    if (C5) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C5 = false
                            J1_Case.add(5)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C5 = false
                            J2_Case.add(5)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C6 ->
                    if (C6) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C6 = false
                            J1_Case.add(6)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C6 = false
                            J2_Case.add(6)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C7 ->
                    if (C7) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C7 = false
                            J1_Case.add(7)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C7 = false
                            J2_Case.add(7)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C8 ->
                    if (C8) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C8 = false
                            J1_Case.add(8)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C8 = false
                            J2_Case.add(8)
                            nbCoups++
                            WinCheck()
                        }
                    }
                R.id.C9 ->
                    if (C9) {
                        if (tourJ1) {
                            imageView.setImageResource(imageJoueur1)
                            tourJ1 = false
                            Annonce.text = "Au tour de : ${J2.Prenom}"
                            C9 = false
                            J1_Case.add(9)
                            nbCoups++
                            WinCheck()
                        } else {
                            imageView.setImageResource(imageJoueur2)
                            tourJ1 = true
                            Annonce.text = "Au tour de : ${J1.Prenom}"
                            C9 = false
                            J2_Case.add(9)
                            nbCoups++
                            WinCheck()

                        }
                    }
            }
        }
    }



    fun WinCheck(){

        val WinList: List<List<Int>> = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9),
            listOf(1, 5, 9),
            listOf(3, 5, 7)
        )

        val ValeurJ1 = J1_Case.toSet()
        val ValeurJ2 = J2_Case.toSet()

        for (winner in WinList){
            if (ValeurJ1.containsAll(winner)){
                win = true
                binding.txtWinState.text = "${binding.nomJoueur1.text.toString()} a gagne"
                binding.txtAnnonceur.text = "Au tour de : ${binding.nomJoueur1.text.toString()}"
                binding.PointsJ1.text = (binding.PointsJ1.text.toString().toInt() + 1).toString()
                J1.Pointage = binding.PointsJ1.text.toString().toInt()
                MainActivity.JoueurAdapter.MAJpointage(J1)
                tourJ1=true


            }else if (ValeurJ2.containsAll(winner)){
                win = true
                binding.txtWinState.text = "${binding.nomJoueur2.text.toString()} a gagne"
                binding.txtAnnonceur.text = "Au tour de : ${binding.nomJoueur2.text.toString()}"
                binding.PointsJ2.text = (binding.PointsJ2.text.toString().toInt() + 1).toString()
                J2.Pointage = binding.PointsJ2.text.toString().toInt()
                MainActivity.JoueurAdapter.MAJpointage(J2)
                tourJ1 = false
            }else{
                if (nbCoups==9) {
                    nbCoups=0
                    win = true
                    binding.txtWinState.text = "Match Nul"
                }
            }
        }
    }


    fun recommencer() {
        win=false
         C1 = true
         C2 = true
         C3 = true
         C4 = true
         C5 = true
         C6 = true
         C7 = true
         C8 = true
         C9 = true
        binding.C1.setImageResource(R.color.white)
        binding.C2.setImageResource(R.color.white)
        binding.C3.setImageResource(R.color.white)
        binding.C4.setImageResource(R.color.white)
        binding.C5.setImageResource(R.color.white)
        binding.C6.setImageResource(R.color.white)
        binding.C7.setImageResource(R.color.white)
        binding.C8.setImageResource(R.color.white)
        binding.C9.setImageResource(R.color.white)
        J1_Case.clear()
        J2_Case.clear()
        binding.txtWinState.text = ""
        nbCoups=0
    }


    fun quitter(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        nbCoups=0
        MainActivity.JoueurAdapter.cpt = 0
        MainActivity.JoueurAdapter.imgdel =0
    }
}






