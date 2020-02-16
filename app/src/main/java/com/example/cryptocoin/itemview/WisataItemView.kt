package com.example.cryptocoin.itemview

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.cryptocoin.R
import com.example.cryptocoin.model.WisataModel
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataItemView(private val wisataModel: WisataModel) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val name_wisata = viewHolder.itemView.namaTV
        val location = viewHolder.itemView.locationTV

        name_wisata.text = wisataModel.nama_tempat
        location.text = wisataModel.location

        viewHolder.itemView.setOnClickListener{
            val bundle = bundleOf("name" to name_wisata)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

    override fun getLayout(): Int = R.layout.item_wisata
}