package br.com.lista;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModelo extends AbstractTableModel {

	private List<Produto> dados = new ArrayList<>();
	private String[] colunas = { "ID", "Produto", "Qtd", "Valor Un", "Valor Total" };

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {
		case 0:
			return dados.get(linha).getId();
		case 1:
			return dados.get(linha).getNome();
		case 2:
			return dados.get(linha).getQuant();
		case 3:
			return dados.get(linha).getValorUn();
		case 4:
			String valorTotalF = (NumberFormat.getCurrencyInstance().format(dados.get(linha).getValorTotal()));
			return valorTotalF;
		}

		return null;
	}

	@Override
	public void setValueAt(Object valor, int linha, int coluna) {

		switch (coluna) {
		case 0:
			dados.get(linha).setId(Integer.parseInt((String) valor));
			break;
		case 1:
			dados.get(linha).setNome((String) valor);
			break;
		case 2:
			dados.get(linha).setQuant(Integer.parseInt((String) valor));
			break;
		case 3:
			dados.get(linha).setValorUn(new BigDecimal(valor.toString()));
			break;
		}

		this.fireTableRowsUpdated(linha, linha);

	}

	public void addRow(Produto p) {
		this.dados.add(p);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
}
