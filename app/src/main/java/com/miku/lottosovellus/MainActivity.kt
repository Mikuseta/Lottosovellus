package com.miku.lottosovellus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import android.widget.TextView




class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val lottoNappi = findViewById<Button>(R.id.lotto)
        val lottoPallot = listOf(
            findViewById(R.id.lotto1),
            findViewById(R.id.lotto2),
            findViewById(R.id.lotto3),
            findViewById(R.id.lotto4),
            findViewById(R.id.lotto5),
            findViewById(R.id.lotto6),
            findViewById(R.id.lotto7),
            findViewById<TextView>(R.id.lottolis))

        val vikingNappi = findViewById<Button>(R.id.vikinglotto)
        val vikingPallot = listOf(
            findViewById(R.id.viking1),
            findViewById(R.id.viking2),
            findViewById(R.id.viking3),
            findViewById(R.id.viking4),
            findViewById(R.id.viking5),
            findViewById(R.id.viking6),
            findViewById<TextView>(R.id.vikingplus))
        val vikingViking = listOf(
            findViewById<TextView>(R.id.vikingviking))

        val molemmatNappi = findViewById<Button>(R.id.molemmat)

        val tyhjennaNappi = findViewById<Button>(R.id.tyhjenna)
        val tyhjennaPallot = listOf(findViewById(R.id.lotto1),
            findViewById(R.id.lotto2),
            findViewById(R.id.lotto3),
            findViewById(R.id.lotto4),
            findViewById(R.id.lotto5),
            findViewById(R.id.lotto6),
            findViewById(R.id.lotto7),
            findViewById(R.id.lottolis),
            findViewById(R.id.viking1),
            findViewById(R.id.viking2),
            findViewById(R.id.viking3),
            findViewById(R.id.viking4),
            findViewById(R.id.viking5),
            findViewById(R.id.viking6),
            findViewById(R.id.vikingplus),
            findViewById(R.id.vikingviking),
            findViewById(R.id.ej1),
            findViewById(R.id.ej2),
            findViewById(R.id.ej3),
            findViewById(R.id.ej4),
            findViewById(R.id.ej5),
            findViewById(R.id.ejt1),
            findViewById<TextView>(R.id.ejt2))



        val ejNappi = findViewById<Button>(R.id.eurojaska)
        val ejPallot = listOf(
            findViewById(R.id.ej1),
            findViewById(R.id.ej2),
            findViewById(R.id.ej3),
            findViewById(R.id.ej4),
            findViewById<TextView>(R.id.ej5))
        val ejTahtiPallot = listOf(
            findViewById(R.id.ejt1),
            findViewById<TextView>(R.id.ejt2))

        lottoNappi.setOnClickListener {
            val tehty = Toast.makeText(this, "Lotto numerot arvottu", Toast.LENGTH_SHORT)
            tehty.show()
            val lottoNumerot = luoLottoNumerot(8, 1, 40)
            lottoNumerot.forEachIndexed { index, number ->
                lottoPallot[index].text = number.toString()

            }
        }
        ejNappi.setOnClickListener {
            val tehty = Toast.makeText(this, "Eurojackpot numerot arvottu", Toast.LENGTH_SHORT)
            tehty.show()
            val ejNumerot = luoEJNumerot(5, 1, 50)
            ejNumerot.forEachIndexed { index, number ->
                ejPallot[index].text = number.toString()
                val ejTahti = luoEJtahti(2, 1, 12)
                ejTahti.forEachIndexed { index, number ->
                    ejTahtiPallot[index].text = number.toString()
            }
        }}

        vikingNappi.setOnClickListener {
            val tehty = Toast.makeText(this, "Vikinglotto numerot arvottu", Toast.LENGTH_SHORT)
            tehty.show()
            val vikingNumerot = luoVikingNumerot(7, 1, 48)
            vikingNumerot.forEachIndexed { index, number ->
                vikingPallot[index].text = number.toString()
                val vikingNumero = luoVikingViking(1, 1, 5)
                vikingNumero.forEachIndexed { index, number ->
                    vikingViking[index].text = number.toString()
            }
        }}

        tyhjennaNappi.setOnClickListener {
            val tehty = Toast.makeText(this, "Arvotut numerot tyhjennetty", Toast.LENGTH_SHORT)
            tehty.show()
            tyhjennaPallot.forEachIndexed(){ index, textView ->
                tyhjennaPallot[index].text = ""
            }
        }

        molemmatNappi.setOnClickListener {
            val tehty = Toast.makeText(this, "Kaikki numerot arvottu", Toast.LENGTH_SHORT)
            tehty.show()
            val lottoNumerot = luoLottoNumerot(8, 1, 40)
            lottoNumerot.forEachIndexed { index, number ->
                lottoPallot[index].text = number.toString()
                val vikingNumerot = luoVikingNumerot(7, 1, 48)
                vikingNumerot.forEachIndexed { index, number ->
                    vikingPallot[index].text = number.toString()
                    val vikingNumero = luoVikingViking(1, 1, 5)
                    vikingNumero.forEachIndexed { index, number ->
                        vikingViking[index].text = number.toString()
                        val ejNumerot = luoEJNumerot(5, 1, 50)
                        ejNumerot.forEachIndexed { index, number ->
                            ejPallot[index].text = number.toString()
                            val ejTahti = luoEJtahti(2, 1, 12)
                            ejTahti.forEachIndexed { index, number ->
                                ejTahtiPallot[index].text = number.toString()
                            }
                        }
                    }
                }
            }
        }
    }


    fun luoLottoNumerot(count: Int, from: Int, to: Int): List<Int> {

        val lNumerot = mutableSetOf<Int>()
        while (lNumerot.size < count) {
            val lotNumero = Random.nextInt(from, to + 1)
            lNumerot.add(lotNumero)
        }
        return lNumerot.toList()
    }
    fun luoVikingNumerot(count: Int, from: Int, to: Int): List<Int> {

        val vNumerot = mutableSetOf<Int>()
        while (vNumerot.size < count) {
            val vikNumero = Random.nextInt(from, to + 1)
            vNumerot.add(vikNumero)
        }
        return vNumerot.toList()}

        fun luoVikingViking(count: Int, from: Int, to: Int): List<Int> {

            val vViking = mutableSetOf<Int>()
            while (vViking.size < count) {
                val vikNumero = Random.nextInt(from, to + 1)
                vViking.add(vikNumero)
            }
            return vViking.toList()
    }
    fun luoEJNumerot(count: Int, from: Int, to: Int): List<Int> {

        val ejNumerot = mutableSetOf<Int>()
        while (ejNumerot.size < count) {
            val ejNumero = Random.nextInt(from, to + 1)
            ejNumerot.add(ejNumero)
        }
        return ejNumerot.toList()
    }

        fun luoEJtahti(count: Int, from: Int, to: Int): List<Int> {
            val ejTahti = mutableSetOf<Int>()
            while (ejTahti.size < count) {
                val ejTahtiNumero = Random.nextInt(from, to + 1)
                ejTahti.add(ejTahtiNumero)
            }
            return ejTahti.toList()
    }
 }