package com.miempresa.a16dic


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_albums.*


class AlbumsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }
    companion object {
        fun newInstance(): AlbumsFragment = AlbumsFragment()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sList = arrayListOf("Album x", "Album y","Album z","Album x", "Album y","Album z",
            "Album x", "Album w","Album z","Album x", "Album y","Album z")

        val adapter = GenAdapter(activity!!.applicationContext,sList,"album")
        lv.adapter = adapter
    }



}
