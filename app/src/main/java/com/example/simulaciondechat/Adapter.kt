package com.example.simulaciondechat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.simulaciondechat.fragmrnts.Fragmentchat

class Adapter( var fragment: Fragmentchat) : RecyclerView.Adapter<Adapter.ViewHold>() {

    class ViewHold(holder: View) : RecyclerView.ViewHolder(holder) {}

    var lista = fragment.lista

    override fun getItemCount() = lista.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHold(
        LayoutInflater.from(parent.context).inflate(R.layout.itemdesalida, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        var union = holder.itemView

        var itemnum1 = union.findViewById<TextView>(R.id.mensajedechat)
        var cuadroHora = union.findViewById<TextView>(R.id.horaSalida)

        itemnum1.text = lista.get(position).textoMensaje
        cuadroHora.text=lista.get(position).hora


    }


}