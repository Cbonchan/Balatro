package Modelo.Parser;

import Modelo.Factories.CartaFactory;
import Modelo.Factories.JokerFactory;
import Modelo.Juego.Ronda;
import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarCarta;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraJugada;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.Figura;
import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mazo;
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

    private static ArrayList<Activable> procesarJokers(JsonArray comodines){

        ArrayList<Activable> jokerList = new ArrayList<>();
        for (JsonElement joker: comodines){
            JsonObject jokerObject = joker.getAsJsonObject();
            String nombre = jokerObject.get("nombre").getAsString();
            String descripcion = jokerObject.get("descripcion").getAsString();

            if (!jokerObject.has("activacion")){
                ArrayList<Activable> subComodinesList = new ArrayList<>();
                JsonArray subsubcomodines = jokerObject.get("comodines").getAsJsonArray();

                subComodinesList.addAll(procesarJokers(subsubcomodines));
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
                // int multiplicador = efecto.get("multiplicador").getAsInt(); <- Viejo multiplicador
                Multiplicador multiplicador = new Multiplicador(efecto.get("multiplicador").getAsInt());

                jokerList.add(crearJokerEnFactory(nombre, descripcion, grupoActivacion, valorActivacion, puntos, multiplicador));
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

            jokerList.addAll(procesarJokers(jokers));
        }

        return jokerList;
    }

    private static Joker crearJokerEnFactory(String nombre, String descripcion, String grupoActivacion, String valorActivacion, int puntos, Multiplicador multiplicador){
        Joker nuevoJoker = JokerFactory.crearJoker(nombre, descripcion, grupoActivacion, puntos, multiplicador, valorActivacion);
        return nuevoJoker;

    }

    public static ArrayList<Activable> obtenerTarotsEnJugada(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        ArrayList<Activable> tarotList = new ArrayList<>();

        JsonArray tarotsArray = jsonObject.getAsJsonArray("tarots");


        for(JsonElement tarotElement : tarotsArray){
            JsonObject entryObject = tarotElement.getAsJsonObject();

            String nombre = entryObject.get("nombre").getAsString();
            String descripcion = entryObject.get("descripcion").getAsString();

            String sobre = entryObject.get("sobre").getAsString();
            String ejemplar = entryObject.get("ejemplar").getAsString();

            JsonObject efectos = entryObject.getAsJsonObject("efecto");

            int puntos = efectos.get("puntos").getAsInt();

            Multiplicador multiplicador = new Multiplicador(efectos.get("multiplicador").getAsInt());

            if (sobre.equals("mano")){
                tarotList.add(new MejoraJugada(nombre, descripcion, puntos, multiplicador,
                    new MejorarJugada(ejemplar)));
            }

        }
        return tarotList;
    }

    public static ArrayList<ActivableEnCarta> obtenerTarotsEnCarta(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        ArrayList<ActivableEnCarta> tarotEnCartaList = new ArrayList<>();

        JsonArray tarotsArray = jsonObject.getAsJsonArray("tarots");

        for(JsonElement tarotElement : tarotsArray){
            JsonObject entryObject = tarotElement.getAsJsonObject();

            String nombre = entryObject.get("nombre").getAsString();
            String descripcion = entryObject.get("descripcion").getAsString();

            String sobre = entryObject.get("sobre").getAsString();
            String ejemplar = entryObject.get("ejemplar").getAsString();

            JsonObject efectos = entryObject.getAsJsonObject("efecto");

            int puntos = efectos.get("puntos").getAsInt();

            Multiplicador multiplicador = new Multiplicador(efectos.get("multiplicador").getAsInt());

            if (sobre.equals("carta")){
                tarotEnCartaList.add(new MejoraCarta(nombre, descripcion, puntos, multiplicador,
                        new MejorarCarta()));
            }

        }
        return tarotEnCartaList;
    }



    public static ArrayList<Ronda> obtenerRondas(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonArray rondasArray = jsonObject.getAsJsonArray("rondas");
        ArrayList<Ronda> rondaList = new ArrayList<>();

        for (JsonElement rondaElement : rondasArray) {
            JsonObject rondaObject = rondaElement.getAsJsonObject();

            int numeroDeRonda = rondaObject.get("nro").getAsInt();
            int limiteDeManos = rondaObject.get("manos").getAsInt();
            int limiteDeDescartes = rondaObject.get("descartes").getAsInt();
            int puntajeASuperar = rondaObject.get("puntajeASuperar").getAsInt();

            // Parsear la tienda
            JsonObject tiendaObject = rondaObject.getAsJsonObject("tienda");
            Tienda tienda = procesarTienda(tiendaObject);

            // Crear la instancia de Ronda
            Ronda ronda = new Ronda(numeroDeRonda, limiteDeManos, limiteDeDescartes, puntajeASuperar, tienda);
            rondaList.add(ronda);
        }

        return rondaList;
    }

    private static Tienda procesarTienda(JsonObject tiendaObject){
        JsonArray comodinesArray = tiendaObject.getAsJsonArray("comodines");
        ArrayList<Activable> jokers = procesarJokers(comodinesArray);

        JsonArray tarotsEnJugadaArray = tiendaObject.getAsJsonArray("tarots");
        ArrayList<Activable> tarotsEnJugada = obtenerTarotsEnJugada(tarotsEnJugadaArray);

        JsonArray tarotsEnCartaArray = tiendaObject.getAsJsonArray("tarots");
        ArrayList<ActivableEnCarta> tarotsEnCarta = obtenerTarotsEnCarta(tarotsEnCartaArray);

        JsonObject cartaObject = tiendaObject.getAsJsonObject("carta");
        Carta carta = procesarCarta(cartaObject);

        return new Tienda(tarotsEnJugada, carta, tarotsEnCarta);
    }

    public static ArrayList<Activable> obtenerTarotsEnJugada(JsonArray tarotsArray) {
        ArrayList<Activable> tarotList = new ArrayList<>();

        for (JsonElement tarotElement : tarotsArray) {
            JsonObject entryObject = tarotElement.getAsJsonObject();

            String nombre = entryObject.get("nombre").getAsString();
            String descripcion = entryObject.get("descripcion").getAsString();

            String sobre = entryObject.get("sobre").getAsString();
            String ejemplar = entryObject.get("ejemplar").getAsString();

            JsonObject efectos = entryObject.getAsJsonObject("efecto");

            int puntos = efectos.get("puntos").getAsInt();
            Multiplicador multiplicador = new Multiplicador(efectos.get("multiplicador").getAsInt());

            if (sobre.equals("mano")) {
                tarotList.add(new MejoraJugada(nombre, descripcion, puntos, multiplicador, new MejorarJugada(ejemplar)));
            }
        }

        return tarotList;
    }

    public static ArrayList<ActivableEnCarta> obtenerTarotsEnCarta(JsonArray tarotsArray) {
        ArrayList<ActivableEnCarta> tarotList = new ArrayList<>();

        for (JsonElement tarotElement : tarotsArray) {
            JsonObject entryObject = tarotElement.getAsJsonObject();

            String nombre = entryObject.get("nombre").getAsString();
            String descripcion = entryObject.get("descripcion").getAsString();

            String sobre = entryObject.get("sobre").getAsString();
            String ejemplar = entryObject.get("ejemplar").getAsString();

            JsonObject efectos = entryObject.getAsJsonObject("efecto");

            int puntos = efectos.get("puntos").getAsInt();
            Multiplicador multiplicador = new Multiplicador(efectos.get("multiplicador").getAsInt());

            if (sobre.equals("carta")) {
                tarotList.add(new MejoraCarta(nombre, descripcion, puntos, multiplicador, new MejorarCarta()));
            }
        }

        return tarotList;
    }

    private static Carta procesarCarta(JsonObject cartaObject) {
        String nombre = cartaObject.get("nombre").getAsString();
        String palo = cartaObject.get("palo").getAsString();
        String figura = cartaObject.get("numero").getAsString();
        int puntos = cartaObject.get("puntos").getAsInt();
        int multiplicador = cartaObject.get("multiplicador").getAsInt();

        Carta carta = CartaFactory.crearCarta(palo, figura);

        return carta;
    }

    public static Mazo obtenerMazo(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray mazoArray = jsonObject.getAsJsonArray("mazo");
        ArrayList<Carta> cartaList = new ArrayList<>();

        for (JsonElement mazoElement : mazoArray) {
            JsonObject mazoObject = mazoElement.getAsJsonObject();

            String palo = mazoObject.get("palo").getAsString();
            String figura = mazoObject.get("numero").getAsString();

            Carta carta = CartaFactory.crearCarta(palo, figura);
            cartaList.add(carta);
        }

        return new Mazo(52, cartaList);
    }




}
