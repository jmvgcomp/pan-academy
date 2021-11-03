package dev.jmvg.javajson.exercicio;

import org.json.*;

import java.util.HashMap;
import java.util.Map;

public class ExercicioJson {
    public static void main(String[] args) throws JSONException {

        JSONObjectToArray();
        JSONExampleArray1();
        JSONExampleArray2();
        JSONExampleStringer();
        JSONExampleObject1();
        JSONExampleObject2();
        JSONExampleObject3();
        JSONExamplWriter();

    }
    private static void JSONExampleArray1() throws JSONException {
        //É criado um JSON Object a partir de uma String, utilizando uma matriz com JSONArray

        //É declarado um array na String simulado um JSON
        String arrayStr =
                "["+"true,"+"false,"+ "\"true\","+ "\"false\","+"\"hello\","+"23.45e-4,"+
                        "\"23.45\","+"42,"+"\"43\","+"["+"\"world\""+"],"+
                        "{"+
                        "\"key1\":\"value1\","+
                        "\"key2\":\"value2\","+
                        "\"key3\":\"value3\","+
                        "\"key4\":\"value4\""+
                        "},"+
                        "0,"+"\"-1\""+
                        "]";

        //Inicialização do JSONArray passando o arrayString no construtor
        JSONArray array = new JSONArray(arrayStr);
        System.out.println("Values array: "+ array);

        //Convertemos esse array em um JSONObject, mas primeiro, precisamos das labels, portanto,
        //precisamos de outro JSONArray com as labels.

        //Aqui, usaremos uma função auxiliar para obter uma para o exemplo.
        JSONArray list = listNumberArray(array.length());
        System.out.println("Label Array: "+ list.toString());

        //Agora, construímos o JSONObject usando o array de valor e o array de label.
        JSONObject object = array.toJSONObject(list);
        System.out.println("Final JSONOBject: " + object);
    }

    //O método cria um JSONArray de labels nos quais aqueles são gerados por suas posições

    private static JSONArray listNumberArray(int max){
        JSONArray res = new JSONArray();
        for (int i=0; i<max;i++) {
            //O valor das labels deve ser uma string para que funcione
            res.put(String.valueOf(i));
        }
        return res;
    }

    private static void JSONExampleArray2() throws JSONException {

        //Também podemos criar um Array sem String criando um array vazio e adicionando elementos a ele

        JSONArray array = new JSONArray();

        array.put("value");
        array.put(5);
        array.put(-23.45e67);
        array.put(true);

        //Nós o convertemos em JSONObject fornecendo um array de labels como da última vez

        JSONArray list = listNumberArray(array.length());
        JSONObject object = array.toJSONObject(list);
        System.out.println("Final JSONOBject: " + object);
    }

    private static void JSONExampleStringer() throws JSONException {

        //Instanciando o jsonStringer

        JSONStringer jsonStringer = new JSONStringer();

        //Agora começamos o processo de adição de elementos com .object()

        jsonStringer.object();

        //Agora podemos adicionar elementos como chaves e valores com .values() e .key()

        jsonStringer.key("trueValue").value(true);
        jsonStringer.key("falseValue").value(false);
        jsonStringer.key("nullValue").value(null);
        jsonStringer.key("stringValue").value("hello world!");
        jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
        jsonStringer.key("intValue").value(42);
        jsonStringer.key("doubleValue").value(-23.45e67);

        //Terminamos com .endObject

        jsonStringer.endObject();

        //Uma vez que temos um JSONStringer, nós o convertemos em JSONObject gerando uma String e usando o construtor JSONObject.

        String str = jsonStringer.toString();
        JSONObject jsonObject = new JSONObject(str);

        System.out.println("Final JSONOBject: " + jsonObject);
    }

    private static void JSONExampleObject1() throws JSONException {

        //Podemos criar um JSONObject a partir de uma String com o construtor de classes

        String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
        JSONObject example = new JSONObject(string);
        System.out.println("Final JSONObject: " + example);

    }

    private static void JSONExampleObject2() throws JSONException {

        //Também podemos criar um JSONObject diretamente, sem mexer com nenhuma das outras funções.
        //Abaixo é instanciando um novo JSONObject
        JSONObject example = new JSONObject();


        //Agora adicionamos as chaves e valores de maneira semelhante ao método Stringer
        example.put("key", "value");

        //A primeira entrada é a chave e a segunda seria seu valor associado.

        example.put("key2", 5);
        example.put("key3", -23.45e67);
        example.put("trueValue", true);

        //Não podemos adicionar valores nulos, pensamos

        //example.put("nullValue", null); //Isso não é possível

        System.out.println("Final JSONOBject: " + example);
    }

    private static void JSONExampleObject3() {

        //Também podemos criar um JSONObject com um Java Map
        //Você precisará de um mapa cujas chaves são Strings. Os valores podem ser o que você quiser

        Map<String,Double> map = new HashMap<>();

        map.put("key1", 1.0);
        map.put("key2", -23.45e67);

        //Criamos o JSONObject com o map no seu construtor de classe

        JSONObject example = new JSONObject(map);
        System.out.println("Final JSONOBject: " + example);
    }

    private static void JSONExampleTokener() throws JSONException {

        //A partir de uma String, podemos criar um JSONTokener, que podemos usar alternativamente para JSONArray, JSONObject

        String string = "this is not a valid JSON string";
        JSONTokener token = new JSONTokener(string);

        //Agora você pode usar o token em JSONObject e Array da mesma forma que um String

        JSONObject object = new JSONObject(token);
        JSONArray array = new JSONArray(token);

    }

    private static void JSONObjectToArray() throws JSONException {
        //Começamos com um JSONObject

        String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";

        JSONObject example = new JSONObject(string);

        //Precisamos de uma lista de strings de chave como a operação reversa

        JSONArray keyStrings = listNumberArray(example.length());

        //Em seguida, convertemos para o Array usando os dois elementos

        JSONArray array = example.toJSONArray(keyStrings);

        System.out.println("Final JSONArray: " + array);
    }

    private static void JSONExamplWriter() {

        //Instancia um StringBuild e passa como dependencia no JSONWriter
        StringBuilder write = new StringBuilder();
        JSONWriter jsonWriter = new JSONWriter(write);

        //Comportamento semelhante ao stringBuilder abaixo

        jsonWriter.object();

        jsonWriter.key("trueValue").value(true);
        jsonWriter.key("falseValue").value(false);
        jsonWriter.key("nullValue").value(null);
        jsonWriter.key("stringValue").value("hello world!");
        jsonWriter.key("complexStringValue").value("h\be\tllo w\u1234orld!");
        jsonWriter.key("intValue").value(42);
        jsonWriter.key("doubleValue").value(-23.45e67);

        jsonWriter.endObject();

        //O resultado deve estar no objeto "write"

        System.out.println("JSON: " + write.toString());

        //A diferença é que não obtemos um JSONObject neste.


    }

}
