package br.com.lista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModelo extends AbstractTableModel {
	
	private List<Produto> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Produto", "Quant", "Valor Un", "Valor Total"}; 

	
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
		
		switch(coluna) {
			case 0:
				return dados.get(linha).getId();
			case 1:
				return dados.get(linha).getNome();
			case 2:
				return dados.get(linha).getQuant();
			case 3:
				return dados.get(linha).getValorUn();
			case 4:
				return dados.get(linha).getValorTotal();
		}
		
		return null;
	}

}
