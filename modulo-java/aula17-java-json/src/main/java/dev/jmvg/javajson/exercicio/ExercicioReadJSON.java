package dev.jmvg.javajson.exercicio;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ExercicioReadJSON {
    public static void main(String[] args)
    {
        //Instancia um novo parse json para ler o arquivo abaixo
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/java/dev/jmvg/javajson/exercicio/employees.json"))
        {
            //É passado os dados do arquivo para um objeto genérico
            Object obj = jsonParser.parse(reader);

            //Aqui é feito um cast indicando que o Object é do tipo JSONArray
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Itera-se sobre o JSONArray fazendo o parse de cada um
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Pega o objeto employee da lista
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Pega o atributo de employee firstname
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Pega o atributo de employee lastName
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Pega o atributo de employee website
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
}
