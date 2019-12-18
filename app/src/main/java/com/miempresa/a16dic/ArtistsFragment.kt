package com.miempresa.a16dic


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_artists.*


class ArtistsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artists, container, false)
    }

    companion object {
        fun newInstance(): ArtistsFragment = ArtistsFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sList = arrayListOf("Artista J", "Artista E","Artista A","Artista N","Artista J", "Artista E","Artista A","Artista N",
            "Artista J", "Artista E","Artista A","Artista N")

        val adapter = GenAdapter(activity!!.applicationContext,sList,"artist")
        lv.adapter = adapter
    }

}
