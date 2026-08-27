import java.util.ArrayList;
public class Simulador {
    private ArrayList<Pacote> pacotes = new ArrayList<>();
    public void adicionar(Pacote pacote){
        pacotes.add(pacote);
    }
    public void enviar(){
        if (pacotes.size()>0){
            System.out.println(pacotes.get(0));
            pacotes.remove(0);
        }
    }
    public void mostrar(){
        System.out.println(pacotes);
    }
}
