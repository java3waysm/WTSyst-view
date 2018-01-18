package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Cliente;
import br.com.livraria.controle.esp.ClienteBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean( name = "ClienteMB")
@Scope ("view")
public class ClienteMB extends SpringBeanAutowiringSupport{
	
	
	private Cliente bean;
	
	@Autowired
	private ClienteBCI controle;
	private List<Cliente>list;
	
	
	@PostConstruct
	public void Inicializar() {
		this.bean = new Cliente();
		this.list = controle.select();
		
		
		
		
	}


	public Cliente getBean() {
		return bean;
	}


	public void setBean(Cliente bean) {
		this.bean = bean;
	}


	public List<Cliente> getList() {
		return list;
	}


	public void setList(List<Cliente> list) {
		this.list = list;
	}
			
	public void gravar() {
		
		this.controle.insert(bean);
		
		JSFUtil.adicionarMensagemSucesso(
				String.format("Cliente cadastrado com sucesso", bean.getNome()));
		
		this.bean = new Cliente();
		this.list = controle.select();
		
		
	}

}
