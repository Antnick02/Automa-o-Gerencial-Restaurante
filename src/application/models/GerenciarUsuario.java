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
	 * Fun��o que retorna a lista de usuarios do gerenciamento
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
	 * Fun��o que recebe um objeto do tipo usuario e adiciona na lista de usuario do
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
	 * Fun��o estatica que de busca bin�ria, criada com base no c�digo deste link
	 * https://ic.unicamp.br/~mc102/aulas/aula11.pdf, em que recebe o id do objeto a
	 * ser procurado, a lista onde vai ser procurado e o tamanho da lista,e retorna
	 * a posi��o caso encontre o objeto, e caso n�o encontre retorna -1
	 * 
	 * @param id
	 * @param usuarios
	 * @param tamanho
	 * @return posi��o do objeto ou -1
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
	 * Fun��o que recebe o id do objeto, e remove o objeto de mesmo id na lista de
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
	 * Fun��o que recebe um objeto do tipo usuario e partir disso busca o um objeto
	 * de mesmo id e substitui o objeto usuario recebido na posi��o do antigo objeto
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
