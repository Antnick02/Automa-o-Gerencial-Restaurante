package application.models;

import java.util.List;

import java.util.ArrayList;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 11/05/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
/**
 * Classe para gerenciar os fornecedores
 * 
 * @author Antonio Nicassio
 *
 */
public class GerenciarFornecedor {
	/**
	 * Atributos da classe GerenciarFornecedor
	 */
	private static List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private static int id = 0;

	/**
	 * get id da gerencia dos fornecedores
	 * 
	 * @return id do gerenciamento dos fornecedores
	 */
	public static int getIdFornecedores() {
		return GerenciarFornecedor.id;
	}

	/**
	 * recebe um id e substitui o id antigo dos fornecedores
	 * 
	 * @param id
	 */
	public static void setIdFornecedores(int id) {
		GerenciarFornecedor.id = id;
	}

	/**
	 * Função que retorna a lista de fornecedores do gerenciamento
	 * 
	 * @return Lista de fornecedores
	 */
	public static List<Fornecedor> getFornecedores() {
		return GerenciarFornecedor.fornecedores;
	}

	public static void setFornecedores(List<Fornecedor> fornecedores) {
		GerenciarFornecedor.fornecedores = fornecedores;
	}

	/**
	 * Função que recebe um objeto do tipo fornecedor e adiciona na lista de
	 * fornecedores do gerenciamento
	 * 
	 * @param fornecedor
	 */
	public static void adicionarFornecedor(Fornecedor fornecedor) {

		int id = GerenciarFornecedor.id;
		List<Fornecedor> fornecedores = getFornecedores();
		fornecedor.setIdFornecedor(id);
		fornecedores.add(fornecedor);
		id++;
		setIdFornecedores(id);

	}

	/**
	 * Função estatica que de busca binária, criada com base no código deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posição caso encontre o objeto, e caso não encontre retorna -1
	 * 
	 * @param id
	 * @param fornecedores
	 * @param tamanho
	 * @return posição do objeto ou -1
	 */
	public static int buscaFornecedor(int id, List<Fornecedor> fornecedores, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Fornecedor fornecedor;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			fornecedor = fornecedores.get(posMeio);

			if ((fornecedor.getIdFornecedor()) == id) {
				return posMeio;
			} else {
				if ((fornecedor.getIdFornecedor()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((fornecedor.getIdFornecedor()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Função que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * fornecedores do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirFornecedor(int id) {

		List<Fornecedor> fornecedores = GerenciarFornecedor.getFornecedores();
		int tamanho = fornecedores.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Fornecedor fornecedor;
				fornecedor = fornecedores.get(0);
				if (id == (fornecedor.getIdFornecedor())) {
					fornecedores.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarFornecedor.buscaFornecedor(id, fornecedores, tamanho);

				if (resultadoBusca != -1) {
					fornecedores.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Função que recebe um objeto do tipo fornecedor e partir disso busca o um
	 * objeto de mesmo id e substitui o objeto fornecedor recebido na posição do
	 * antigo objeto do tipo fornecedor na lista de fornecedores do gerenciamento
	 * 
	 * @param fornecedor
	 */
	public static void editarFornecedor(Fornecedor fornecedor) {

		int idFornecedor = fornecedor.getIdFornecedor();
		List<Fornecedor> fornecedores = GerenciarFornecedor.getFornecedores();
		int tamanho = fornecedores.size();
		int posicao = GerenciarFornecedor.buscaFornecedor(idFornecedor, fornecedores, tamanho);
		fornecedores.set(posicao, fornecedor);
	}
}
