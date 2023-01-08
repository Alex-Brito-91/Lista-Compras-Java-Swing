package br.com.lista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaCadastro extends JFrame {
	
	private JTextField textProduto;
	private JTextField textValor;
	private JTable table;
	TabelaModelo modelo = new TabelaModelo();
	
	public TelaCadastro() {
		super("Cadastro de Produtos");
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(600,500);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(34, 12, 70, 15);
		getContentPane().add(lblProduto);
		
		JLabel lblQuant = new JLabel("Quant");
		lblQuant.setBounds(335, 11, 95, 17);
		getContentPane().add(lblQuant);
		
		JLabel lblValorUn = new JLabel("Valor");
		lblValorUn.setBounds(494, 12, 48, 15);
		getContentPane().add(lblValorUn);
		
		textProduto = new JTextField();
		textProduto.setBounds(34, 39, 188, 19);
		textProduto.setColumns(10);
		getContentPane().add(textProduto);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(494, 39, 70, 19);
		getContentPane().add(textValor);
		
		JSpinner spinnerQuant = new JSpinner();
		spinnerQuant.setBounds(335, 39, 54, 20);
		getContentPane().add(spinnerQuant);
		
		table = new JTable();
		table.setModel(modelo);
		table.setBounds(34, 90, 530, 280);
		getContentPane().add(table);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(61, 397, 117, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(239, 397, 117, 25);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(417, 397, 117, 25);
		getContentPane().add(btnExcluir);
		
	}
	
	public static void main(String[] args) {
		TelaCadastro cadastro = new TelaCadastro();
		cadastro.setVisible(true);
	}
}
