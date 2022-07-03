package application.models;

public class Cliente {
	/**
	 * Atributos da classe Cliente
	 */
	private int id;
	private String nome;
	private int cpf;
	private String email;
	private int telefone;

	/**
	 * Construtor para o objeto Cliente, que é feito sem a passagem do id tendo pré
	 * setado o id como -1, que será modificado ao ser adicionado no gerenciador de
	 * clientes
	 * 
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param telefone
	 */
	public Cliente(String nome, int cpf, String email, int telefone) {
		this.id = -1;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * função get id cliente
	 * 
	 * @return id
	 */
	public int getIdCliente() {
		return this.id;
	}

	/**
	 * função get nome do cliente
	 * 
	 * @return nome
	 */
	public String getNomeCliente() {
		return this.nome;
	}

	/**
	 * função get cpf do cliente
	 * 
	 * @return cpf
	 */
	public int getCpf() {
		return this.cpf;
	}

	/**
	 * função get email do cliente
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * função get telefone do cliente
	 * 
	 * @return telefone
	 */
	public int getTelefone() {
		return this.telefone;
	}

	/**
	 * função set do id do cliente
	 * 
	 * @param id
	 */
	public void setIdCliente(int id) {
		this.id = id;
	}

	/**
	 * função set do nome do cliente
	 * 
	 * @param nome
	 */
	public void setNomeCliente(String nome) {
		this.nome = nome;
	}

	/**
	 * função set cpf do cliente
	 * 
	 * @param cpf
	 */
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	/**
	 * função set do email do cliente
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * função set do telefone do cliente
	 * 
	 * @param telefone
	 */
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
