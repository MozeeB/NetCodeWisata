package com.example.cryptocoin.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptocoin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //nerima dari fragment ke fragment
        val name  = arguments?.getString("nama")
        val location = arguments?.getString("location")
        val gambar  = arguments?.getString("gambar")
        val deskripsi = arguments?.getString("deskripsi")

//        //nerima data dari fragment ke activity
//        val nama = activity?.intent?.extras?.getString("name")
        detailNamaTV.text = name
        detailLocationTV.text = location
        detailDescriptionTV.text = deskripsi
        Picasso.get().load(gambar.toString()).into(detailIV)



    }

}
