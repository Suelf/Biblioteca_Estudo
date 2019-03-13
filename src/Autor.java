public class Autor{

    private String nome;
    private int qtdObras;


    public Autor (String nome){
    this.nome = nome;
    this.qtdObras = 0;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String autor) {
        this.nome = autor;
    }

    public int getQtdObras() {
        return qtdObras;
    }

    public void setQtdObras(int qtdObras) {
        this.qtdObras = qtdObras;
    }

    public void imprimir() {
        System.out.println("\tAutor: "+this.nome+ " Obras: "+this.qtdObras);
    }
}
