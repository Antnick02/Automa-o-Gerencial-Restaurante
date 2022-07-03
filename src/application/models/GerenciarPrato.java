package application.models;

import java.util.List;

import java.util.ArrayList;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 10/04/2002
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
/**
 * Classe para gerenciar os Pratos
 * 
 * @author Antonio Nicassio
 *
 */
public class GerenciarPrato {
	/**
	 * Atributos da classe GerenciarPrato
	 */
	private static List<Prato> pratos = new ArrayList<Prato>();
	private static int id = 0;

	/**
	 * get id da gerencia dos pratos
	 * 
	 * @return id do gerenciamento dos pratos
	 */
	public static int getIdPratos() {
		return GerenciarPrato.id;
	}

	/**
	 * recebe um id e substitui o id antigo dos pratos
	 * 
	 * @param id
	 */
	public static void setIdPratos(int id) {
		GerenciarPrato.id = id;
	}

	/**
	 * Função que retorna a lista de pratos do gerenciamento
	 * 
	 * @return Lista de pratos
	 */
	public static List<Prato> getPratos() {
		return GerenciarPrato.pratos;
	}

	public static void setPratos(List<Prato> pratos) {
		GerenciarPrato.pratos = pratos;
	}

	/**
	 * Função que recebe um objeto do tipo prato e adiciona na lista de pratos do
	 * gerenciamento
	 * 
	 * @param prato
	 */
	public static void adicionarPrato(Prato prato) {

		int id = GerenciarPrato.getIdPratos();
		List<Prato> pratos = GerenciarPrato.getPratos();
		prato.setIdPrato(id);
		pratos.add(prato);
		id++;
		GerenciarPrato.setIdPratos(id);

	}

	/**
	 * Função estatica que de busca binária, criada com base no código deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posição caso encontre o objeto, e caso não encontre retorna -1
	 * 
	 * @param id
	 * @param pratos
	 * @param tamanho
	 * @return posição do objeto ou -1
	 */
	public static int buscaPrato(int id, List<Prato> pratos, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Prato prato;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			prato = pratos.get(posMeio);

			if ((prato.getIdPrato()) == id) {
				return posMeio;
			} else {
				if ((prato.getIdPrato()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((prato.getIdPrato()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Função que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * pratos do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirPrato(int id) {

		List<Prato> pratos = GerenciarPrato.getPratos();
		int tamanho = pratos.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Prato prato;
				prato = pratos.get(0);
				if (id == (prato.getIdPrato())) {
					pratos.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarPrato.buscaPrato(id, pratos, tamanho);

				if (resultadoBusca != -1) {
					pratos.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Função que recebe um objeto do tipo prato e partir disso busca o um objeto de
	 * mesmo id e substitui o objeto prato recebido na posição do antigo objeto do
	 * tipo prato na lista de pratos do gerenciamento
	 * 
	 * @param prato
	 */
	public static void editarProduto(Prato prato) {

		int idPrato = prato.getIdPrato();
		List<Prato> pratos = GerenciarPrato.getPratos();
		int tamanho = pratos.size();
		int posicao = GerenciarPrato.buscaPrato(idPrato, pratos, tamanho);
		pratos.set(posicao, prato);
	}
}
