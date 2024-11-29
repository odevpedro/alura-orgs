package br.com.alura.orgs

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this)
        setContentView(R.layout.activity_main)

        //Abrindo link especifico com o navegador
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com"))
        startActivity(intent)

        //abrindo aplicação de mensagem com o texto
        val intent2 = Intent(Intent.ACTION_SEND)
        intent2.setType("text/plain")
        intent2.putExtra(Intent.EXTRA_TEXT, "Olá, isso é uma mensagem!")
        startActivity(Intent.createChooser(intent, "Compartilhar via"))


        //envio de email
        val intent3 = Intent(Intent.ACTION_SENDTO)
        intent3.setData(Uri.parse("mailto:exemplo@email.com"))
        intent3.putExtra(Intent.EXTRA_SUBJECT, "Assunto do e-mail")
        intent3.putExtra(Intent.EXTRA_TEXT, "Corpo do e-mail")
        startActivity(intent3)


    }
}
