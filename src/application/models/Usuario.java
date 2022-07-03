package application.models;

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
 * Classe para cria��o de Usuario
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
	 * Construtor para o objeto Usuario, que � feito sem a passagem do id tendo pr�
	 * setado o id como -1, que ser� modificado ao ser adicionado no gerenciador de
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
