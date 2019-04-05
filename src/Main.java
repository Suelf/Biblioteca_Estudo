import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<ILivro> acervo = new ArrayList<ILivro>();
    public static ArrayList<Autor> escritores = new ArrayList<Autor>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BEM VINDO A BIBLIOTECA");
        System.out.println("Já possui uma conta ou deseja se registrar?");
        System.out.println("Infome 1 para registrar");
        System.out.println("2 se já possui uma conta");
        int ler = scanner.nextInt();
        if (ler == 1){
            System.out.println("Informe o nome de Usuario");
            Scanner scanner1 = new Scanner(System.in);
            String senha = scanner1.next();
            Usuario usuario = new Usuario();
            


        }

        while(true){
            MostrarMenu();
            String iniciar = scanner.next();
            switch (iniciar){
                case "1":
                    CadastrarAutor();
                    break;
                case "2":
                    CadastrarLivro();
                    break;
                case "3":
                    EditarLivro();
                    break;
                case "4":
                    RemoverLivro();
                    break;
                case "5":
                    BuscarLivro();
                    break;
                case "6":
                    ListarLivros();
                    break;
                case "7":
                    Autores();
                    break;
                case "8":
                    QtdLivros();
                    break;
                default:
                    System.err.println("Opção incorreta! Digite novamente!!!");
            }
        }
    }

    private static void MostrarMenu() {


        System.out.println("˜˜˜˜˜˜˜ MENU ˜˜˜˜˜˜˜˜˜˜˜˜");
        System.out.println();
        System.out.println("1 - CADASTRAR AUTOR.");
        System.out.println("2 - CADASTRAR LIVRO");
        System.out.println("3 - EDITAR LIVROS");
        System.out.println("4 - REMOVER LIVROS.");
        System.out.println("5 - BUSCAR LIVROS .");
        System.out.println("6 -  LISTA DE LIVROS");
        System.out.println("7 -  AUTORES");
        System.out.println("8 - QUANTIDADE DE LIVROS DIDATICO/LITERARIO");
        System.out.println();
        System.out.println("˜˜˜˜˜˜˜ MENU ˜˜˜˜˜˜˜˜˜˜˜˜");
        System.out.print("Digite uma opção: ");
    }
    private static void CadastrarAutor(){
        System.out.println("˜˜˜˜˜CADASTRO DE AUTORES˜˜˜˜˜");
        System.out.println();
        System.out.println("Informe o nome do autor: ");
        Scanner scanne = new Scanner(System.in);
        String nome = scanne.next();

        Autor novoAutor = new Autor(nome);
        escritores.add(novoAutor);
    }

    private static void CadastrarLivro(){

        System.out.println("˜˜˜˜˜CADASTRO DE LIVROS˜˜˜˜˜");
        System.out.println();


        System.out.println("Informe o nome do Autor: ");
        Scanner scanner2 = new Scanner(System.in);
        String autorNome = scanner2.next();

        Autor autor = BuscarAutor(autorNome);
        if(autor == null){
            System.err.println("Autor nao existe!!");
            return;
        }

        System.out.println("Digite o tipo do livro: ");
        System.out.println("1 - Para Didatico");
        System.out.println("2 - Para Literario");
        int tipo = scanner2.nextInt();
        ILivro novoLivro ;

        switch (tipo){
            case 1:
                novoLivro = new LivroDidatico();
                LivroDidatico livroD = new LivroDidatico();
                livroD.setQtdLD(livroD.getQtdLD() + 1);
                break;
            case 2:
                novoLivro = new LivroLiterario();
                LivroLiterario livroL = new LivroLiterario();
                livroL.setQtdLL(livroL.getQtdLL() + 1);
                break;
            default:
                System.out.println("TIPO NAO ENCONTRADO!");
                return;
        }

        novoLivro.criar(autor);
        autor.setQtdObras(autor.getQtdObras() + 1);
        acervo.add(novoLivro);
        System.out.println("˜˜˜˜˜   LIVRO CADASTRADO!!   ˜˜˜˜˜");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void ListarLivros(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("˜˜˜˜˜˜˜LISTA DE LIVROS˜˜˜˜˜˜");
        for (int i= 0; i < acervo.size(); i++){
            ILivro livroDidatico = acervo.get(i);
            livroDidatico.imprimir();
        }
        System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");

    }

    private static void EditarLivro() {
        System.out.println("˜˜˜˜˜˜˜ EDICAO DE LIVROS ˜˜˜˜˜˜˜˜˜˜˜˜");
        System.out.println("Informe o nome do livro que deseja editar: ");
        Scanner scanner = new Scanner(System.in);
        String le = scanner.next();
        ILivro encontrado = BuscarLivro(le);
        if(encontrado != null){
            encontrado.editar();
        }else{
            System.err.println("LivroDidatico nao existe!!");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void RemoverLivro(){
        System.out.println("˜˜˜˜˜LIXEIRA˜˜˜˜˜˜˜˜˜");
        System.out.println("Informe  o nome do livro que deseja remover: ");
        Scanner scanner = new Scanner(System.in);
        String nl = scanner.next();
        ILivro encontrado = BuscarLivro(nl);
        if (encontrado != null){
            acervo.remove(encontrado);
            Autor autor = new Autor("remove");
            autor.setQtdObras(autor.getQtdObras() - 1);
        }else{
            System.err.println("Livro nao encontrado!");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void BuscarLivro(){
        System.out.println("˜˜˜˜˜˜˜ BUSCA DE LIVROS ˜˜˜˜˜˜˜˜˜˜˜˜");
        System.out.println("Informe o titulo do livro: ");
        Scanner scanner = new Scanner(System.in);
        String nlivro = scanner.next();
        ILivro encontrado = BuscarLivro(nlivro);
        if (encontrado != null){
            encontrado.imprimir();
        }else{
            System.err.println("Livro nao existe!!");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static void Autores(){
        System.out.println("˜˜˜˜AUTORES DE OBRAS˜˜˜˜");

        for (int i=0; i < escritores.size(); i++) {
            Autor a = escritores.get(i);
            System.out.println("\tAutor: "+a.getNome()+ " Obras: "+a.getQtdObras() );
        }

        System.out.println();
        System.out.println();
    }

    public static ILivro BuscarLivro(String nlivro) {
        ILivro livroEncontrado = null;
        for (int i = 0; i < acervo.size(); i++) {
            ILivro budega = acervo.get(i);
            if( budega.getTitulo().equals(nlivro)) {
                livroEncontrado = budega;
                break;
            }
        }
        return livroEncontrado;
    }


    public static Autor BuscarAutor(String nome) {
        Autor autorEncontrado = null;
        for (int i = 0; i < escritores.size(); i++) {
            Autor budega = escritores.get(i);
            if( budega.getNome().equals(nome)) {
                autorEncontrado = budega;
                break;
            }
        }
        return autorEncontrado;
    }

    public static void QtdLivros(){

        System.out.println("    QUANTIDADE DE LIVROS");
        System.out.println();
        LivroDidatico LivroD = new LivroDidatico();
        System.out.println("Livros Didatico: "+ LivroD.getQtdLD());
        LivroLiterario LivroL = new LivroLiterario();
        System.out.println("Livros Literario: "+ LivroL.getQtdLL());

    }
}
