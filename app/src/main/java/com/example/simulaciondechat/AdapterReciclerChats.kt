package com.example.simulaciondechat

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterReciclerChats ( var lista:ArrayList<ContactosDelChat>) :RecyclerView.Adapter<AdapterReciclerChats.MiViewHolder>(){


    var clikItem: (item : ContactosDelChat,posicion:Int)->Unit={ item, posicion -> }




    class MiViewHolder(vista:View) :RecyclerView.ViewHolder(vista){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {

        var vistaInflada=LayoutInflater.from(parent.context).inflate(R.layout.item_de_chat,parent,false)
        return MiViewHolder(vistaInflada)
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {

        var ChatDeLaLista = lista.get(position)



        var nombrecontactoDeChat=holder.itemView.findViewById<TextView>(R.id.tvNombreItem)
        var ultimoMesajeDeChat=holder.itemView.findViewById<TextView>(R.id.tvUltimoMensaje)


        nombrecontactoDeChat.text=ChatDeLaLista.Nombre
        ultimoMesajeDeChat.text=ChatDeLaLista.ultimoMensaje


        holder.itemView.setOnClickListener(){
            clikItem(ChatDeLaLista,position)
        }

    }

    override fun getItemCount(): Int {
        var cantidadDeItem=lista.size
        return cantidadDeItem
    }


}