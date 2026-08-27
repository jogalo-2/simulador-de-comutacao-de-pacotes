public class Pacote {
    private int id;
    private String origem;
    private String destino;
    private String conteudo;

    public Pacote (int id, String origem, String destino, String conteudo){
        this.id= id;
        this.destino=destino;
        this.origem = origem;
        this.conteudo=conteudo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString(){
        return "Pacote" + id + " [ " + origem + " -> " + destino +" ] " + conteudo;
    }
}
