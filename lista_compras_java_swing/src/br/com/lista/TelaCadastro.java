package br.com.lista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class TelaCadastro extends JFrame {
	
	private JTextField textProduto;
	private JTextField textValor;
	
	public TelaCadastro() {
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(350,300);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(67, 35, 70, 15);
		getContentPane().add(lblProduto);
		
		textProduto = new JTextField();
		textProduto.setBounds(139, 33, 142, 19);
		textProduto.setColumns(10);
		getContentPane().add(textProduto);
		
		JLabel lblQuant = new JLabel("Quantidade:");
		lblQuant.setBounds(42, 64, 95, 17);
		getContentPane().add(lblQuant);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(139, 63, 54, 20);
		getContentPane().add(spinner);
		
		JLabel lblValorUn = new JLabel("Valor:");
		lblValorUn.setBounds(89, 93, 48, 15);
		getContentPane().add(lblValorUn);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(139, 91, 54, 19);
		getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(115, 171, 117, 25);
		getContentPane().add(btnCadastrar);
		
	}
	
	public static void main(String[] args) {
		TelaCadastro cadastro = new TelaCadastro();
		cadastro.setVisible(true);
	}
}
