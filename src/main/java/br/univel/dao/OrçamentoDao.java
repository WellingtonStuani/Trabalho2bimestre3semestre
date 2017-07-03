package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.univel.classes.Orçamento;
import br.univel.classes.ProdutoOrcamento;
import br.univel.conexaoDb.conexaoDbpostgres;



public class OrçamentoDao {
	public static void gravar(Orçamento orcamento) {
		
	
	try (Connection db = conexaoDbpostgres.getconexaoDbpstgres()) {

		PreparedStatement ps = db.prepareStatement("insert into orcamento (cliente, total) values (?, ?) ");
		ps.setString(1, orcamento.getCliente().getNome());
		ps.setBigDecimal(2, orcamento.getTotal());

		ps.executeUpdate();

		
		int id = 0;
		ps = db.prepareStatement("SELECT * FROM orcamento ORDER BY id ASC");
		ResultSet executeQuery = ps.executeQuery();
		
		if (executeQuery.next()){
			 id = executeQuery.getInt("id");
		}
		
		
		for (ProdutoOrcamento produto : orcamento.getProdutos()) {

			ps = db.prepareStatement("insert into produto_orcamento (id_orcamento, id_item, id_produto, descricao, qtd, vlr_unitario, sub_total) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2, produto.getId_item());
			ps.setInt(3, produto.getId_produto());
			ps.setString(4, produto.getDescricao());
			ps.setInt(5, produto.getQtd());
			ps.setBigDecimal(6, produto.getVlrUnitario());
			ps.setBigDecimal(7, produto.getSubTotal());

			ps.executeUpdate();

		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
