package application.models;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.*;

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
 * Classe feita para a criação dos relatórios em pdf
 * 
 * @author anton
 *
 */
public class Relatorio {
	/**
	 * Função que recebe uma lista de fornecedores e gera um relatório pdf a partir
	 * dela
	 * 
	 * @param fornecedores
	 */
	public static void GerarRelatorioFornecedores(List<Fornecedor> fornecedores) {

		Document doc = new Document();

		String arquivoPdf = "RelatorioFornecedores.pdf";

		try {

			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
			String produtos = "";
			doc.open();

			Paragraph p = new Paragraph("Fornecedores");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Quantidade de Fornecedores: " + fornecedores.size());
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);

			PdfPTable table = new PdfPTable(5);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("CNPJ"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Endereço"));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Produtos"));

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);

			for (Fornecedor fornecedor : fornecedores) {

				cell1 = new PdfPCell(new Paragraph(fornecedor.getIdFornecedor() + ""));
				cell2 = new PdfPCell(new Paragraph(fornecedor.getNomeFornecedor() + ""));
				cell3 = new PdfPCell(new Paragraph(fornecedor.getCnpj() + ""));
				cell4 = new PdfPCell(new Paragraph(fornecedor.getEndereco() + ""));
				for (Fornecedor fornecedor1 : fornecedores) {
					produtos = "";
					for (int id : fornecedor1.getProdutos()) {
						produtos = produtos + "[" + id + "]";
					}
				}
				cell5 = new PdfPCell(new Paragraph(produtos + ""));

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File(arquivoPdf));

		} catch (Exception e) {

		}
	}

	/**
	 * Função que recebe uma lista de produtos e gera um arquivo pdf a partir dela
	 * 
	 * @param produtos
	 */
	public static void GerarRelatorioProdutos(List<Produto> produtos) {

		Document doc = new Document();

		String arquivoPdf = "RelatorioEstoque.pdf";

		try {

			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
			doc.open();

			Paragraph p = new Paragraph("Estoque");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Quantidade de Produtos: " + produtos.size());
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);

			PdfPTable table = new PdfPTable(4);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Quantidade"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Validade"));

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);

			for (Produto produto : produtos) {

				cell1 = new PdfPCell(new Paragraph(produto.getIdProduto() + ""));
				cell2 = new PdfPCell(new Paragraph(produto.getNomeProduto() + ""));
				cell3 = new PdfPCell(new Paragraph(produto.getQuantidadeProduto() + ""));
				cell4 = new PdfPCell(new Paragraph(produto.getValidade()));

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File(arquivoPdf));

		} catch (Exception e) {

		}
	}

	/**
	 * Função que recebe uma lista de vendas e ger um relatório a partir dela
	 * 
	 * @param vendas
	 * @param pratos
	 * @param preco
	 */
	public static void GerarRelatorioVendas(List<Venda> vendas, int pratos, float preco) {

		Document doc = new Document();
		String data;
		String itens = "";
		int quantidadePratos = 0;

		String arquivoPdf = "RelatorioVendas.pdf";

		try {

			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
			doc.open();

			Paragraph p = new Paragraph("Vendas");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Quantidade Total de pratos vendidos: " + pratos);
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Valor Total das vendas: " + preco + "R$");
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);

			PdfPTable table = new PdfPTable(6);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Data"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Pratos"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Valor"));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Quantidade de Itens")); 
			PdfPCell cell6 = new PdfPCell(new Paragraph("Cliente"));

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5); 
			table.addCell(cell6);

			for (Venda venda : vendas) {
				quantidadePratos = 0;
				itens = "";
				cell1 = new PdfPCell(new Paragraph(venda.getIdVenda() + ""));
				data = venda.getData();
				cell2 = new PdfPCell(new Paragraph(data + ""));
				for (int id : venda.getItens()) {
					quantidadePratos = quantidadePratos + 1;
					itens = itens + "[" + id + "]";
				}
				cell3 = new PdfPCell(new Paragraph(itens + ""));
				cell4 = new PdfPCell(new Paragraph(venda.getPrecoTotal() + "R$"));
				cell5 = new PdfPCell(new Paragraph(quantidadePratos + ""));
				cell6 = new PdfPCell(new Paragraph(venda.getIdCliente()));
				
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File(arquivoPdf));

		} catch (Exception e) {

		}
	} 
	
	
	/**
	 * Função que recebe uma venda e gera uma nota a partir 
	 * dela
	 * @param venda
	 * @param pratos
	 * @param preco
	 */
	public static void GerarRelatorioNota(Venda venda, List<Prato> pratos, float preco) {

		Document doc = new Document();
		String arquivoPdf = "RelatorioNota.pdf";

		try {

			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
			doc.open();

			Paragraph p = new Paragraph("Nota Venda");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Id Cliente: " + venda.getIdCliente());
			p.setAlignment(0);
			doc.add(p); 
			p = new Paragraph(" "); 
			doc.add(p);
			p = new Paragraph("Quantidade Total de pratos: " + pratos.size());
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);
			p = new Paragraph("Valor Total da venda: " + preco + "R$");
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph("Forma de Pagamento: " + venda.getFormaDePagamento());
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph("Data venda: " + venda.getData());
			p.setAlignment(0);
			doc.add(p);
			p = new Paragraph(" ");
			doc.add(p);

			PdfPTable table = new PdfPTable(4);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Categoria"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Preço"));

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);

			for (Prato prato : pratos) {
		
				cell1 = new PdfPCell(new Paragraph(prato.getIdPrato() + ""));
				cell2 = new PdfPCell(new Paragraph(prato.getNomePrato() + ""));
				cell3 = new PdfPCell(new Paragraph(prato.getCategoria() + ""));
				cell4 = new PdfPCell(new Paragraph(prato.getPrecoPrato() + "R$"));
				
				
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File(arquivoPdf));

		} catch (Exception e) {

		}
	} 
	
}
