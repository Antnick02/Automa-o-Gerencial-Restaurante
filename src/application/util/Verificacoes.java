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
import application.models.Ingrediente;
import application.models.Prato;
import application.models.Produto;
import application.models.Usuario;
import application.models.Venda;
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
public class Verificacoes {

	/**
	 * Função que verifica se a string de número recebido é realmente um número int
	 * retornando true se sim e false se não
	 * 
	 * @param num
	 * @return true ou false
	 */
	public static boolean verificaConversaoNumeroInt(String num) {

		int num2;
		boolean continuar = false;

		try {
			num2 = Integer.parseInt(num);
			continuar = true;
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função responsavél por identificar se o id passado existe na lista de
	 * usuários, caso exista retorna true se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdUsuario(int id) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios();
		boolean existe = false;

		for (Usuario usuario : usuarios) {
			if (usuario.getIdUsuario() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função responsavél por identificar se o id passado existe na lista de
	 * clientes, caso exista retorna true se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdCliente(int id) {

		List<Cliente> clientes = new ArrayList<>();
		clientes = GerenciarCliente.getClientes();
		boolean existe = false;

		for (Cliente cliente : clientes) {
			if (cliente.getIdCliente() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função que recebe um id de um usuário e verifica se o id é um inteiro e se o
	 * id existe na lista de usuários, caso atenda os requisitos retorna verdadeiro,
	 * se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaIdUsuario(String id) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdUsuario(id2) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que verifica se a string de número recebido é realmente um número
	 * double retornando true se sim e false se não
	 * 
	 * @param num
	 * @return true ou false
	 */
	public static boolean verificaConversaoNumeroDouble(String num) {

		double num2;
		boolean continuar = false;

		try {
			num2 = Double.parseDouble(num);
			continuar = true;
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que verifica se a string de número recebido é realmente um número
	 * float retornando true se sim e false se não
	 * 
	 * @param num
	 * @return true ou false
	 */
	public static boolean verificaConversaoNumeroFloat(String num) {

		float num2;
		boolean continuar = false;

		try {
			num2 = Float.parseFloat(num);
			continuar = true;
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id de um produto e verifica se o id é um inteiro e se o
	 * id existe na lista de produtos, caso atenda os requisitos retorna verdadeiro,
	 * se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaIdProduto(String id) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdProduto(id2) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função responsavél por identificar se o id passado existe na lista de
	 * produtos, caso exista retorna true se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdProduto(int id) {

		List<Produto> produtos = new ArrayList<>();
		produtos = GerenciarProduto.getProdutos();
		boolean existe = false;

		for (Produto produto : produtos) {
			if (produto.getIdProduto() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função que recebe um id de fornecedor e verifica se o id pode se tornar um
	 * número e se ele existe na lita de fornecedores ou é igual a -1, retornando
	 * true caso atenda os requisitos e false se não
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaIdFornecedor(String id) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdFornecedor(id2) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id e verifica se ele existe na lista de fornecedores
	 * retornando true se existir e false se não
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdFornecedor(int id) {

		List<Fornecedor> fornecedores = new ArrayList<>();
		fornecedores = GerenciarFornecedor.getFornecedores();
		boolean existe = false;

		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getIdFornecedor() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função que recebe um id de um produto e verifica se o id é um inteiro ,se o
	 * id existe na lista de produtos(Gerenciador), ou é igual a -1 caso atenda os
	 * requisitos e o id não existir na lista de id's de produtos do fornecedor
	 * retorna true, se não retorna false
	 * 
	 * @param id
	 * @param produtos
	 * @return true ou false
	 */
	public static boolean verificaAdicaoIdProdutoFornecedor(String id, List<Integer> produtos) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdProduto(id2) | id.equals("-1")) {
				continuar = true;
				for (int id3 : produtos) {
					if (id3 == id2) {
						continuar = false;
					}
				}
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id de um Cliente e verifica se o id é um inteiro e se o
	 * id existe na lista de clientes, caso atenda os requisitos retorna verdadeiro,
	 * se não retorna false
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaIdCliente(String id) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdCliente(id2) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id e verifica se ele existe na lista de pratos
	 * retornando true se existir e false se não
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdPrato(int id) {

		List<Prato> pratos = new ArrayList<>();
		pratos = GerenciarPrato.getPratos();
		boolean existe = false;

		for (Prato prato : pratos) {
			if (prato.getIdPrato() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função que recebe um id de prato e verifica se o id pode se tornar um número
	 * e se ele existe na lita de fornecedores ou é igual a -1, retornando true caso
	 * atenda os requisitos e false se não
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaIdPrato(String id) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdPrato(id2) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id de um produto e verifica se o id é um inteiro ,se o
	 * id existe na lista de produtos(Gerenciador), ou é igual a -1 caso atenda os
	 * requisitos e o id não existir na lista dos id's de produto dos ingredientes
	 * retorna true, se não retorna false
	 * 
	 * @param id
	 * @param produtos
	 * @return true ou false
	 */
	public static boolean verificaAdicaoIdProdutoIngrediente(String id, List<Ingrediente> ingredientes) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdProduto(id2) | id.equals("-1")) {
				continuar = true;
				for (Ingrediente ingrediente : ingredientes) {
					if (ingrediente.getIdProduto() == id2) {
						continuar = false;
					}
				}
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id de uma venda e verifica se o id é um inteiro e se o
	 * id existe na lista de vendas recebida, caso atenda os requisitos retorna
	 * verdadeiro, se não retorna false
	 * 
	 * @param id e vendas
	 * @return true ou false
	 */
	public static boolean verificaIdVenda(String id, List<Venda> vendas) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdVenda(id2, vendas) | id.equals("-1")) {
				continuar = true;
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função responsavél por identificar se o id passado existe na lista de vendas
	 * recebida, caso exista retorna true se não retorna false
	 * 
	 * @param id e vendas
	 * @return true ou false
	 */
	public static boolean verificaExistenciaIdVenda(int id, List<Venda> vendas) {

		boolean existe = false;

		for (Venda venda : vendas) {
			if (venda.getIdVenda() == id) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Função que recebe um id de um item(prato) e verifica se o id é um inteiro ,se
	 * o id existe na lista de pratos(Gerenciador), se é igual a -1 , e se tem
	 * quantidade o suficiente do produto para fazer o prato que será adicionado a
	 * venda caso atenda os requisitos e retorna true, se não retorna false
	 * 
	 * @param id
	 * @param itens
	 * @return true ou false
	 */
	public static boolean verificaAdicaoIdItensVenda(String id) {

		int id2;
		boolean continuar = false;
		int posicao;
		int idProduto;
		double quantidade;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdPrato(id2) | id.equals("-1")) {
				continuar = true;
				posicao = GerenciarPrato.buscaPrato(id2, GerenciarPrato.getPratos(), GerenciarPrato.getPratos().size());
				Prato prato = GerenciarPrato.getPratos().get(posicao);
				for (Ingrediente ingrediente : prato.getComposicao()) {
					idProduto = ingrediente.getIdProduto();
					for (Produto produto : GerenciarProduto.getProdutos()) {
						if (produto.getIdProduto() == idProduto) {
							quantidade = ingrediente.getQuantidade();
							if (quantidade <= produto.getQuantidadeProduto()) {
								continuar = true;
							}
						}
					}
				}
			}
		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * Função que recebe um id de prato e verifica se tem quantidade de produtos
	 * necessária para confecção do mesmo
	 * 
	 * @param id
	 * @return true ou false
	 */
	public static boolean verificaReducao(int id) {

		boolean continuar = false;
		int posicao;
		double quantidade;
		int idProduto;

		posicao = GerenciarPrato.buscaPrato(id, GerenciarPrato.getPratos(), GerenciarPrato.getPratos().size());
		Prato prato = GerenciarPrato.getPratos().get(posicao);
		for (Ingrediente ingrediente : prato.getComposicao()) {
			idProduto = ingrediente.getIdProduto();
			for (Produto produto : GerenciarProduto.getProdutos()) {
				if (produto.getIdProduto() == idProduto) {
					System.out.println("entrou1");
					quantidade = ingrediente.getQuantidade();
					if (quantidade <= produto.getQuantidadeProduto()) {

						continuar = true;
					}
				}
			}
		}

		return continuar;
	}

	/**
	 * Função que recebe um id de produto e verifica se o id pode se tornar um
	 * número e se ele existe na lista de produtos, se é igual a -1, e se não existe
	 * na em algum ingrediente da lista de pratos, retornando true caso atenda os
	 * requisitos e false se não
	 * 
	 * @param id e vendas
	 * @return true ou false
	 */
	public static boolean verificaExclusaoIdProduto(String id, List<Prato> pratos) {

		int id2;
		boolean continuar = false;

		try {
			id2 = Integer.parseInt(id);
			if (verificaExistenciaIdProduto(id2) | id.equals("-1")) {
				continuar = true;
			}
			for (Prato prato : pratos) {

				for (Ingrediente ingrediente : prato.getComposicao()) {

					if (ingrediente.getIdProduto() == id2) {
						continuar = false;
					}
				}
			}

		} catch (NumberFormatException e) {

		}

		return continuar;
	}

	/**
	 * *Função que recebe um id de um produto e verifica se o id é um inteiro , se o
	 * id existe na lista de produtos(Gerenciador), se igual a -1 e se o id existe
	 * na lista de id's de produtos dos fornecedores caso atenda os requisitos
	 * retorna true, se não retorna false
	 * 
	 * @param id
	 * @param produtos
	 * @return true ou false
	 */
	public static boolean verificaExclusaoIdProdutoFornecedor(String id, List<Fornecedor> fornecedores) {

		int id2;
		boolean continuar = false;
		for (Fornecedor fornecedor : fornecedores) {
			List<Integer>produtos = fornecedor.getProdutos();
			try {
				id2 = Integer.parseInt(id);
				if (verificaExistenciaIdProduto(id2) | id2 == -1) {
					if (id2 == -1) {
						continuar = true;
					}
					for (int id3 : produtos) {
						if (id3 == id2 | id2 == -1) {
							continuar = true;
						}
					}
				}
			} catch (NumberFormatException e) {

			}

		} 
		return continuar;
	} 
	
	/**
	 * Função que recebe um id de prato e verifica se o 
	 * id pode se tornar um número e se ele existe na lista 
	 * de pratos, se é igual a -1, e se não existe 
	 * na lista de vendas , retornando true 
	 * caso atenda os requisitos e false se não
	 * @param id e vendas
	 * @return true ou false
	 */
	public static boolean verificaExclusaoIdPrato(String id, List<Venda>vendas) {
		
		int id2; 
		boolean continuar = false;
		
		try {
			id2 = Integer.parseInt(id);
			if(verificaExistenciaIdPrato(id2) | id.equals("-1")) {
				continuar = true;
			}
			for(Venda venda : vendas) {
				
				for(int id3 : venda.getItens()) {
					
					if(id3 == id2) {
						continuar = false;
					}
				}
			}
			
		}catch (NumberFormatException e) {
			
		}
		
		return continuar;
	}
	 
	
	/**
	 * Função que recebe um id de Cliente e verifica se o 
	 * id pode se tornar um número e se ele existe na lista 
	 * de Clinetes, se é igual a -1, e se não existe 
	 * na lista de vendas , retornando true 
	 * caso atenda os requisitos e false se não
	 * @param id e vendas
	 * @return true ou false
	 */
	public static boolean verificaExclusaoIdCliente(String id, List<Venda>vendas) {
		
		int id2; 
		boolean continuar = false;
		
		try {
			id2 = Integer.parseInt(id);
			if(verificaExistenciaIdCliente(id2) | id.equals("-1")) {
				continuar = true;
			}
			for(Venda venda : vendas) {
					
					if(venda.getIdCliente() == id2) {
						continuar = false;
				
				}
			}
			
		}catch (NumberFormatException e) {
			
		}
		
		return continuar;
	}
}
