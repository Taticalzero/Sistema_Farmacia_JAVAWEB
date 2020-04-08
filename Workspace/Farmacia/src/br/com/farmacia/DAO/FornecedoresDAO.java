package br.com.farmacia.DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.Conexaobd;

public class FornecedoresDAO {
	public void salvar(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");
		
		Connection conexao = Conexaobd.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}
	
	public void excluir (Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = Conexaobd.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
		
	}
	public void editar (Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = Conexaobd.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
		
	}
	public Fornecedores buscaPorCod(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = Conexaobd.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		
		if(resultado.next()){
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		
		
		return retorno;
		
	}
	
	public ArrayList<Fornecedores>buscarPorDesc(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = Conexaobd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()){
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			
			lista.add(item);
		}

		return lista;
	}
	
	public ArrayList<Fornecedores> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = Conexaobd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
				
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()){
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			
			lista.add(f);
		}

		return lista;
	}
	/*	public static void main(String[] args) {
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Pedro");
		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("Reginaldo");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo não Salvo");
		} */
		
	/*	Fornecedores f1 = new Fornecedores();
		f1.setCodigo(2L);
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.excluir(f1);
			//fdao.salvar(f2);
			System.out.println("Deletado com Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo não Deletado");
		}*/
		
		/*Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1L);
		f1.setDescricao("testereg");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.editar(f1);
			//fdao.salvar(f2);
			System.out.println("Arquivo editado com sucesso !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo não Editado !");
		}*/
		
	/*	Fornecedores f1 = new Fornecedores();
		f1.setCodigo(3L);
		Fornecedores f2 = new Fornecedores();
		f2.setCodigo(7L);
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			Fornecedores f3 = fdao.buscaPorCod(f1);
			Fornecedores f4 = fdao.buscaPorCod(f2);
			System.out.println("Busca 1: " + f3);
			System.out.println("Busca 2: " + f4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Busca Invalida ou mal-sucedida !");
		}*/
		
	/*	FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			
			ArrayList<Fornecedores>lista = fdao.listar();
			
			for (Fornecedores f : lista){
			System.out.println("Resultado " + f);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} */
		
	/*	Fornecedores f1 = new Fornecedores();
		f1.setDescricao("de");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			ArrayList<Fornecedores>lista = fdao.buscarPorDesc(f1);
			
			for (Fornecedores f : lista){
			System.out.println("Resultado " + f);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		} */ 
		
	}

