package application.models;

import java.util.List;
import java.util.ArrayList;

/*
 * Autor: Antonio Nicassio Santos Lima Componente Curricular: MI algoritmos e
 * programa��o 2 Concluido em: 10/04/2002 Declaro que este c�digo foi elaborado
 * por mim de forma individual e n�o cont�m nenhum trecho de c�digo de outro
 * colega ou de outro autor, tais como provindos de livros e apostilas, e
 * p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo de
 * outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a
 * fonte do c�digo, e estou ciente que estes trechos n�o ser�o considerados para
 * fins de avalia��o.
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
	 * Fun��o que retorna a lista de produtos do gerenciamento
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
	 * Fun��o que recebe um objeto do tipo produto e adiciona na lista de produto do
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
	 * Fun��o estatica que de busca bin�ria, criada com base no c�digo deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posi��o caso encontre o objeto, e caso n�o encontre retorna -1
	 * 
	 * @param id
	 * @param produtos
	 * @param tamanho
	 * @return posi��o do objeto ou -1
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
	 * Fun��o que recebe o id do objeto, e remove o objeto de mesmo id na lista de
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
	 * Fun��o que recebe um objeto do tipo produto e partir disso busca o um objeto
	 * de mesmo id e substitui o objeto produto recebido na posi��o do antigo objeto
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
