package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.dao.ContatoDAO;
import com.example.agenda.model.Contato;
import com.example.agenda.service.ServiceIgor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.activity_principal_fab_adicionar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroContatos.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView view = findViewById(R.id.activity_principal_apostadores);

        ContatoDAO contatoDAO = new ContatoDAO();

        view.setAdapter(new ArrayAdapter<Contato>(MainActivity.this, android.R.layout.simple_list_item_1, contatoDAO.listar()));
    }
}