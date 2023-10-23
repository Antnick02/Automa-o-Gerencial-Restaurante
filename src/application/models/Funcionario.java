package application.models;

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
 * Classe para cria��o de funcionario que � filha da classe Usuario
 * 
 * @author Antonio Nicassio
 *
 */
public class Funcionario extends Usuario {
	/**
	 * Construtor da classe Funcionario
	 * 
	 * @param login
	 * @param senha
	 */
	public Funcionario(String login, String senha) {
		/**
		 * Met�do que pega o construtor da classe Usu�rio e coloca na classe Funcionario
		 */
		super(login, senha);
	}
}
