package controllers;

import java.util.List;

import models.Livro;
import play.mvc.Controller;

public class Livros extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void cadastrar(Livro l) {
		
		String mensagem = "Cadastrado com sucesso!";
		
		if(l.id != null) {
			mensagem = "Editado com sucesso!";
		}
		
		l.save();
		flash.success(mensagem);
		listar(null);
	}
	
	public static void listar(String termo) {
		List<Livro> livros = null;
		
		if(termo == null) {
			livros = Livro.findAll();
		} else {
			livros = Livro.find("lower(nome) like ?1 or lower(autor) like ?1", "%" + termo.toLowerCase() + "%").fetch();
		}
		render(livros);
	}
	
	public static void remover(long id) {
		Livro l = Livro.findById(id);
		l.delete();
		listar(null);
	}
	
	public static void editar(long id) {
		Livro l = Livro.findById(id);
		renderTemplate("Livros/form.html", l);
	}
	
}
