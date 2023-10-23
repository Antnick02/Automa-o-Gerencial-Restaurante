package application.models;

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
 * Classe para criação de funcionario que é filha da classe Usuario
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
		 * Metódo que pega o construtor da classe Usuário e coloca na classe Funcionario
		 */
		super(login, senha);
	}
}
