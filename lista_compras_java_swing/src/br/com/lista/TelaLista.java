package br.com.lista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class TelaLista extends JFrame {
	
	private JTable tabela;
	private JScrollPane barraRolagem;
	
	public TelaLista() {
		getContentPane().setLayout(null);
		setSize(500,400);
		
		tabela = new JTable();
		
		List<Produto> lista = new ArrayList<>();
		Produto produto = new Produto();
		produto.setId(2);
		produto.setNome("feijao");
		produto.setQuant(2);
		produto.setValorUn(6.80);
		produto.setValorTotal(produto.getValorUn() * produto.getQuant());
		lista.add(produto);
		
		String[] colunas = {"ID", "Produto", "Qt", "Valor UN", "Valor Total"};
		Object[][] linhas = {{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},{"1","arroz", "1", "21.50", "21.50"},
				};
		
		DefaultTableModel padraoTabela = new DefaultTableModel(linhas, colunas);
		
		tabela.setModel(padraoTabela);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30); 
		tabela.getColumnModel().getColumn(1).setPreferredWidth(250); 
		tabela.getColumnModel().getColumn(2).setPreferredWidth(50); 
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100); 
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 20, 450, 300);
		getContentPane().add(barraRolagem);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(190, 332, 117, 25);
		getContentPane().add(btnVoltar);
	}
	
	public static void main(String[] args) {
		TelaLista lista = new TelaLista();
		lista.setVisible(true);
	}
}
