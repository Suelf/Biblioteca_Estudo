import javax.accessibility.AccessibleExtendedText;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static ArrayList<Livro> acervo = new ArrayList<Livro>();
    public static ArrayList<Autor> escritores = new ArrayList<Autor>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Informe o nome do Livro: ");
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.next();


        System.out.println("Informe a edicao do livro: ");
        Scanner scanner1 = new Scanner(System.in);
        int edicao = scanner1.nextInt();

        System.out.println("Informe o nome do Autor: ");
        Scanner scanner2 = new Scanner(System.in);
        String autorNome = scanner2.next();

        Autor autor = BuscarAutor(autorNome);
        if(autor == null){
            System.err.println("Autor nao existe!!");
            return;
        }

        Livro novoLivro = new Livro(titulo, edicao);
        novoLivro.setAutor(autor);

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
            Livro livro = acervo.get(i);
            livro.imprimir();
        }
        System.out.println("˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");

    }

    private static void EditarLivro() {
        System.out.println("˜˜˜˜˜˜˜ EDICAO DE LIVROS ˜˜˜˜˜˜˜˜˜˜˜˜");
        System.out.println("Informe o nome do livro que deseja editar: ");
        Scanner scanner = new Scanner(System.in);
        String le = scanner.next();
        Livro encontrado = BuscarLivro(le);
        if(encontrado != null){
            System.out.println("Informe outro nome: ");
            scanner = new Scanner(System.in);
            String NovoN = scanner.next();
            encontrado.setTitulo(NovoN);

            System.out.println("Informe á edicao: ");
            int NovoE = scanner.nextInt();
            encontrado.setEdicao(NovoE);
        }else{
            System.err.println("Livro nao existe!!");
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
        Livro encontrado = BuscarLivro(nl);
        if (encontrado != null){
            acervo.remove(encontrado);
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
        Livro encontrado = BuscarLivro(nlivro);
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

    public static Livro BuscarLivro(String nlivro) {
        Livro livroEncontrado = null;
        for (int i = 0; i < acervo.size(); i++) {
            Livro budega = acervo.get(i);
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
}