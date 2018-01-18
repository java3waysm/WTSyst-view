package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Cachorro;
import br.com.livraria.controle.esp.CachorroBCI;


@ManagedBean(name = "CachorroMB")
public class CachorroMB extends SpringBeanAutowiringSupport{
	
	private Cachorro bean;
	@Autowired
	private CachorroBCI controle;
	private List<Cachorro> list;
	
	@PostConstruct
	public void init() {
		this.list = controle.select();
		this.bean = new Cachorro();
	}

	public Cachorro getBean() {
		return bean;
	}

	public void setBean(Cachorro bean) {
		this.bean = bean;
	}

	public List<Cachorro> getList() {
		return list;
	}

	public void setList(List<Cachorro> list) {
		this.list = list;
	}
	
	public void insert() {
		this.controle.insert(this.bean);
		this.init();
	}
	
	
	
	
}
