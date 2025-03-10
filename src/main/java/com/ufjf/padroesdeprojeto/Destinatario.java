package com.ufjf.padroesdeprojeto;

import java.util.Observable;
import java.util.Observer;

public class Destinatario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Destinatario(String nome) {
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
        this.ultimaNotificacao = "Destinatário " + nome + ": Rastreamento da carga - " +  transporte.toString();

    }
}
