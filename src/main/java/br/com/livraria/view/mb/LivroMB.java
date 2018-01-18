package br.com.livraria.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.livraria.bean.Livro;
import br.com.livraria.controle.esp.LivroBCI;
import br.com.livraria.view.util.JSFUtil;

@ManagedBean(name = "LivroMB")
@Scope("view")
public class LivroMB extends SpringBeanAutowiringSupport {

	private Livro bean;
	
	@Autowired
	private LivroBCI controle;
	private List<Livro> lista;
	private String labelGenero;
	private String labelAutor;
	private String labelEditora;
	
	@PostConstruct
	public void inicializar() {
		this.bean = new Livro();
		this.lista = controle.select();
		this.labelGenero = "Selecionar";
		this.labelAutor = "Selecionar";
		this.labelEditora = "Selecionar";
	}

	public Livro getBean() {
		return bean;
	}

	public void setBean(Livro bean) {
		this.bean = bean;
	}

	public List<Livro> getLista() {
		return lista;
	}

	public void setLista(List<Livro> lista) {
		this.lista = lista;
	}

	public String getLabelGenero() {
		return labelGenero;
	}

	public void setLabelGenero(String labelGenero) {
		this.labelGenero = labelGenero;
	}

	public String getLabelAutor() {
		return labelAutor;
	}

	public void setLabelAutor(String labelAutor) {
		this.labelAutor = labelAutor;
	}

	public String getLabelEditora() {
		return labelEditora;
	}

	public void setLabelEditora(String labelEditora) {
		this.labelEditora = labelEditora;
	}

	public void insert() {
		this.controle.insert(bean);
		JSFUtil.adicionarMensagemSucesso(String.format("Livro %s cadastrado com sucesso.", bean.getNome()));
		
		this.bean = new Livro();
		this.lista = controle.select();		
	}

	public void update() {
		this.controle.update(bean);
		JSFUtil.adicionarMensagemSucesso(String.format("Livro %s alterado com sucesso.", bean.getNome()));
		
		this.bean = new Livro();
		this.lista = controle.select();		
	}	
	
	public void delete() {
		this.controle.delete(bean);
		JSFUtil.adicionarMensagemSucesso(String.format("Livro %s excluido com sucesso.", bean.getNome()));
		
		this.bean = new Livro();
		this.lista = controle.select();		
	}
	
	public void mostrarSelecaoGenero() {
		this.labelGenero = "Selecionado: " + this.bean.getGenero().getNome();
	}
	
	public void mostrarSelecaoAutor() {
		this.labelAutor = "Selecionado: " + this.bean.getAutor().getNome();
	}
	
	public void mostrarSelecaoEditora() {
		this.labelEditora = "Selecionada: " + this.bean.getEditora().getNome();
	}
}
