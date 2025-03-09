package com.ufjf.padroesdeprojeto;

import java.lang.reflect.Constructor;

public class TrasporteFactory {
    public static Transporte obterTransporte(String tipo, String origem, String destino) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = classe.forName("com.ufjf.padroesdeprojeto." + tipo);
            Constructor constructor = classe.getConstructor(String.class, String.class);
            objeto = constructor.newInstance(origem,destino);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de transporte inexistente");
        }

        if (!(objeto instanceof Transporte)) {
            throw new IllegalArgumentException("tipo de transporte invalido");
        }

        return (Transporte) objeto;
    }
}
