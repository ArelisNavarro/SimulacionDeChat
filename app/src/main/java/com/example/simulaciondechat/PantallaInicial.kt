package com.example.simulaciondechat

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.TextWatcherAdapter
import java.text.FieldPosition

class PantallaInicial : Fragment(){


    lateinit var recicler:RecyclerView

     lateinit var manager: FragmentManager

     lateinit var editextBuscar:EditText


    var lista= arrayListOf<ContactosDelChat>(

        ContactosDelChat(1,"Eric",""),
        ContactosDelChat(2,"Ediego",""),
        ContactosDelChat(3,"EYilbert",""),
        ContactosDelChat(4,"EMami",""),
        ContactosDelChat(5,"Eluis",""),
        ContactosDelChat(6,"Ejuana",""),
        ContactosDelChat(7,"adriana",""),
        ContactosDelChat(8,"wey",""),
        ContactosDelChat(9,"eeric",""),
        ContactosDelChat(10,"edwion","")
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

        var adaptador=AdapterReciclerChats()

        var layaout=LinearLayoutManager(context,RecyclerView.VERTICAL,false)


        recicler=view.findViewById<RecyclerView>(R.id.rvReciclerChats)

        editextBuscar =view.findViewById<EditText>(R.id.searchView)

        adaptador.setListaContactos(lista)

        var listener=object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


            }

            override fun afterTextChanged(s: Editable?) {
                      var lista=  lista.filter { i -> i.Nombre.lowercase().contains(s.toString().lowercase()) }
                adaptador.setListaContactos(lista)

            }

        }

            editextBuscar.addTextChangedListener(listener)

        recicler.adapter=adaptador

        recicler.layoutManager=layaout

        recicler.addItemDecoration(DividerItemDecoration(context,RecyclerView.HORIZONTAL))

        adaptador.clikItem = {item, posicion -> irAlChat(item,posicion,"hola")}



    }



    fun irAlChat(item:ContactosDelChat,position: Int,hola:String){

        var fragmento:Fragment=BlackFragment()

        manager= requireActivity().supportFragmentManager

       var transition=manager?.beginTransaction()
        transition?.replace(R.id.contenedorDeFragment,fragmento)
        transition.addToBackStack(null)
        transition.commit()

    }


}