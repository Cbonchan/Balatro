package Modelo.Factories;

import Modelo.SistemaCartas.Activables.Joker.*;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.AumentarChips;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MultiplicacionMult;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.SistemaPuntaje.Multiplicador;

public class JokerFactory {

    public static Joker crearJoker(String nombre, String descripcion, String grupoActivacion, int incrementador, Multiplicador multiplicador, String activacion){
        if (grupoActivacion.equals("Mano Jugada")){
            if (incrementador > 1){
                return new PorJugada(nombre, descripcion, incrementador, multiplicador, activacion, new SumarPuntaje());
            } else{
                return new PorJugada(nombre, descripcion, incrementador, multiplicador, activacion, new MultiplicacionMult());

            }
        } else if (grupoActivacion.equals("1 en")){
            int probabilidad = Integer.parseInt(activacion);
            if (incrementador > 1){
                return new UnoEn(nombre, descripcion, incrementador, multiplicador, probabilidad, new SumarPuntaje());
            } else{
                return new UnoEn(nombre, descripcion, incrementador, multiplicador, probabilidad, new MultiplicacionMult());
            }
        }
        else if (grupoActivacion.equals("Descarte")){
            if (incrementador > 1){
                return new Descarte(nombre, descripcion, incrementador, multiplicador, new AumentarChips());
            } else {
                return new Descarte(nombre, descripcion, incrementador, multiplicador, new MultiplicacionMult());
            }
        }
        else {
            if (incrementador > 1){
                return new AlPuntaje(nombre, descripcion, incrementador, multiplicador, activacion, new SumarPuntaje());
            } else if( incrementador == 1) {
                return new AlPuntaje(nombre, descripcion, incrementador, multiplicador, activacion, new MultiplicacionMult());
            } else {
                throw new RuntimeException("Efecto invalido");
            }

        }


    }
}
