package com.example.vinhedo.v1.util;

public class CpfUtil {

    public static String formatarCpf(String cpf) {
        var tratado = cpf.replaceAll("[^0-9]+", "");
        if (tratado.length() > 11) {
            return tratado.substring(1);
        }
        return tratado;
    }
}
