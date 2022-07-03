package application.models;

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
 * Classe para criação de Usuario
 * 
 * @author Antonio Nicassio
 *
 */
public class Usuario {
	/**
	 * Atributos da classe Usuario
	 */
	private int id;
	private String login;
	private String senha;

	/**
	 * Construtor para o objeto Usuario, que é feito sem a passagem do id tendo pré
	 * setado o id como -1, que será modificado ao ser adicionado no gerenciador de
	 * vendas
	 * 
	 * @param login
	 * @param senha
	 */
	public Usuario(String login, String senha) {
		this.id = -1;
		this.login = login;
		this.senha = senha;
	}

	/**
	 * get id do Usuario
	 * 
	 * @return id do usuario
	 */
	public int getIdUsuario() {
		return this.id;
	}

	/**
	 * get login do Usuario
	 * 
	 * @return login do usuario
	 */
	public String getLoginUsuario() {
		return this.login;
	}

	/**
	 * get senha do usuario
	 * 
	 * @return senha do usuario
	 */
	public String getSenhaUsuario() {
		return this.senha;
	}

	/**
	 * set id do Usuario
	 * 
	 * @param id do usuario
	 */
	public void setIdUsuario(int id) {
		this.id = id;
	}

	/**
	 * set login do usuario
	 * 
	 * @param login
	 */
	public void setLoginUsuario(String login) {
		this.login = login;
	}

	/**
	 * set senha do usuario
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
