package br.com.dev.eficiente.nosso.mercado.livre.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptPassword {
    public String encode(String password){
        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes);
    }

    public String decode(String encrypt){
        byte[] decodedBytes = Base64.getDecoder().decode(encrypt);
        return new String(decodedBytes);
    }
}
