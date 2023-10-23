package application.util;

import java.util.ArrayList;
import java.util.List;

import application.models.Cliente;
import application.models.Fornecedor;
import application.models.GerenciarCliente;
import application.models.GerenciarFornecedor;
import application.models.GerenciarPrato;
import application.models.GerenciarProduto;
import application.models.GerenciarUsuario;
import application.models.Prato;
import application.models.Produto;
import application.models.Usuario;

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
public class Buscas {
	
	/**
	 * Função que recebe um senha e busca e retorna o id 
	 * do usuário de mesmo senha na lista de usuários 
	 * caso não exista retorna -1
	 * @param senha
	 * @return id usuário ou -1
	 */
	public static int buscaIdUsuarioSenha(String senha) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios();
		int id = -1;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getSenhaUsuario().equals(senha)) {
		    	 id = usuario.getIdUsuario();
		     }
		}
		
		return id;
		
	}
	
	/**
	 * Função que verifica se existe um mesmo login 
	 * na lista de usuários que foi passado,
	 * retornando true se existir e false se não existir
	 * @param login
	 * @return true ou false
	 */
	public static boolean buscaLogin(String login) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios(); 
		boolean existe = false;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getLoginUsuario().equals(login)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	}
	
	/*
	 * Função que recebe uma strig de senha, e retorna true
	 * se exisitr essa senha na lista de usuários e 
	 * false se não existir
	 */
	public static boolean buscaSenha(String senha) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios(); 
		boolean existe = false;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getSenhaUsuario().equals(senha)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	} 
	
	/**
	 * Função que recebe um login e busca e retorna o id 
	 * do usuário de mesmo login na lista de usuários 
	 * caso não exista retorna -1
	 * @param login
	 * @return id usuário ou -1
	 */
	public static int buscaIdUsuarioLogin(String login) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios();
		int id = -1;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getLoginUsuario().equals(login)) {
		    	 id = usuario.getIdUsuario();
		     }
		}
		
		return id;
		
	} 
	
	/**
	 * Função que verifica se existe, um mesmo nome 
	 * na lista de produtos do gerenciador, que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaNomeProduto(String nome) {
		
		List<Produto>produtos = new ArrayList<>();
		produtos = GerenciarProduto.getProdutos();
		boolean existe = false;
		
		for(Produto produto : produtos)
		{
		     if(produto.getNomeProduto().equals(nome)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	} 
	
	/**
	 * Função que verifica se existe, um mesmo email 
	 * na lista de clientes do gerenciador, que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaEmailCliente(String email) {
		
		List<Cliente>clientes = new ArrayList<>();
		clientes = GerenciarCliente.getClientes();
		boolean existe = false;
		
		for(Cliente cliente : clientes)
		{
		     if(cliente.getEmail().equals(email)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	} 
	
	/**
	 * Função que verifica se existe, um mesmo telefone
	 * na lista de clientes do gerenciador, que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaTelefoneCliente(int telefone) {
		
		List<Cliente>clientes = new ArrayList<>();
		clientes = GerenciarCliente.getClientes();
		boolean existe = false;
		
		for(Cliente cliente : clientes){ 
			Integer telefone1 = cliente.getTelefone();
			
		     if(telefone1.equals(telefone)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	} 
	
	/**
	 * Função que verifica se existe, um mesmo Cpf
	 * na lista de clientes do gerenciador, que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaCpfCliente(int cpf) {
		
		List<Cliente>clientes = new ArrayList<>();
		clientes = GerenciarCliente.getClientes();
		boolean existe = false;
		
		for(Cliente cliente : clientes){ 
			Integer cpf1 = cliente.getCpf();
			
		     if(cpf1.equals(cpf)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	}
	
	/**
	 * Função que verifica se existe, um mesmo nome 
	 * na lista de fornecedores que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaNomeFornecedor(String nome) {
		
		List<Fornecedor>fornecedores = new ArrayList<>();
		fornecedores = GerenciarFornecedor.getFornecedores(); 
		boolean existe = false;
		
		for(Fornecedor fornecedor : fornecedores)
		{
		     if(fornecedor.getNomeFornecedor().equals(nome)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	}
	
	/**
	 * Função que verifica se existe, um mesmo nome 
	 * na lista de pratos que foi passado
	 * retornando true se existir, e false se não existir
	 * @param nome
	 * @return true ou false
	 */
	public static boolean buscaNomePrato(String nome) {
		
		List<Prato>pratos = new ArrayList<>();
		pratos = GerenciarPrato.getPratos();
		boolean existe = false;
		
		for(Prato prato : pratos)
		{
		     if(prato.getNomePrato().equals(nome)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	}
	
}
