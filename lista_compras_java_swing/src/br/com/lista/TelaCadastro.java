package br.com.lista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField textProduto;
	private JTextField textValor;
	private JTable tabela;
	private int geraId = 0;
	TabelaModelo modelo = new TabelaModelo();
	Locale locale = Locale.US;

	public TelaCadastro() {
		super("Cadastro de Produtos");
		getContentPane().setBackground(new Color(186, 189, 182));
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(600, 500);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(34, 12, 70, 15);
		getContentPane().add(lblProduto);

		JLabel lblQuant = new JLabel("Quant");
		lblQuant.setBounds(240, 11, 95, 17);
		getContentPane().add(lblQuant);

		JLabel lblValorUn = new JLabel("Valor");
		lblValorUn.setBounds(316, 12, 48, 15);
		getContentPane().add(lblValorUn);

		textProduto = new JTextField();
		textProduto.setBounds(34, 39, 188, 25);
		textProduto.setColumns(10);
		getContentPane().add(textProduto);

		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(316, 39, 70, 25);
		getContentPane().add(textValor);

		SpinnerModel spModel = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner spinnerQuant = new JSpinner(spModel);
		spinnerQuant.setBounds(240, 38, 54, 25);
		getContentPane().add(spinnerQuant);

		tabela = new JTable(modelo);

		TableColumnModel colmod = tabela.getColumnModel();
		TableColumn id = colmod.getColumn(0);
		TableColumn produto = colmod.getColumn(1);
		TableColumn quant = colmod.getColumn(2);
		TableColumn valorUn = colmod.getColumn(3);
		TableColumn valorTotal = colmod.getColumn(4);

		id.setPreferredWidth(40);
		produto.setPreferredWidth(250);
		quant.setPreferredWidth(40);
		valorUn.setPreferredWidth(60);
		valorTotal.setPreferredWidth(70);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();        
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(34, 90, 530, 280);
		getContentPane().add(scroll);

		JLabel lblTotalCompra = new JLabel();
		lblTotalCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalCompra.setBounds(316, 382, 248, 45);
		getContentPane().add(lblTotalCompra);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(154, 198, 129));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto p = new Produto();
				p.setId(++geraId);
				p.setNome(textProduto.getText());
				p.setQuant(Integer.parseInt(spinnerQuant.getValue().toString()));
				String valorUnF = textValor.getText().replaceAll(",", ".");
				BigDecimal valorUn = new BigDecimal(valorUnF);
				p.setValorUn(valorUn);
				modelo.addRow(p);
				lblTotalCompra.setText("Total da Compra: " + modelo.totalDaCompra());
				textProduto.setText("");
				textValor.setText("");
				spinnerQuant.setValue(1);
			}
		});
		btnCadastrar.setBounds(464, 37, 100, 30);
		getContentPane().add(btnCadastrar);

		tabela.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					String produto = tabela.getValueAt(tabela.getSelectedRow(), 1).toString();
					int quant = Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
					String valor = tabela.getValueAt(tabela.getSelectedRow(), 3).toString();
					textProduto.setText(produto);
					spinnerQuant.setValue(quant);
					textValor.setText(valor);
				}
			}
		});

		JButton btnEditar = new JButton("Editar");

		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (tabela.getSelectedRow() != -1) {
					modelo.setValueAt(textProduto.getText(), tabela.getSelectedRow(), 1);
					modelo.setValueAt(spinnerQuant.getValue().toString(), tabela.getSelectedRow(), 2);
					String valorUnF = textValor.getText().replaceAll(",", ".");
					BigDecimal valorUn = new BigDecimal(valorUnF);
					modelo.setValueAt(valorUn, tabela.getSelectedRow(), 3);
					lblTotalCompra.setText("Total da Compra: " + modelo.totalDaCompra());
					textProduto.setText("");
					textValor.setText("");
					spinnerQuant.setValue(1);
				}

			}
		});
		btnEditar.setBackground(new Color(252, 233, 79));
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnEditar.setBounds(34, 397, 90, 30);
		getContentPane().add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabela.getSelectedRow() != -1) {
					modelo.removeRow(tabela.getSelectedRow());
					textProduto.setText("");
					textValor.setText("");
					spinnerQuant.setValue(1);
					lblTotalCompra.setText("Total da Compra: " + modelo.totalDaCompra());
				}
			}
		});
		btnExcluir.setBackground(new Color(239, 41, 41));
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 11));
		btnExcluir.setBounds(169, 397, 90, 30);
		getContentPane().add(btnExcluir);

	}

	public static void main(String[] args) {
		TelaCadastro cadastro = new TelaCadastro();
		cadastro.setVisible(true);
	}
}
