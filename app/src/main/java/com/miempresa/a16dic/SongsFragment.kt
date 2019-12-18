package com.miempresa.a16dic


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_songs.*


class SongsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_songs, container, false)



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var sList = arrayListOf("Song One", "Song Two", "Song Three", "Song Four", "Song Five", "Song Six", "Song Seven",
            "Song Eight", "Song Nine", "Song Ten", "Song Eleven", "Song Twelve", "Song Thirteen")

        val adapter = GenAdapter(activity!!.applicationContext,sList,"song")
        lv.adapter = adapter
    }

    companion object {
        fun newInstance(): SongsFragment = SongsFragment()
    }




}
