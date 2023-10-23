package application.models;

import java.util.List;

import java.util.ArrayList;
/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/ 
public class GerenciarCliente {
	/**
	 * Atributos da classe GerenciarCliente
	 */
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static int id = 0;

	/**
	 * get id da gerencia dos clientes
	 * 
	 * @return id do gerenciamento dos cleintes
	 */
	public static int getIdClientes() {
		return GerenciarCliente.id;
	}

	/**
	 * recebe um id e substitui o id antigo dos clientes
	 * 
	 * @param id
	 */
	public static void setIdClientes(int id) {
		GerenciarCliente.id = id;
	}

	/**
	 * Função que retorna a lista de clientes do gerenciamento
	 * 
	 * @return Lista de clientes
	 */
	public static List<Cliente> getClientes() {
		return GerenciarCliente.clientes;
	}

	/**
	 * Função que recebe um objeto do tipo cliente e adiciona na lista de clientes
	 * do gerenciamento
	 * 
	 * @param cliente
	 */
	public static void adicionarCliente(Cliente cliente) {

		int id = GerenciarCliente.id;
		List<Cliente> clientes = getClientes();
		cliente.setIdCliente(id);
		clientes.add(cliente);
		id++;
		setIdClientes(id);

	}

	/**
	 * Função estatica que de busca binária, criada com base no código deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posição caso encontre o objeto, e caso não encontre retorna -1
	 * 
	 * @param id
	 * @param clientes
	 * @param tamanho
	 * @return posição do objeto ou -1
	 */
	public static int buscaCliente(int id, List<Cliente> clientes, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Cliente cliente;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			cliente = clientes.get(posMeio);

			if ((cliente.getIdCliente()) == id) {
				return posMeio;
			} else {
				if ((cliente.getIdCliente()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((cliente.getIdCliente()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Função que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * clientes do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirCliente(int id) {

		List<Cliente> clientes = GerenciarCliente.getClientes();
		int tamanho = clientes.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Cliente cliente;
				cliente = clientes.get(0);
				if (id == (cliente.getIdCliente())) {
					clientes.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarCliente.buscaCliente(id, clientes, tamanho);

				if (resultadoBusca != -1) {
					clientes.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Função que recebe um objeto do tipo cliente e partir disso busca o um objeto
	 * de mesmo id e substitui o objeto clienterecebido na posição do antigo objeto
	 * do tipo cliente na lista de clientes do gerenciamento
	 * 
	 * @param cliente
	 */
	public static void editarClientes(Cliente cliente) {

		int idCliente = cliente.getIdCliente();
		List<Cliente> clientes = GerenciarCliente.getClientes();
		int tamanho = clientes.size();
		int posicao = GerenciarCliente.buscaCliente(idCliente, clientes, tamanho);
		clientes.set(posicao, cliente);
	} 
	
	public static void setCliente(List<Cliente>clientes) {
		GerenciarCliente.clientes = clientes;
	}

}
