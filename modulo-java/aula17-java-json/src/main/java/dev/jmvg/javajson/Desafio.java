package dev.jmvg.javajson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Desafio {
    public static void main(String[] args) throws IOException, ParseException {
        //criar um while que passe pela classe leitura e faça a leitura do json

        JSONArray desafioJSON = (JSONArray) new JSONParser().parse(new FileReader("./src/main/desafio.json"));

        List<JSONObject> jsonItem = IntStream.range(0, desafioJSON.size())
                .mapToObj(index -> (JSONObject) desafioJSON.get(index))
                .collect(Collectors.toList());

        //printando na tela
        jsonItem.forEach(pessoa -> System.out.printf("{ nome: %s, sobrenome: %s, idade: %d }\n",
                                                      pessoa.get("nome"), pessoa.get("sobrenome"), pessoa.get("idade")));


        //escrevendo num arquivo
        PrintWriter novoJson = new PrintWriter("./src/main/novoArquivo.json");
        novoJson.write(jsonItem.toString());
        novoJson.flush();
        novoJson.close();
    }
}
