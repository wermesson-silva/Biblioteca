package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Livro extends Model{
	
	public String nome;
	public int ano;
	public String editora;
	public String autor;
	
}
