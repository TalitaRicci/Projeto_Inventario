package cli;

import model.Produto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarInventario {
    public List<Produto> listaProduto = new ArrayList<>();
    public static void main(String[] args) {
        GerenciarInventario gerenciar = new GerenciarInventario();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("MENU");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Repor Estoque");
            System.out.println("3. Retirada de Estoque");
            System.out.println("4. Listar Produto Por Codigo");
            System.out.println("5. Listar todos os Produtos");
            System.out.println("9. Sair");
            System.out.println("Digite sua opcao: ");
            opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1:
                    gerenciar.execCadastrarProduto(scan);
                    break;
                case 2:
                    gerenciar.execReposicao(scan);
                    break;
//                case 3:
//                    gerenciar.execRetirada(scan);
//                    break;
//                case 4:
//                    gerenciar.execListarCodigo(scan);
//                    break;
//                case 5:
//                    gerenciar.execListarTodos();
//                    break;
                case 9:
                    System.out.println("FIM");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 9);
    }
        public void execCadastrarProduto(Scanner scan) {
                Produto produto = new Produto();
            System.out.println("Digite o código do produto: ");
            int codigo = Integer.parseInt(scan.nextLine());

            if(!codigoExiste(codigo)){
                produto.setProdutoCodigo(codigo);
            }else{
                System.out.println("Código já existente!");
                return;
            }

            System.out.println("Digite o nome do produto: ");
            produto.setNome(scan.nextLine());
            System.out.println("Digite o valor do produto: ");
            produto.setValor(Double.parseDouble(scan.nextLine()));
            System.out.println("Digite a quantidade: ");
            produto.setQuantidade(Double.parseDouble(scan.nextLine()));
            System.out.println("Digite a marca do produto:" );
            produto.setMarca(scan.nextLine());

            listaProduto.add(produto);
            System.out.println("Produto cadastrado com sucesso");
        }

        public void execReposicao(Scanner scan){
        
        }

    private boolean codigoExiste(int codigo) {
        for (Produto produto : listaProduto){
            if(produto.getProdutoCodigo() == codigo){
                return true;
            }
        }
        return false;
    }
}
