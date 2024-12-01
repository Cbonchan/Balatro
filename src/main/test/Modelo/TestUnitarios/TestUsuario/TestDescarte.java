package Modelo.TestUnitarios.TestUsuario;

public class TestDescarte {

    /*

    @Test
    public void test01descartoCartasYelJugadorTieneMenos() {
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        Carta carta3 = new Carta(new Corazon(), new Tres());
        Carta carta4 = new Carta(new Corazon(), new Cuatro());
        Carta carta5 = new Carta(new Corazon(), new Cinco());
        Carta carta6 = new Carta(new Corazon(), new Seis());
        Carta carta7 = new Carta(new Corazon(), new Siete());
        Carta carta8 = new Carta(new Corazon(), new Ocho());

        List<Carta> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jugador.descartarMano();
        assertEquals(6, jugador.getCantidadCartas());
    }

    @Test
    public void test02pilaDeDescarteAumentaTamañoAlDescartar() {
        Mano mano = new Mano();
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        PilaDescarte pilaDescarte = new PilaDescarte();

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        pilaDescarte.descartarMano(mano);

        assertEquals(1, pilaDescarte.cantidadManosDescartadas());
    }

    @Test
    public void test03reinsertarEnMazoAumentaElTamaño(){
        Mazo mazo = new Mazo();

        Mano mano = new Mano();
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        PilaDescarte pilaDescarte = new PilaDescarte();

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        pilaDescarte.descartarMano(mano);
        pilaDescarte.reinsertarEnMazo(mazo);
        assertEquals(54, mazo.getCartasDisponibles());

    }

    @Test
    public void test04descartoAlJugarDescartaLasCartasJugadas(){
        Mano mano = new Mano();
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());

        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);

        jugador.agregarCartas(List.of(carta1, carta2));

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        jugador.jugar(tablero);

        assertEquals(8, jugador.cartasFaltantes());

    }

    @Test
    public void test05seleccionarCartasDisminuyeLasDisponibles(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        Carta carta3 = new Carta(new Corazon(), new Tres());
        Carta carta4 = new Carta(new Corazon(), new Cuatro());
        Carta carta5 = new Carta(new Corazon(), new Cinco());
        Carta carta6 = new Carta(new Corazon(), new Seis());
        Carta carta7 = new Carta(new Corazon(), new Siete());
        Carta carta8 = new Carta(new Corazon(), new Ocho());

        List<Carta> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        assertEquals(2, jugador.cartasFaltantes());
    }

    @Test
    public void test06deshacerEleccionAumentaLasDisponibles(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Corazon(), new As());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        Carta carta3 = new Carta(new Corazon(), new Tres());
        Carta carta4 = new Carta(new Corazon(), new Cuatro());
        Carta carta5 = new Carta(new Corazon(), new Cinco());
        Carta carta6 = new Carta(new Corazon(), new Seis());
        Carta carta7 = new Carta(new Corazon(), new Siete());
        Carta carta8 = new Carta(new Corazon(), new Ocho());

        List<Carta> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jugador.cancelarEleccion();

        assertEquals(0, jugador.cartasFaltantes());
    }


     */
}