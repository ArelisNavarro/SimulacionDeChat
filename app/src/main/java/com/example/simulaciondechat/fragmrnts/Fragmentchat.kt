package com.example.simulaciondechat.fragmrnts

import android.icu.number.FormattedNumber
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulaciondechat.Adapter
import com.example.simulaciondechat.R
import java.text.SimpleDateFormat
import java.util.*


class Fragmentchat : Fragment() {

    var lista= arrayListOf<Mensajes> (

        Mensajes("ERIC","10:00 PM","SALIDA","HEY USTEDES MONGOLOS"),
        Mensajes("ARELIS","11:00 PM","ENTRADA","SERAS TU"),
        Mensajes("DIEGO","11:30 PM","ENTRADA","NO TU TAMBIEN"),
        Mensajes("MAMI","10:00 AM","ENTRADA","QUE MIJO"),
        Mensajes("ABUELA","10:30 AM","SALIDA","CALLENSE"),
        Mensajes("LUIS","10:05 PM","SALIDA","QUE PASA MONGOLO")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_fragmentchat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recicle=view.findViewById<RecyclerView>(R.id.reciclador)
        var botonEnviar=view.findViewById<Button>(R.id.btEnviar)
        /*var botonAtras=view.findViewById<RecyclerView>(R.id.volveratras)
        var btSiguienteContacto=view.findViewById<RecyclerView>(R.id.siguienteContacto)
        var NameContac=view.findViewById<RecyclerView>(R.id.nomDelcontacto)*/
        var agregar=view.findViewById<EditText>(R.id.editexDemensaje)


        var manager= LinearLayoutManager(context,RecyclerView.VERTICAL, false)
        var objetoadaptador= Adapter(fragment = Fragmentchat())
        recicle.layoutManager=manager
        recicle.addItemDecoration(DividerItemDecoration(context,RecyclerView.HORIZONTAL))

        recicle.adapter=objetoadaptador

        var putalista=objetoadaptador.lista





        botonEnviar.setOnClickListener {

            var textosacado=agregar.text

            if (textosacado.isBlank() || textosacado.isEmpty()){
                agregar.error="No puedes enviAR EN BLANCO"

            }else{

                val calendar = Calendar.getInstance()

                val dateFormat = SimpleDateFormat("HH:MM:SS", Locale.getDefault())
                var hora =dateFormat.format(calendar.time)

                var newMensagge=Mensajes("ERIC",hora,"SALIDA",textosacado.toString())

                putalista.add(newMensagge)

                objetoadaptador.notifyDataSetChanged()

                agregar.setText("")

            }

        }
    }

    }




