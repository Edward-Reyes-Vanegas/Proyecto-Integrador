package com.mensajeriaMackaia.Model;

import java.util.Random;

public class GeneradorGuia {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public GeneradorGuia() {
    }

    public static String generar() {
        int length = 10;
        StringBuilder guia = new StringBuilder();
        Random random = new Random();
        random.ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .forEach(guia::append);
        return guia.toString();
    }
}
