package application.models;

import java.util.List;

import java.util.ArrayList;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 11/05/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
	 * Fun��o que retorna a lista de fornecedores do gerenciamento
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
	 * Fun��o que recebe um objeto do tipo fornecedor e adiciona na lista de
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
	 * Fun��o estatica que de busca bin�ria, criada com base no c�digo deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posi��o caso encontre o objeto, e caso n�o encontre retorna -1
	 * 
	 * @param id
	 * @param fornecedores
	 * @param tamanho
	 * @return posi��o do objeto ou -1
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
	 * Fun��o que recebe o id do objeto, e remove o objeto de mesmo id na lista de
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
	 * Fun��o que recebe um objeto do tipo fornecedor e partir disso busca o um
	 * objeto de mesmo id e substitui o objeto fornecedor recebido na posi��o do
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
