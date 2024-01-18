package com.example.projet_selectiondejoueur

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_selectiondejoueur.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    data class Joueur(var Prenom: String, var Pointage: Int)
    private lateinit var binding: ActivityMainBinding
    val joueurs: ArrayList<Joueur> = ArrayList()

    class JoueurAdapter(val listJoueur: ArrayList<Joueur>): RecyclerView.Adapter<JoueurAdapter.ViewHolder>(){

        class ViewHolder(joueurView: View): RecyclerView.ViewHolder(joueurView){
            val tvPrenom = joueurView.findViewById<TextView>(R.id.tvPrenom)
            val tvPointage = joueurView.findViewById<TextView>(R.id.tvPointage)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val joueurView = inflater.inflate(R.layout.ligne_rv, parent, false)
            return ViewHolder(joueurView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val joueur: Joueur = listJoueur.get(position)
            holder.tvPrenom.text = joueur.Prenom
            holder.tvPointage.text = joueur.Pointage.toString()

            holder.tvPrenom.setOnClickListener {
                ChoixJoueur(holder.tvPrenom.text.toString(), holder.tvPointage.text.toString().toInt())
            }
        }

        override fun getItemCount(): Int {
            return listJoueur.size
        }

        companion object{
            var cpt: Int = 0
            var ScoreJ1 = 0
            var Joueur1: Joueur = Joueur("", ScoreJ1)
            var ScoreJ2 = 0
            var Joueur2: Joueur = Joueur("", ScoreJ2)
            var imgdel = 0
            private lateinit var mActivity: MainActivity

            fun initActivity(activity: MainActivity) {
                mActivity = activity
            }

            fun ChoixJoueur(prenom: String, score: Int){
                cpt++
                if (cpt == 1){
                    Joueur1.Prenom = prenom
                    Joueur1.Pointage = score
                    PartieEnCours.J1 = Joueur1
                    mActivity.ChoixImage(Joueur1)
                } else if (cpt == 2){
                    Joueur2.Prenom = prenom
                    Joueur2.Pointage = score
                    PartieEnCours.J2 = Joueur2
                    mActivity.ChoixImage(Joueur2)
                }
            }

            fun MAJpointage(JoueurMAJ: Joueur){
                mActivity.ecrire(JoueurMAJ)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JoueurAdapter.initActivity(this)
        lire()
        findViewById<Button>(R.id.btnAjoutJoueur).setOnClickListener { ajouterJoueur() }
        val joueurAdapter = JoueurAdapter(joueurs)
        findViewById<RecyclerView>(R.id.joueurRecyclerView).adapter = joueurAdapter
        findViewById<RecyclerView>(R.id.joueurRecyclerView).layoutManager = LinearLayoutManager(this)
    }

    fun ajouterJoueur(){
        var nomJoueurrut = findViewById<TextView>(R.id.PtextNomJoueur)
        var nomJoueur = nomJoueurrut.text.toString()
        val newJoueur: Joueur = Joueur(nomJoueur, 0)
        ecrire(newJoueur)
        runOnUiThread {
            joueurs.add(newJoueur)
            findViewById<RecyclerView>(R.id.joueurRecyclerView).adapter?.notifyDataSetChanged()
        }
        nomJoueurrut.text = ""
    }

    fun verif(joueur: Joueur): Boolean {
        joueurs.forEach {
            if (joueur.Prenom == it.Prenom) {
                return true
            }
        }
        return false
    }

    fun ecrire(joueur: Joueur) {
        val file = File(this.filesDir, "listeDesjoueurs.txt")
        if (joueur.Prenom == "erase"){
            joueurs.clear()
            File(this.filesDir, "listeDesjoueurs.txt").outputStream().use {
                it.write("".toByteArray())
            }
        } else if (verif(joueur)) {

            val joueurExistant = joueurs.find { it.Prenom == joueur.Prenom }
            joueurExistant?.Pointage = joueur.Pointage

            val nouvellesLignes = joueurs.map { it ->
                if (it.Prenom == joueur.Prenom) {
                    "${joueur.Prenom},${joueur.Pointage};"
                } else {
                    "${it.Prenom},${it.Pointage};"
                }
            }


            FileOutputStream(file).use { output ->
                nouvellesLignes.forEach { nouvelleLigne ->
                    output.write("$nouvelleLigne\n".toByteArray())
                }
            }

            joueurs.forEach {
                println("${it.Prenom} , score : ${it.Pointage}")
            }
        } else {
            FileOutputStream(file, true).use { output ->
                output.write("${joueur.Prenom},${joueur.Pointage};".toByteArray())
            }
        }
    }

    fun lire(){
        val recuperation = File(this.filesDir, "listeDesjoueurs.txt").bufferedReader().readText();
        val paires = recuperation.split(";")
        try {
            for (paires in paires){
                val elements = paires.split(",")
                val nomJoueur = elements[0].trim()
                val pointageJoueur = elements[1].toInt()
                val joueur = Joueur(nomJoueur, pointageJoueur)
                joueurs.add(joueur)
            }
        } catch (e: java.lang.Exception){
            println(e)
        }
    }

    fun ChoixImage (joueur: Joueur){
        val intent = Intent(this, SelectionImage::class.java)
        startActivity(intent)
    }
}
