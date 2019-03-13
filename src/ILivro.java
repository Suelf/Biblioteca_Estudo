public interface ILivro {
    public void imprimir();
    public String getTitulo();
    public void setTitulo(String novoTitulo);
    public ILivro criar(Autor autor);
    public ILivro editar();
}
