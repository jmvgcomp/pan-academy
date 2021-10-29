package dev.jmvg.javajson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    public static void main(String[] args) throws ParseException, IOException {

        Object obj = new JSONParser().parse(new FileReader("./src/main/teste2.json"));

        JSONObject json = (JSONObject) obj;

        String nome = (String) json.get("Nome");
        String sobrenome = (String) json.get("Sobrenome");
        long idade = (long) json.get("Idade");

        System.out.printf("Nome: %s, sobrenome: %s, idade: %d", nome, sobrenome, idade);

    }
}
