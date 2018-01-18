package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Usuario;
import br.com.livraria.controle.esp.UsuarioBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "UsuarioMB")
@Scope("View")
public class UsuarioMB extends SpringBeanAutowiringSupport{
	
	private Usuario bean;
	private List<Usuario> lista;
	@Autowired
	private UsuarioBCI controle;
	
	@PostConstruct
	public void init() {
		this.bean = new Usuario();
		this.lista = this.controle.select();
		
	}

	public Usuario getBean() {
		return bean;
	}

	public void setBean(Usuario bean) {
		this.bean = bean;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
	public void gravar() {
		this.controle.insert(this.bean);
		
		JSFUtil.adicionarMensagemSucesso("Usuario Cadastrado com sucesso.");
		this.init();
		
		
	}
	
	

	
	
}
