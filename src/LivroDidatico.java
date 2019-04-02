import java.util.Scanner;

public class LivroDidatico implements ILivro{

    private String titulo;;
    private int edicao;
    private Autor autor;
    private int QtdLD;


    public LivroDidatico(){
    }

    public String getTitulo(){ return this.titulo; }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    @Override
    public ILivro criar(Autor autor) {
        System.out.println("Informe o nome do Livro Didatico: ");
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.next();


        System.out.println("Informe a edicao do livro: ");
        Scanner scanner1 = new Scanner(System.in);
        int edicao = scanner1.nextInt();

        this.titulo = titulo;
        this.edicao = edicao;
        this.autor = autor;
       return this;
    }

    @Override
    public ILivro editar() {
        System.out.println("Informe outro nome: ");
        Scanner scanner = new Scanner(System.in);
        String NovoN = scanner.next();
        this.titulo = NovoN;

        System.out.println("Informe á edicao: ");
        int NovoE = scanner.nextInt();
        this.edicao = NovoE;
        return this;    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public void imprimir(){
        System.out.println("\n Livro Didatico");
        System.out.println("\t Titulo: " + this.titulo);
        System.out.println("\t Edicao: " + this.edicao);
        System.out.println("\t Autor: " + this.autor.getNome());
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getQtdLD() { return QtdLD; }

    public void setQtdLD(int qtdLD) { QtdLD = qtdLD; }
}
