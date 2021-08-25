package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.dao.ContatoDAO;
import com.example.agenda.model.Contato;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastroContatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);

        Button buttonCadastrar = findViewById(R.id.activity_cadastro_button_cadastrar);

        buttonCadastrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contato = new Contato();

                EditText nome = findViewById(R.id.activity_cadastro_nome);
                EditText endereco = findViewById(R.id.activity_cadastro_endereco);
                EditText telefone = findViewById(R.id.activity_cadastro_telefone);
                EditText aniversario = findViewById(R.id.activity_cadastro_aniversario);

                if (nome != null && nome.getText() != null && !nome.getText().toString().equals("")) {
                    contato.setNome(nome.getText().toString());
                    contato.setTelefone(telefone.getText().toString());
                    contato.setEndereco(endereco.getText().toString());
                    if(aniversario != null &&
                            aniversario.getText() != null &&
                            !aniversario.getText().toString().equals("")) {

                        try {
                            contato.setAniversario(new SimpleDateFormat("dd/MM/yyy").parse(aniversario.getText().toString()));

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }

                    ContatoDAO contatoDAO = new ContatoDAO();
                    contatoDAO.salvar(contato);

                    finish();

                } else {
                    Toast.makeText(CadastroContatos.this, "Adicione o nome do contato", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}