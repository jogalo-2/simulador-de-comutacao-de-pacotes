public class Usuario {

    private String nome;

    public Usuario(String nome){
        this.nome=nome;

    }
    public String getNome(){
        return nome;
    }
    public Pacote criarPacote(int id, Usuario destino,String conteudo){
        return new Pacote(id,nome,destino.getNome(), conteudo);
    }
}
