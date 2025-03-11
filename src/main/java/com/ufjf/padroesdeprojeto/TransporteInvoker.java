package com.ufjf.padroesdeprojeto;

import java.util.Stack;

public class TransporteInvoker {
    private Stack<TransporteCommand> historico = new Stack<>();

    public void executarComando(TransporteCommand comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            TransporteCommand comando = historico.pop();
            comando.desfazer();
        }
    }
}