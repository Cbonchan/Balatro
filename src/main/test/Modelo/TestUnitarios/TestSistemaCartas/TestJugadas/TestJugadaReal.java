package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

public class TestJugadaReal {

    // Subclase concreta de Jugada para testear
 /*   private static class TestJugadaConcreta extends Jugada {

        public TestJugadaConcreta(Chip chips, Multiplicador multiplicador) {
            super(chips, multiplicador);
        }

        @Override
        public boolean validarNombreJugada(String manoAValidar) {
            return false;
        }

        @Override
        public boolean esJugadaValida(@NotNull List<Carta> cartas) {
            return false;
        }

        @Override
        public List<Carta> cartasJugadas(@NotNull List<Carta> cartas) {
            return cartas;
        }
    }

    @Test
    public void test01CalcularPuntajeInicialCero() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(0), new Multiplicador(1));
        Puntaje puntajeInicial = new Puntaje(new Chip(0), new Multiplicador(1));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, 0); // 0 chips * 1 multiplicador
    }

    @Test
    public void test02CalcularPuntajeInicialTodoUno() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(1), new Multiplicador(1));
        Puntaje puntajeInicial = new Puntaje(new Chip(1), new Multiplicador(1));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, 2); // 1 chip * 1 multiplicador
    }

    @Test
    public void test03CalcularPuntajeInicialAlto() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(1000), new Multiplicador(5));
        Puntaje puntajeInicial = new Puntaje(new Chip(1000), new Multiplicador(5));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, 50000);
    }

    @Test
    public void test04CalcularPuntajeConMultiplicadorCero() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(100), new Multiplicador(0));
        Puntaje puntajeInicial = new Puntaje(new Chip(100), new Multiplicador(0));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, 0); // 100 chips * 0 multiplicador
    }

    @Test
    public void test05CalcularPuntajeConMultiplicadorNegativo() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(100), new Multiplicador(-1));
        Puntaje puntajeInicial = new Puntaje(new Chip(100), new Multiplicador(-1));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, 200); // 200 chips * 1multiplicador
    }

    @Test
    public void test06CalcularPuntajeConChipsNegativos() {
        // Arrange
        Jugada jugada = new TestJugadaConcreta(new Chip(-100), new Multiplicador(2));
        Puntaje puntajeInicial = new Puntaje(new Chip(-100), new Multiplicador(2));

        // Act
        int puntaje = jugada.calcularPuntaje(puntajeInicial);

        // Assert
        assertEquals(puntaje, -800); // -200 chips * 4 multiplicador
    }*/
}