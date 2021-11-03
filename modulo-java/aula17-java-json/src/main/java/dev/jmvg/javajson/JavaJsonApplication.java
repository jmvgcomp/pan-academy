package dev.jmvg.javajson;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SpringBootApplication
public class JavaJsonApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(JavaJsonApplication.class, args);

        JSONObject json = new JSONObject();

        json.put("Nome", "Julio");
        json.put("Sobrenome", "Smith");
        json.put("Idade", 25);
        json.put("Nome", "Julio");
        json.put("Sobrenome", "Smith");
        json.put("idade", 25);

        System.out.println(json);

        PrintWriter salvar = new PrintWriter("./src/main/teste2.json");
        salvar.write(json.toJSONString());
        salvar.flush();
        salvar.close();

    }

}
