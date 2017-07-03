package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.classes.Cliente;
import br.univel.conexaoDb.conexaoDbpostgres;



public class ClienteDao {
	public static void gravar(Cliente cliente) {

		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("insert into cliente (nome, cpf, telefone) values (?, ?, ?) ");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEndereco());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void excluir(int id) {

		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("delete from cliente where id = ?");
			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Cliente> listarTodosClientes() {

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("select * from cliente");
			ResultSet executeQuery = ps.executeQuery();

			while (executeQuery.next()) {

				Cliente cliente = new Cliente();
				
				cliente.setId(executeQuery.getInt("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setTelefone(executeQuery.getString("telefone"));
				cliente.setEndereco(executeQuery.getString("endereco"));
				
				listaClientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	public static List<Cliente> listarByNameParam(String nome) {

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("select * from cliente where nome like ?");
			
			ps.setString(1, "%"+nome+"%");
			
			ResultSet executeQuery = ps.executeQuery();

			while (executeQuery.next()) {

				Cliente cliente = new Cliente();
				
				cliente.setId(executeQuery.getInt("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setTelefone(executeQuery.getString("telefone"));
				cliente.setEndereco(executeQuery.getString("endereço"));
				listaClientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	public static List<Cliente> getCliente(int id) {

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("select * from cliente where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet executeQuery = ps.executeQuery();

			while (executeQuery.next()) {

				Cliente cliente = new Cliente();
				
				cliente.setId(executeQuery.getInt("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setTelefone(executeQuery.getString("telefone"));
				cliente.setEndereco(executeQuery.getString("endereço"));
				
				
				listaClientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}

	public static void alterar(Cliente cliente) {
		try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

			PreparedStatement ps = db.prepareStatement("update cliente set nome = ?, cpf = ?, telefone = ? where id = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(3, cliente.getTelefone());
			ps.setString(2, cliente.getEndereco());
			
			ps.setInt(4, cliente.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
