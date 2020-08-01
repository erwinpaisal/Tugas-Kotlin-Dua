package com.erwin.tugaskotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_detail_makanan.*
import kotlinx.android.synthetic.main.item_makanan.*

class DetailMakanan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)

        val bundle=intent.extras

        ivGambar.setImageResource(bundle!!.getInt("gambar"))
        tvNama.text = bundle.getString("nama")
        tvDeskripsi.text = bundle.getString("deskripsi")
    }
}
