package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Empresa;
import br.com.livraria.controle.esp.EmpresaBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "EmpresaMB")
public class EmpresaMB extends SpringBeanAutowiringSupport {

	private Empresa bean;
	private List<Empresa> empresas;
	@Autowired
	private EmpresaBCI controle;

	
	@PostConstruct
	public void init() {
		this.empresas = controle.select();
		this.bean = new Empresa();
	}

	public Empresa getBean() {
		return bean;
	}

	public void setBean(Empresa bean) {
		this.bean = bean;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public void insert() {
		this.controle.insert(this.bean);
		this.init();
		JSFUtil.adicionarMensagemSucesso(String.format("Empresa cadastrado com sucesso.", null ));
	}
	

}
