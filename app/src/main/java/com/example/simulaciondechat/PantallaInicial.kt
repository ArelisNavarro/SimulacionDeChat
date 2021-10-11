package com.example.simulaciondechat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class PantallaInicial : Fragment(){


    var lista= arrayListOf<ContactosDelChat>(

        ContactosDelChat(1,"Eric",""),
        ContactosDelChat(2,"Diego",""),
        ContactosDelChat(3,"Yilbert",""),
        ContactosDelChat(4,"Mami",""),
        ContactosDelChat(5,"luis",""),
        ContactosDelChat(6,"Eric",""),
        ContactosDelChat(7,"Eric",""),
        ContactosDelChat(8,"Eric",""),
        ContactosDelChat(9,"Eric",""),
        ContactosDelChat(10,"Eric","")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pantalla_inicial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var adaptador=AdapterReciclerChats(lista)

        var layaout=LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        var recicler=view.findViewById<RecyclerView>(R.id.rvReciclerChats)


        recicler.adapter=adaptador

        recicler.layoutManager=layaout

        adaptador.clikItem = {item, posicion -> irAlChat(item,posicion,"hola")       }
    }

    fun irAlChat(item:ContactosDelChat,position: Int,hola:String){



    }



}