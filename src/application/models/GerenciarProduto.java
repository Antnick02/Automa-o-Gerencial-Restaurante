package application.models;

import java.util.List;
import java.util.ArrayList;

/*
 * Autor: Antonio Nicassio Santos Lima Componente Curricular: MI algoritmos e
 * programação 2 Concluido em: 10/04/2002 Declaro que este código foi elaborado
 * por mim de forma individual e não contém nenhum trecho de código de outro
 * colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que não a minha está destacado com uma citação para o autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação.
 */
/**
 * Classe para gerenciar os Produtos
 * 
 * @author Antonio Nicassio
 *
 */
public class GerenciarProduto {
	/**
	 * Atributos da classe GerenciarProduto
	 */
	private static List<Produto> produtos = new ArrayList<Produto>();
	private static int id = 0;

	/**
	 * get id da gerencia dos produtos
	 * 
	 * @return id do gerenciamento dos produtos
	 */
	public static int getIdProdutos() {
		return GerenciarProduto.id;
	}

	/**
	 * recebe um id e substitui o id antigo dos produtos
	 * 
	 * @param id
	 */
	public static void setIdProdutos(int id) {
		GerenciarProduto.id = id;
	}

	/**
	 * Função que retorna a lista de produtos do gerenciamento
	 * 
	 * @return Lista de produtos
	 */
	public static List<Produto> getProdutos() {
		return GerenciarProduto.produtos;
	}

	public static void setProdutos(List<Produto> produtos) {
		GerenciarProduto.produtos = produtos;
	}

	/**
	 * Função que recebe um objeto do tipo produto e adiciona na lista de produto do
	 * gerenciamento
	 * 
	 * @param produto
	 */
	public static void adicionarProduto(Produto produto) {

		int id = GerenciarProduto.getIdProdutos();
		List<Produto> produtos = getProdutos();
		produto.setIdProduto(id);
		produtos.add(produto);
		id++;
		setIdProdutos(id);

	}

	/**
	 * Função estatica que de busca binária, criada com base no código deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posição caso encontre o objeto, e caso não encontre retorna -1
	 * 
	 * @param id
	 * @param produtos
	 * @param tamanho
	 * @return posição do objeto ou -1
	 */
	public static int buscaProduto(int id, List<Produto> produtos, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Produto produto;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			produto = produtos.get(posMeio);

			if ((produto.getIdProduto()) == id) {
				return posMeio;
			} else {
				if ((produto.getIdProduto()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((produto.getIdProduto()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Função que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * produtos do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirProduto(int id) {

		List<Produto> produtos = GerenciarProduto.getProdutos();
		int tamanho = produtos.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Produto produto;
				produto = produtos.get(0);
				if (id == (produto.getIdProduto())) {
					produtos.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarProduto.buscaProduto(id, produtos, tamanho);

				if (resultadoBusca != -1) {
					produtos.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Função que recebe um objeto do tipo produto e partir disso busca o um objeto
	 * de mesmo id e substitui o objeto produto recebido na posição do antigo objeto
	 * do tipo produto na lista de produto do gerenciamento
	 * 
	 * @param produto
	 */
	public static void editarProduto(Produto produto) {

		int idProduto = produto.getIdProduto();
		List<Produto> produtos = getProdutos();
		int tamanho = produtos.size();
		int posicao = GerenciarProduto.buscaProduto(idProduto, produtos, tamanho);
		produtos.set(posicao, produto);
	}
}
