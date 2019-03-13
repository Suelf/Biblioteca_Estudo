public class Livro{

    private String titulo;;
    private int edicao;
    private Autor autor;


    public Livro (String titulo, int edicao){
        this.titulo = titulo;
        this.edicao = edicao;
    }

    public String getTitulo(){ return this.titulo; }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public void imprimir(){
        System.out.println("\n Livro : " + this.titulo);
        System.out.println("\t Edicao: " + this.edicao);
        System.out.println("\t Autor: " + this.autor.getNome());
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
