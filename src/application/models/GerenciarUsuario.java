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
 * Classe para gerenciar os Usuarios
 * 
 * @author Antonio Nicassio
 *
 */
public class GerenciarUsuario {
	/**
	 * Atributos da classe GerenciarUsuario
	 */
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static int id = 0;

	/**
	 * get id da gerencia dos usuarios
	 * 
	 * @return id do gerenciamento dos usuarios
	 */
	public static int getIdUsuarios() {
		return GerenciarUsuario.id;
	}

	/**
	 * recebe um id e substitui o id antigo dos usuarios
	 * 
	 * @param id
	 */
	public static void setIdUsuarios(int id) {
		GerenciarUsuario.id = id;
	}

	/**
	 * Função que retorna a lista de usuarios do gerenciamento
	 * 
	 * @return Lista de usuarios
	 */
	public static List<Usuario> getUsuarios() {
		return GerenciarUsuario.usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		GerenciarUsuario.usuarios = usuarios;
	}

	/**
	 * Função que recebe um objeto do tipo usuario e adiciona na lista de usuario do
	 * gerenciamento
	 * 
	 * @param usuario
	 */
	public static void adicionarUsuario(Usuario usuario) {

		int id = getIdUsuarios();
		List<Usuario> usuarios = GerenciarUsuario.getUsuarios();
		usuario.setIdUsuario(id);
		usuarios.add(usuario);
		id++;
		GerenciarUsuario.setIdUsuarios(id);

	}

	/**
	 * Função estatica que de busca binária, criada com base no código deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posição caso encontre o objeto, e caso não encontre retorna -1
	 * 
	 * @param id
	 * @param usuarios
	 * @param tamanho
	 * @return posição do objeto ou -1
	 */
	public static int buscaUsuario(int id, List<Usuario> usuarios, int tamanho) {

		int posInicial = 0;
		int posFinal = tamanho - 1;
		Usuario usuario;

		while (posInicial <= posFinal) {

			int posMeio = (posInicial + posFinal) / 2;
			usuario = usuarios.get(posMeio);

			if ((usuario.getIdUsuario()) == id) {
				return posMeio;
			} else {
				if ((usuario.getIdUsuario()) > id) {
					posFinal = posMeio - 1;
				} else {
					if ((usuario.getIdUsuario()) < id) {
						posInicial = posMeio + 1;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * Função que recebe o id do objeto, e remove o objeto de mesmo id na lista de
	 * usuarios do gerenciamento
	 * 
	 * @param id
	 */
	public static void excluirUsuario(int id) {

		List<Usuario> usuarios = GerenciarUsuario.getUsuarios();
		int tamanho = usuarios.size();

		if (tamanho == 0) {

		} else {
			if (tamanho == 1) {
				Usuario usuario;
				usuario = usuarios.get(0);
				if (id == (usuario.getIdUsuario())) {
					usuarios.remove(0);
				}
			} else {
				int resultadoBusca = GerenciarUsuario.buscaUsuario(id, usuarios, tamanho);

				if (resultadoBusca != -1) {
					usuarios.remove(resultadoBusca);

				}
			}

		}
	}

	/**
	 * Função que recebe um objeto do tipo usuario e partir disso busca o um objeto
	 * de mesmo id e substitui o objeto usuario recebido na posição do antigo objeto
	 * do tipo usuario na lista de usuarios do gerenciamento
	 * 
	 * @param usuario
	 */
	public static void editarUsuario(Usuario usuario) {

		int idUsuario = usuario.getIdUsuario();
		List<Usuario> usuarios = GerenciarUsuario.getUsuarios();
		int tamanho = usuarios.size();
		int posicao = GerenciarUsuario.buscaUsuario(idUsuario, usuarios, tamanho);
		usuarios.set(posicao, usuario);

	}
}
