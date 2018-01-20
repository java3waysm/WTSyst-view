package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Funcionario;
import br.com.livraria.controle.esp.FuncionarioBCI;
@ManagedBean(name = "FuncionarioMB")
public class FuncionarioMB extends SpringBeanAutowiringSupport {

	@Autowired
	private FuncionarioBCI controle;
	private Funcionario bean;
	private List<Funcionario> funcionarios;
	
	
	@PostConstruct
	public void init() {
		this.bean = new Funcionario();
		this.funcionarios = controle.select();
	}
	
	
	public Funcionario getBean() {
		return bean;
	}
	public void setBean(Funcionario bean) {
		this.bean = bean;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	public void insert() {
		this.controle.insert(this.bean);
	}
	
}
