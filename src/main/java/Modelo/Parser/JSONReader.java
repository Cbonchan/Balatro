package Modelo.Parser;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.CambiarMult;
import Modelo.SistemaPuntaje.Multiplicador;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Modelo.SistemaCartas.Activables.Joker.*;
import java.util.ArrayList;



import java.io.Reader;
import java.util.Map;


public class JSONReader {
    Gson gson = new Gson();

    private static JsonArray validarJSON(JsonElement jsonElement){
        JsonObject alPuntaje = jsonElement.getAsJsonObject().getAsJsonObject("Al Puntaje");

        JsonArray jokers = alPuntaje.getAsJsonArray("comodines");

        for (JsonElement joker: jokers){
            JsonObject jokerObject = joker.getAsJsonObject();

            if (!jokerObject.has("nombre")) {
                throw new IllegalArgumentException("Falta el nombre del comodín");
            }
            if (!jokerObject.has("descripcion")) {
                throw new IllegalArgumentException("Falta la descripción del comodín");
            }
            if (!jokerObject.has("activacion")) {
                throw new IllegalArgumentException("Falta la activación del comodín");
            }
            if (!jokerObject.has("efecto")) {
                throw new IllegalArgumentException("Falta el efecto del comodín");
            }

            JsonObject efecto = jokerObject.getAsJsonObject("efecto");
            if (!efecto.has("puntos")) {
                throw new IllegalArgumentException("Falta puntos en el efecto");
            }
            if (!efecto.has("multiplicador")) {
                throw new IllegalArgumentException("Falta multiplicador en el efecto");
            }
        }
        return jokers;
    }

    private static ArrayList<Activable> procesarComodines(JsonArray comodines){

        ArrayList<Activable> jokerList = new ArrayList<>();
        for (JsonElement joker: comodines){
            JsonObject jokerObject = joker.getAsJsonObject();
            String nombre = jokerObject.get("nombre").getAsString();
            String descripcion = jokerObject.get("descripcion").getAsString();

            if (!jokerObject.has("activacion")){
                ArrayList<Activable> subComodinesList = new ArrayList<>();
                JsonArray subsubcomodines = jokerObject.get("comodines").getAsJsonArray();

                subComodinesList.addAll(procesarComodines(subsubcomodines));
                jokerList.add(new Combinacion(nombre, descripcion, subComodinesList));
            } else {
                //! Verificar que no esten vacios
                String grupoActivacion = "";
                String valorActivacion = "";

                if (jokerObject.get("activacion").isJsonObject()){ //! aca falla
                    JsonObject activacionObject = jokerObject.getAsJsonObject("activacion");

                    if (activacionObject.has("Mano Jugada")){
                        grupoActivacion = "Mano Jugada";
                        valorActivacion = activacionObject.get("Mano Jugada").getAsString();
                    } else if (activacionObject.has("1 en")){
                        grupoActivacion = "1 en";
                        valorActivacion = activacionObject.get("1 en").getAsString();
                    }
                } else{
                    grupoActivacion = jokerObject.get("activacion").getAsString();
                }

                JsonObject efecto = jokerObject.getAsJsonObject("efecto");
                int puntos = efecto.get("puntos").getAsInt();
                int multiplicador = efecto.get("multiplicador").getAsInt();
                jokerList.add(parsearJoker(nombre, descripcion, grupoActivacion, valorActivacion, puntos, multiplicador));
            }

        }
        return jokerList;
    }

    public static ArrayList<Activable> obtenerJokers(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();


        ArrayList<Activable> jokerList = new ArrayList<>();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()){

            String categoria = entry.getKey();
            JsonObject entryObject = entry.getValue().getAsJsonObject();

            JsonArray jokers = entryObject.getAsJsonArray("comodines");
            //String descripcionCategoria = categoriaObject.get("descripcion").getAsString();

            //!JsonArray jokers = validarJSON(jsonElement);

            jokerList.addAll(procesarComodines(jokers));
        }

        return jokerList;
    }

    private static Joker parsearJoker(String nombre, String descripcion, String grupoActivacion, String valorActivacion, int puntos, int multiplicador){
        if (grupoActivacion.equals("Mano Jugada")){
            return new PorJugada(nombre, descripcion, puntos, new Multiplicador(multiplicador), valorActivacion, new CambiarMult());
        } else if (grupoActivacion.equals("1 en")){
            int valor = Integer.parseInt(valorActivacion);
            return new unoEn(nombre, descripcion, puntos, multiplicador, valor);

        } else {if (grupoActivacion.equals("Descarte")){
            return new Descarte(nombre, descripcion, puntos, multiplicador);
        }
            return null;

        } /*
        else {
            if (multiplicador > 1){
                return new Multiplicador(nombre, descripcion, puntos, multiplicador);
            } else if (puntos != 1){
                return new SumadorPuntaje(nombre, descripcion, puntos, multiplicador);
            } else{
                throw new RuntimeException("Efecto invalido");

            }

        }*/
    }
}

