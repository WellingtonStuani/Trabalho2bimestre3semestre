package br.univel.Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.classes.Cliente;



public class ClienteModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Cliente> listClientes;

	public ClienteModel() {

	}

	public ClienteModel(List<Cliente> clientes) {
		this.listClientes = clientes;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return listClientes.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Cliente cliente = listClientes.get(row);

		switch (col) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNome();
		case 2:
			return cliente.getTelefone();
		case 3:
			return cliente.getEndereco();

		default:
			return "Algo de errado nao esta certo!!!! ";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Telefone";
		case 3:
			return "Endereco";
			
		default:
			return "Algo de errado nao esta certo!!!!";
		}
	}

	
	

}
