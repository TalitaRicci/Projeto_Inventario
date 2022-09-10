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
            opcao = construirMenu(gerenciar, scan);
        } while (opcao != 9);
    }

    private static int construirMenu(GerenciarInventario gerenciar, Scanner scan) {
        int opcao;
        System.out.println("MENU");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Repor Estoque");
        System.out.println("3. Retirada de Estoque");
        System.out.println("4. Listar todos os Produtos");
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
                case 3:
                    gerenciar.execRetirada(scan);
                    break;
                case 4:
                    gerenciar.execListarTodos();
                    break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
        return opcao;
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

            System.out.println("Digite o código do produto: ");
            Produto produto = getProduto(scan);

            if(produto != null){
                System.out.println("Digite a quantidade adicional: ");
                boolean correto = produto.repor(Double.parseDouble(scan.nextLine()));
                if(correto){
                    System.out.println("Adicionado com sucesso!");
                } else{
                    System.out.println("Quantidade invalida!");
                }
            } else {
                System.out.println("Produto não cadastrado!");
            }
        }

        public void execRetirada(Scanner scan){

            System.out.println("Digite o código do produto: ");
            Produto produto = getProduto(scan);

            if(produto != null){
                System.out.println("Digite a quantidade a ser removida: ");
                boolean correto = produto.remover(Double.parseDouble(scan.nextLine()));
                if(correto){
                    System.out.println("Retirado com sucesso!");
                } else{
                    System.out.println("Quantidade invalida!");
                }
            } else {
                System.out.println("Produto não cadastrado!");
            }

        }

        public void execListarTodos(){

        for (Produto produto : listaProduto){
            System.out.println(produto.toString());
            }
        }

        private Produto getProduto(Scanner scan) {
            int proc = Integer.parseInt(scan.nextLine());
            Produto produto = null;

            for(Produto p : listaProduto) {
                if (p.getProdutoCodigo() == proc) {
                    produto = p;
                    break;
                }
            }
            return produto;
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
