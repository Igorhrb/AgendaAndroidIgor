package com.example.agenda.dao;

import com.example.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {


    private static List<Contato> contatos = new ArrayList<Contato>();

    public void salvar(Contato contato) {
        contatos.add(contato);
    }

    public static List<Contato> listar() {
        return new ArrayList<>(contatos);

    }

}
