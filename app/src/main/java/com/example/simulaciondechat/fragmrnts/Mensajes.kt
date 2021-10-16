package com.example.simulaciondechat.fragmrnts

class Mensajes (

    var nombre:String,
    var hora:String,
    var type:String,
    var textoMensaje:String
        ){


    override fun toString(): String {
        return nombre+"-"+hora+"-"+type+"-"+textoMensaje
    }
}