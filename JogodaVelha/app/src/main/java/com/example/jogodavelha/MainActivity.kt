package com.example.jogodavelha

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun clicarBotao(view: View){
        val botaoSelecionado = view as Button
        var ID = 0

        when (botaoSelecionado.id){
            R.id.button1 -> ID = 1
            R.id.button2 -> ID = 2
            R.id.button3 -> ID = 3
            R.id.button4 -> ID = 4
            R.id.button5 -> ID = 5
            R.id.button6 -> ID = 6
            R.id.button7 -> ID = 7
            R.id.button8 -> ID = 8
            R.id.button9 -> ID = 9
        }

       // Toast.makeText(this, "ID: " +ID, Toast.LENGTH_SHORT).show()

        jogar(ID, botaoSelecionado)
    }

    //Array para guardar as jogadas
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()

    //Ordem das jogadas
    var activityPlayer = 1

    fun jogar (ID: Int, botaoSelecionado: Button){
        if(activityPlayer==1){
            botaoSelecionado.text = "X"
            botaoSelecionado.setBackgroundColor(Color.RED)
            player1.add(ID)
            activityPlayer = 2
        } else{
            botaoSelecionado.text = "O"
            botaoSelecionado.setBackgroundColor(Color.BLUE)
            player2.add(ID)
            activityPlayer = 1
        }

        botaoSelecionado.isEnabled = false
        vitorioso()

    }

    fun vitorioso(){
        var ganhador = -1

        //Por linha
        //Linha 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            ganhador = 1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            ganhador = 2
        }

        //Linha2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            ganhador = 1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            ganhador = 2
        }

        //Linha3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            ganhador = 1
        }

        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            ganhador = 2
        }

        //Coluna1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            ganhador = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            ganhador = 2
        }

        //Coluna2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            ganhador = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            ganhador = 2
        }

        //Coluna3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            ganhador = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            ganhador = 2
        }

        //Diagonal1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            ganhador = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            ganhador = 2
        }

        //Diagonal2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            ganhador = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            ganhador = 2
        }

        
     //Ganhador
     if(ganhador != -1){
         if(ganhador==1){
             Toast.makeText(this,"Player 1 ganhou!", Toast.LENGTH_SHORT).show()
         } else{
             Toast.makeText(this,"Player 2 ganhou!", Toast.LENGTH_SHORT).show()
         }
     }

    }
}
