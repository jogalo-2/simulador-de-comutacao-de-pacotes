import java.util.List;

public class Perda {
    public void subtrairPacote(List<Pacote> pacotes, Pacote pacotePerdido) {
        if (!pacotes.remove(pacotePerdido)) {
            throw new IllegalArgumentException("O pacote perdido nao esta na fila");
        }
    }
}
