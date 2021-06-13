package com.example.comandosbasicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var campoNome: EditText
    lateinit var campoEmail: TextInputEditText
    lateinit var campoResultado: TextView
    lateinit var checkBoxVerde: CheckBox
    lateinit var checkBoxVermelho: CheckBox
    lateinit var checkBoxBranco: CheckBox
    lateinit var radioButtonMasculino:RadioButton
    lateinit var radioButtonFeminino:RadioButton
    lateinit var opcaoSexo:RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNome       = findViewById(R.id.editNome)
        campoEmail      = findViewById(R.id.editEmail)
        campoResultado  = findViewById(R.id.textResultado)

        //CheckBox
        checkBoxVerde       = findViewById(R.id.checkboxVerde)
        checkBoxVermelho    = findViewById(R.id.checkboxVermelho)
        checkBoxBranco      = findViewById(R.id.checkboxBranco)

        //RadioButton
        radioButtonMasculino = findViewById(R.id.radioMaculino)
        radioButtonFeminino  = findViewById(R.id.radioFeminino)

        //RadioGroup
        opcaoSexo = findViewById(R.id.radioSexo)

        radioGroup()
    }

    fun radioGroup(){
        opcaoSexo.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioMaculino-> campoResultado.setText("Masculino Selecionado")
                R.id.radioFeminino->campoResultado.setText("Feminino Selecionado")
            }
        })
    }

    fun enviar(view: View) {
       // radioButton()
      //  checkBox()

//        val nome: String = campoNome.text.toString()
//        val email: String = campoEmail.text.toString()
//
//        campoResultado.setText("Nome: ${nome} Email: ${email}")
    }

    fun radioButton(){

        if (radioButtonMasculino.isChecked==true){
            campoResultado.setText("Sexo masculino selecionado")
        }else if(radioButtonFeminino.isChecked==true){
            campoResultado.setText("Sexo feminino selecionado")
        }else campoResultado.setText("Nenhum sexo selecionado ")

    }

    fun checkBox() {
        var texto = " "

        if (checkBoxBranco.isChecked == true) {
            texto = texto + "Branco Selecionado -"
//            texto = texto + checkBoxBranco.text+" "
        }
        if (checkBoxVerde.isChecked == true) {
            texto = texto + "Verde Selecionado - "
        }
        if (checkBoxVermelho.isChecked == true) {
            texto = texto + "Vermelho Selecionado -"
        }

        campoResultado.setText(texto)
//        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }

    fun limpar(view: View) {
        //Limpando os TextViews
        campoNome.setText("")
        campoEmail.setText("")
        campoResultado.setText("")

        //Resetando os checkBox
        checkBoxVerde.isChecked = false
        checkBoxVermelho.isChecked = false
        checkBoxBranco.isChecked = false

        //Resetando os radiogroups
        radioButtonMasculino.isChecked = false
        radioButtonFeminino.isChecked = false
    }
}