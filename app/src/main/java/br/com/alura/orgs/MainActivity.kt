package br.com.alura.orgs

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this)
        setContentView(R.layout.activity_main)


        //enviando email com texto especifico

        val userName = "João"
        val intent3 = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain" // Define o tipo de dado como texto
            putExtra(Intent.EXTRA_EMAIL, arrayOf("exemplo@email.com")) // Define o destinatário
            putExtra(Intent.EXTRA_SUBJECT, "Assunto do e-mail") // Define o assunto
            putExtra(
                Intent.EXTRA_TEXT,
                """
        Olá $userName, 
        
        Esta é uma mensagem personalizada gerada pelo nosso aplicativo.
        
        Atenciosamente,
        Equipe XYZ
        """.trimIndent()
            ) // Define o corpo do e-mail
        }

// Verificar se há aplicativos capazes de lidar com a Intent
        if (intent3.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent3, "Escolha um aplicativo de e-mail"))
        } else {
            Toast.makeText(this, "Nenhum aplicativo de e-mail encontrado", Toast.LENGTH_SHORT).show()
        }


        startActivity(intent3)
    }
}
