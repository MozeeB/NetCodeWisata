package com.example.cryptocoin.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocoin.R
import com.example.cryptocoin.itemview.WisataItemView
import com.example.cryptocoin.network.RemoteConfig
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val adapterWisata = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getWisata()

        setupRv()

    }

    private fun getWisata() {
        val service = RemoteConfig.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        //Do something with response e.g show to the UI.
                        response.body()?.data?.map {
                            adapterWisata.add(WisataItemView(it))
                        }

                    } else {
//                        toast("Error: ${response.code()}")
                    }
                } catch (e: HttpException) {
//                    toast("Exception ${e.message}")
                } catch (e: Throwable) {
//                    toast("Ooops: Something else went wrong")
            }
        }
    }
}

private fun setupRv() {
    val linearLayout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    rvWisata.apply {
        layoutManager = linearLayout
        adapter = adapterWisata
    }
}

}
