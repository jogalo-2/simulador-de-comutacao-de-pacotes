import java.util.ArrayList;

public class Simulador {
    private static final int CAPACIDADE_PADRAO = 10;

    private final ArrayList<Pacote> pacotes = new ArrayList<>();
    private final Perda perda = new Perda();
    private final PerdaDePacote perdaDePacote;
    private int totalPacotesPerdidos;

    public Simulador() {
        this(CAPACIDADE_PADRAO);
    }

    public Simulador(int capacidadeMaximaFila) {
        perdaDePacote = new PerdaDePacote(capacidadeMaximaFila);
    }

    public boolean adicionar(Pacote pacote) {
        pacotes.add(pacote);

        Pacote pacotePerdido = perdaDePacote.calcularPacotePerdido(pacotes);
        if (pacotePerdido == null) {
            return true;
        }

        perda.subtrairPacote(pacotes, pacotePerdido);
        totalPacotesPerdidos++;
        System.out.println("Pacote perdido por congestionamento: " + pacotePerdido);
        return false;
    }

    public boolean enviar() {
        if (pacotes.isEmpty()) {
            System.out.println("Nao ha pacotes na fila");
            return false;
        }

        Pacote pacote = pacotes.remove(0);
        System.out.println("Pacote enviado: " + pacote);
        return true;
    }

    public int getQuantidadePacotes() {
        return pacotes.size();
    }

    public int getTotalPacotesPerdidos() {
        return totalPacotesPerdidos;
    }

    public void mostrar() {
        System.out.println(pacotes);
    }
}
