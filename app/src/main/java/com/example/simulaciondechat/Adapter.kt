package com.example.simulaciondechat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simulaciondechat.fragmrnts.Fragmentchat

class Adapter( var fragment: Fragmentchat) : RecyclerView.Adapter<Adapter.ViewHold>() {

    class ViewHold(holder: View) : RecyclerView.ViewHolder(holder) {}

    var lista = fragment.lista

    override fun getItemCount() = lista.size


    override fun getItemViewType(position: Int): Int {

        var chat=lista.get(position)

        if (chat.type=="ENTRADA") return 1 else return 2
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHold {

        var vista = when(viewType) {

            1 -> LayoutInflater.from(parent.context).inflate(R.layout.itemdeentrada, parent, false)

            2 -> LayoutInflater.from(parent.context).inflate(R.layout.itemdesalida, parent, false)

            else -> LayoutInflater.from(parent.context).inflate(R.layout.itemdesalida, parent, false)
        }


        return ViewHold(vista)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        var union = holder.itemView

        var itemnum1 = union.findViewById<TextView>(R.id.itemEntrada)
        var cuadroHora = union.findViewById<TextView>(R.id.horaentrada)

        itemnum1.text = lista.get(position).textoMensaje
        cuadroHora.text=lista.get(position).hora


    }


}