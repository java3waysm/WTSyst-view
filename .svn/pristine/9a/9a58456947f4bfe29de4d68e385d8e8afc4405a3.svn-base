package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Genero;
import br.com.livraria.controle.esp.GeneroBCI;
import br.com.livraria.controle.impl.GeneroBC;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "GeneroMB")
@Scope("view")
public class GeneroMB extends SpringBeanAutowiringSupport{

	private Genero bean;
	@Autowired
	private GeneroBCI controle;
	private List<Genero> lista;
	
	@PostConstruct
	public void init() {
		this.bean = new Genero();
		this.lista = controle.select();
	}

	public Genero getBean() {
		return bean;
	}

	public void setBean(Genero bean) {
		this.bean = bean;
	}

	public List<Genero> getLista() {
		return lista;
	}

	public void setLista(List<Genero> lista) {
		this.lista = lista;
	}
	
	public void gravar() {
		this.controle.insert(bean);
		
		JSFUtil.adicionarMensagemSucesso(String.format("Genero %s cadastrado com sucesso.", bean.getNome()));
		
		this.bean = new Genero();
		this.lista = controle.select();
		
	}
}










