package dev.jmvg.javajson.exercicio;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class ExercicioJSONWriter {
    public static void main( String[] args )
    {
        //Instancia um novo objeto do tipo JSON, é criando um map, chave - valor dos detalhes de employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        //É criado um Employee com os dados do JSON acima
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Da mesma forma do primeiro exemplo, é criado os detalhes do segundo Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //É criado duas listas com os dados do primeiro e segundo Employee
        JSONArray employeeList = new JSONArray();
        employeeList.put(employeeObject);
        employeeList.put(employeeObject2);

        //É criado um arquivo do tipo JSO
        try (FileWriter file = new FileWriter("src/main/java/dev/jmvg/javajson/exercicio/employees.json")) {
            //Aqui é escrito no arquivo os dados das duas listas, juntando as duas em um só arquivo com o nome de employees.js
            file.write(String.valueOf(employeeList));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
