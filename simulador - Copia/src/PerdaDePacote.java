import java.util.List;

public class PerdaDePacote {
    private final int capacidadeMaximaFila;

    public PerdaDePacote(int capacidadeMaximaFila) {
        if (capacidadeMaximaFila <= 0) {
            throw new IllegalArgumentException("A capacidade da fila deve ser maior que zero");
        }

        this.capacidadeMaximaFila = capacidadeMaximaFila;
    }

    public Pacote calcularPacotePerdido(List<Pacote> pacotes) {
        if (pacotes.size() <= capacidadeMaximaFila) {
            return null;
        }

        // Tail Drop: em caso de congestionamento, o pacote mais recente e perdido.
        return pacotes.get(pacotes.size() - 1);
    }
}
