package br.com.farmacia.bean;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;


@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
	private Fornecedores fornecedores;
	private ArrayList<Fornecedores>itens;
	private ArrayList<Fornecedores>itensFiltrados;
	
public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}


	public ArrayList<Fornecedores> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
@PostConstruct	
	public void prepararPesquisa(){
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = fdao.listar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void prepararSave(){
		fornecedores = new Fornecedores();
	}

	public void salvarFornecedores(){
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);
			
			itens = fdao.listar();
			
			JSFUtil.addMensagemSucesso("Sucesso , Fornecedor Cadastrado !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.addMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	
	public void excluirFornecedores(){
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);
			
			itens = fdao.listar();
			
			JSFUtil.addMensagemSucesso("Sucesso , Fornecedor Deletado !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.addMensagemErro("Não é possivel excluir um fornecedor com estes produtos associados !");
			e.printStackTrace();
		}
	}
	
	public void editarFornecedores(){
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);
			
			itens = fdao.listar();
			
			JSFUtil.addMensagemSucesso("Sucesso , Fornecedor Editado !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.addMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
}


