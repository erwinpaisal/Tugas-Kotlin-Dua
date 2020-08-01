package com.erwin.tugaskotlin2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity : AppCompatActivity() {

    val listMakanan = ArrayList<Makanan>()
    var adapter : AdapterMakanan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMakanan.add (Makanan( "Bakso", "Bakso adalah Makanan Indonesia", R.drawable.bakso))
        listMakanan.add (Makanan( "Jengkol", "Jengkol Makanan Yang Membuat Nafas Bau", R.drawable.jenkol))
        listMakanan.add (Makanan( "Mie Ayam", "Mie ayam adalah makanan yang buat gemuk", R.drawable.mie_ayam))
        listMakanan.add (Makanan( "Pizza", "Pizza adalah makanan yang buat sakit perut", R.drawable.pizza))
        listMakanan.add (Makanan( "Risol", "Risol Adalah makanan jenis gorengan", R.drawable.risoles))
        listMakanan.add (Makanan( "Sushi", "Sushi adalah makanan mentah khas negeri sakura", R.drawable.sushi))

        adapter = AdapterMakanan(this, listMakanan)
        gvListMakanan.adapter = adapter

        }

    inner class AdapterMakanan: BaseAdapter{
        var listMakanan = ArrayList<Makanan>()
        var context:Context? = null
        constructor(context: Context, listOfFood: ArrayList<Makanan>):super(){
            this.context = context
            this.listMakanan= listOfFood
        }

        override fun getView(p0: Int, pl: View?, p2: ViewGroup?): View {
            val makanan = this.listMakanan[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.item_makanan, null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener {

                val intent = Intent (context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }


    }
}
