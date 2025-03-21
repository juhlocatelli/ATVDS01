package Produto;

public class Produto {
    // Atributos do objeto
    private int Id;
    private String Nome;
    private String Preco;
    private String Tipo;
    private String Descricao;
    
   //Construtores:
   public Produto(){ //! Construtor Padrão (Sem parametros)
        this.Id = 0;//! O Id é uma variável inteira e vazia, por isso o 0
        this.Nome = "";
        this.Preco = "";
        this.Descricao = "";
        this.Tipo = "";
    } // Permite criar um produto vazio e definir os valores depois usando os setters. 
   // Útil quando você não tem todas as informações no momento da criação do objeto. 

    public Produto(int Id, String Nome, String Preco){ //* Construtor com ID, Nome e Preço */
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Tipo = "Não definido";
        this.Descricao = "Não definido";
    } // Permite cadastrar um produto sem precisar definir Tipo e Função no momento.
      //Evita obrigar o usuário a preencher informações que podem ser desconhecidas no início.
     // Define valores padrão ("Não definido") para os campos opcionais.

    public Produto(int Id, String Nome, String Tipo, String Funcao, String Preco){ // Construtor completo
        this.Nome = Nome;
        this.Id = Id;
        this.Preco = Preco;
        this.Tipo = Tipo;
        this.Descricao = Funcao;
        
    }

    //Definindo retornos com o get
    public int getId(){//* Como estes objetos estão privados, eles não podem ser acessados sem o get */
        return Id;
    }

    public String getNome(){
        return Nome;
    }

    public String getTipo(){
        return Tipo;
    }

    public String getDescricao(){
        return Descricao;
    }

    public String getPreco(){
        return Preco;
    }

    //Colocar um valor nos atributos com o set
    public void setId(int Id){
        this.Id = Id;
    }

    public void setNome(String Nome){
        this.Nome = Nome;
    }

    public void SetTipo(String Tipo){
        this.Tipo = Tipo;
    }

    public void SetDescricao(String Descricao){
        this.Descricao = Descricao;
    }

    public void setPreço(String Preco){
        this.Preco = Preco;
    }
    
    //Função que mostra todos os atributos do produto
    public void exibirProduto() { 
        System.out.println("\nID: " + Id);
        System.out.println("Nome: " + Nome);
        System.out.println("Tipo: " + Tipo);
        System.out.println("Função: " + Descricao);
        System.out.println("Preço: R$" + Preco);
    }
}