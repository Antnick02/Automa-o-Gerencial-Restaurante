package application.models;

import java.util.List;

import java.util.ArrayList;

/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 10/04/2002
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/
/**
 * Classe para gerenciar os vendas
 * 
 * @author Antonio Nicassio
 *
 */
public class GerenciarVenda {
	/**
	 * Atributos da classe GerenciarVenda
	 */
	private static List<Venda> vendas = new ArrayList<Venda>();
	private static List<Venda> vendasAbertas = new ArrayList<Venda>();
	private static int idAbertas = 0;
	private static int id = 0;

	/**
	 * get id da gerencia dos vendas
	 * 
	 * @return id do gerenciamento dos vendas
	 */
	public static int getIdVendas() {
		return GerenciarVenda.id;
	}

	/**
	 * get id da gerencia das vendas em averto
	 * 
	 * @return id do gerenciamento dos vendas
	 */
	public static int getIdVendasEmAberto() {
		return GerenciarVenda.idAbertas;
	}

	/**
	 * recebe um id e substitui o id antigo das vendas
	 * 
	 * @param id
	 */
	public static void setIdVendas(int id) {
		GerenciarVenda.id = id;
	}

	/**
	 * recebe um id e substitui o id antigo das vendas em aberto
	 * 
	 * @param id
	 */
	public static void setIdVendasEmAberto(int id) {
		GerenciarVenda.idAbertas = id;
	}

	/**
	 * Fun��o que retorna a lista de vendas do gerenciamento
	 * 
	 * @return Lista de vendas
	 */
	public static List<Venda> getVendas() {
		return GerenciarVenda.vendas;
	}

	/**
	 * Fun��o que retorna a lista de vendas em aberto do gerenciamento
	 * 
	 * @return Lista de vendas em aberto
	 */
	public static List<Venda> getVendasEmAberto() {
		return GerenciarVenda.vendasAbertas;
	}

	/**
	 * Fun��o que recebe um objeto do tipo venda e adiciona na lista de vendas do
	 * gerenciamento
	 * 
	 * @param venda
	 */
	public static void adicionarVenda(Venda venda) {

		int id = GerenciarVenda.getIdVendas();
		List<Venda> vendas = GerenciarVenda.getVendas();
		venda.setIdVenda(id);
		vendas.add(venda);
		id++;
		setIdVendas(id);

	}

	/**
	 * Fun��o que recebe um objeto do tipo venda e adiciona na lista de vendas em
	 * aberto do gerenciamento
	 * 
	 * @param venda
	 */
	public static void adicionarVendaEmAberto(Venda venda) {

		int id = GerenciarVenda.getIdVendasEmAberto();
		List<Venda> vendas = GerenciarVenda.getVendasEmAberto();
		venda.setIdVenda(id);
		vendas.add(venda);
		id++;
		setIdVendasEmAberto(id);

	}

	/**
	 * Fun��o estatica que de busca bin�ria, criada com base no c�digo deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posi��o caso encontre o objeto, e caso n�o encontre retorna -1
	 * 
	 * @param id
	 * @param vendas
	 * @param tamanho
	 * @return posi��o do objeto ou -1
	 */
	public static int buscaVenda(int id, List<Venda> vendas, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Venda venda;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			venda = vendas.get(posMeio);

			if ((venda.getIdVenda()) == id) {
				return posMeio;
			} else {
				if ((venda.getIdVenda()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((venda.getIdVenda()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	public static void setVendas(List<Venda> vendas) {
		GerenciarVenda.vendas = vendas;

	}

	/**
	 * Fun��o que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * vendas do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirVenda(int id) {

		List<Venda> vendas = GerenciarVenda.getVendas();
		int tamanho = vendas.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Venda venda;
				venda = vendas.get(0);
				if (id == (venda.getIdVenda())) {
					vendas.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarVenda.buscaVenda(id, vendas, tamanho);

				if (resultadoBusca != -1) {
					vendas.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Fun��o que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * vendas em aberto do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirVendaEmAberto(int id) {

		List<Venda> vendas = GerenciarVenda.getVendasEmAberto();
		int tamanho = vendas.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Venda venda;
				venda = vendas.get(0);
				if (id == (venda.getIdVenda())) {
					vendas.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarVenda.buscaVenda(id, vendas, tamanho);

				if (resultadoBusca != -1) {
					vendas.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Fun��o que recebe um objeto do tipo venda e partir disso busca o um objeto de
	 * mesmo id e substitui o objeto venda recebido na posi��o do antigo objeto do
	 * tipo venda na lista de vendas do gerenciamento
	 * 
	 * @param venda
	 */
	public static void editarVenda(Venda venda) {

		int idVenda = venda.getIdVenda();
		List<Venda> vendas = GerenciarVenda.getVendas();
		int tamanho = vendas.size();
		int posicao = GerenciarVenda.buscaVenda(idVenda, vendas, tamanho);
		vendas.set(posicao, venda);
	}

	/**
	 * Fun��o que recebe um objeto do tipo venda e partir disso busca o um objeto de
	 * mesmo id e substitui o objeto venda recebido na posi��o do antigo objeto do
	 * tipo venda na lista de vendas em aberto do gerenciamento
	 * 
	 * @param venda
	 */
	public static void editarVendaEmAberto(Venda venda) {

		int idVenda = venda.getIdVenda();
		List<Venda> vendas = GerenciarVenda.getVendasEmAberto();
		int tamanho = vendas.size();
		int posicao = GerenciarVenda.buscaVenda(idVenda, vendas, tamanho);
		vendas.set(posicao, venda);
	}
}
