package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Editora;
import br.com.livraria.controle.esp.EditoraBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "EditoraMB")
@Scope("view")
public class EditoraMB extends SpringBeanAutowiringSupport {

	private Editora bean;
	private List<Editora> list;
	@Autowired
	private EditoraBCI controle;

	public Editora getBean() {
		return bean;
	}

	public void setBean(Editora bean) {
		this.bean = bean;
	}

	public List<Editora> getList() {
		return list;
	}

	public void setList(List<Editora> list) {
		this.list = list;
	}

	@PostConstruct
	public void init() {
		this.bean = new Editora();
		this.list = this.controle.select();
	}

	public void gravar() {
		this.controle.inserir(this.bean);

		JSFUtil.adicionarMensagemSucesso("Editora inserida com sucesso.");
		this.init();
	}

}
