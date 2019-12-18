package com.miempresa.a16dic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.accion_basica.view.*


class GenAdapter(private val context: Context,
   private val dataSource: ArrayList<String>, private val tipo: String)
    : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getCount(): Int {
        return dataSource.size
    }


    override fun getItem(position: Int): Any {
        return dataSource[position]
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item


        val datos:String = getItem(position) as String



        val rowView = inflater.inflate(R.layout.accion_basica, parent, false)

        rowView.title1.text= datos

        when(tipo){
            "song"->{
                rowView.img.setImageResource(R.drawable.ic_music)
            }
            "album"->{
                rowView.img.setImageResource(R.drawable.ic_album)

            }
            "artist"->{
                rowView.img.setImageResource(R.drawable.ic_person)
            }
        }


        return rowView
    }
}