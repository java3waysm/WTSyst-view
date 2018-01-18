package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Autor;
import br.com.livraria.controle.esp.AutorBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "AutorMB")
@Scope("view")
public class AutorMB extends SpringBeanAutowiringSupport {
	
	private Autor bean;
	private List<Autor> list;
	@Autowired
	private AutorBCI controle;
	
	@PostConstruct
	public void init() {
		this.bean = new Autor();
		this.list = this.controle.select();
	}
	
	public Autor getBean() {
		return bean;
	}

	public void setBean(Autor bean) {
		this.bean = bean;
	}

	public List<Autor> getList() {
		return list;
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	public void gravar() {
		this.controle.insert(this.bean);
		
		JSFUtil.adicionarMensagemSucesso("Autor inserido com sucesso.");
		this.init();
	}

}


//Testando comite Emerson
