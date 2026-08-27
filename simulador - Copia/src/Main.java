public class Main{
    public static void main (String[]args){
        Usuario u1 = new Usuario("Pedro");
        Usuario u2 = new Usuario("keven");
        Usuario u3 = new Usuario("Nalanda");

        Simulador simulador = new Simulador();
        Pacote p1 = u1.criarPacote(1,u2,"Salve Keven");
        Pacote p2 = u2.criarPacote(2,u3,"Alou Nalanda");
        Pacote p3 = u3.criarPacote(3,u1,"atrasamos o trabalho");

        simulador.adicionar(p1);
        simulador.adicionar(p2);
        simulador.adicionar(p3);

        System.out.println("Fila inicial: ");
        simulador.mostrar();
        System.out.println("Enviando:");
        System.out.println("");
        simulador.enviar();
        System.out.println("Fila apos envio");
        simulador.mostrar();
    }
}