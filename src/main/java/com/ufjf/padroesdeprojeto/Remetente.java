package com.ufjf.padroesdeprojeto;

import java.util.Observable;
import java.util.Observer;

public class Remetente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Remetente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void iniciarRastreamento(Transporte transporte) {
        transporte.addObserver(this);
    }

    @Override
    public void update(Observable transporte, Object arg) {
        this.ultimaNotificacao = "Remetente " + nome + ": Rastreamento da carga - " +  transporte.toString();

    }
}
