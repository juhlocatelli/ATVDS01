import java.util.Scanner;
import Produto.Produto;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args ) {
        //Definindo scanner para o usuário poder digitar
        Scanner scanner = new Scanner(System.in);
        ArrayList <Produto> listaProdutos = new ArrayList<>();
        int op;
        do{
            System.out.println("\n MENU ");
            System.out.println("1 - Crie Produto");
            System.out.println("2 - Altere os dados de um produto");
            System.out.println("3 - Exclua um produto");
            System.out.println("4 - Listagem todos os produtos");
            System.out.println("5 - Sair");
            System.out.print("O que deseja fazer: ");
         op = scanner.nextInt();
         scanner.nextLine();
        // Criar produto de acordo com o que for digitado
        switch (op) {
            case 1:   
            System.out.print("Digite o ID do produto:");
            int ID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o Nome do produto:");
            String Nome = scanner.nextLine();

            System.out.print("Digite o Preço do produto: ");
            String Preco = scanner.nextLine();
        
            char Escolha;
        do{ 

            System.out.print("Deseja definir o Tipo e a Descrição do produto agora? (S/N):"); 
            Escolha = scanner.next().charAt(0);//Armazana aqui a escolha do usuário
            scanner.nextLine();

            if (Escolha != 'S' && Escolha != 's' && Escolha != 'N' && Escolha != 'n') { // Vai verificar se a pessoa quer ou não definir os produtos
                System.out.println("Opção inválida! Digite 'S' para sim ou 'N' para não.");

        }
    }  while (Escolha != 'S' && Escolha != 's' && Escolha != 'N' && Escolha != 'n'); //! Ele vai repetir o comando de cima até tiver tudo certo, ai ele vai pra proxima etapa
            
                Produto novoProduto = null;

                if (Escolha == 'S' || Escolha == 's') { //coloca, se a resposta for sim, a tipo e uma descrição
                    System.out.print("Digite o Tipo do produto:");
                    String Tipo = scanner.nextLine();
                    System.out.print("Digite a Descrição do produto:");
                    String Descricao = scanner.nextLine();

                    novoProduto = new Produto(ID, Nome, Tipo, Descricao, Preco); 
                    // Cadastro de novo produto
                }

                if(Escolha == 'n' || Escolha == 'N') {
                    novoProduto = new Produto(ID, Nome, Preco); //? Vai cadastrar sem descrição e tipo
                }
                    listaProdutos.add(novoProduto); // Adiciona a lista de Produtos/arrays
                    System.out.print("Produto Cadastrado com sucesso!!");

                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;


            case 2:
            if (listaProdutos.isEmpty()) { // Verifica se a lista está Vazia
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }


            System.out.print("Digite O ID do produto");
            int IdBuscador = scanner.nextInt();
            scanner.nextLine();

            Produto produtoEncontrado = null;
            for(Produto P : listaProdutos){ 
                if (P.getId() == IdBuscador) {
                    produtoEncontrado = P; //Caso ele Encontre vai ficar na variavel produtoEncontrado
                    break;
                }
            }

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!");  // Se ele não achar, ele vai retornar pro Menu
               break;
            }

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); // Vai mostrar o Produto, pra pessoa verificar se é o produto certo

            System.out.print("\nNovo nome (ou pressione ENTER para manter): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                produtoEncontrado.setNome(novoNome);
            }
    
            System.out.print("Novo preço (ou pressione ENTER para manter): ");
            String novoPreco = scanner.nextLine();
            if (!novoPreco.isEmpty()) {
                produtoEncontrado.setPreço(novoPreco);
            }
    
            System.out.print("Novo tipo (ou pressione ENTER para manter): ");
            String novoTipo = scanner.nextLine();
            if (!novoTipo.isEmpty()) {
                produtoEncontrado.SetTipo(novoTipo);
            }
    
            System.out.print("Nova função (ou pressione ENTER para manter): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) {
                produtoEncontrado.SetDescricao(novaDescricao);
            }
    
            System.out.println("Produto atualizado com sucesso!");

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
            break;

            case 3:
            if (listaProdutos.isEmpty()) {  //! Verifica se a lista está Vazia
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            System.out.print("Digite o ID do produto que você quer excluir:");
            IdBuscador = scanner.nextInt();
            produtoEncontrado = null;
            for(Produto P : listaProdutos){ 
                if (P.getId() == IdBuscador) {
                    produtoEncontrado = P;
                    break;
                }
            }

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!"); 
               break;
            }

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); 

            System.out.print("Você tem certeza que quer excluir esse produto? (S/N)");
            char Confirmação = scanner.next().charAt(0);

            if (Confirmação == 'S' || Confirmação == 's') { // Exclusão
                listaProdutos.remove(produtoEncontrado);
                System.out.print("Produto excluido com sucesso!!");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            else{
                System.out.print("Operação Cancelada!"); 
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            case 4:
            if (listaProdutos.isEmpty()) {
                System.out.print("Não há nenhum produto"); // Caso não tenha produto na lista
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            System.out.println("\n=== Lista de Produtos ===");
            for(Produto p:listaProdutos){ //todos os produtos da lista 
                p.exibirProduto();
            }

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
            break;

            case 5:
                System.out.println("Saindo...."); 
                break;

            default:
            System.out.println("Opção inválida! Tente novamente.");
        }

    } while(op != 5); 
        scanner.close();
    }
}
