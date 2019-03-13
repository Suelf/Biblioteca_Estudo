import java.util.Scanner;

public class LivroLiterario implements ILivro{

    private Autor autor;
    private String titulo;


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public ILivro criar(Autor autor) {
        System.out.println("Informe o nome do Livro Literario: ");
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.next();

        this.titulo = titulo;
        this.autor = autor;
        return this;
    }

    @Override
    public ILivro editar() {

        System.out.println("Informe outro nome: ");
        Scanner scanner = new Scanner(System.in);
        String NovoN = scanner.next();
        this.titulo = NovoN;
        return this;
    }

    @Override
    public void imprimir() {
        System.out.println("\n Livro Literario ");
        System.out.println("\t Titulo: " + this.titulo);
        System.out.println("\t Autor: " + this.autor.getNome());
    }
}
