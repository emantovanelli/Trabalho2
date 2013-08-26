package br.edu.ifes.sr.poo2.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Pergunta extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String pergunta;
	
	@Column
	private NivelPergunta nivelPergunta;
	
	@Column
	private char opcaoCorreta;
	
	@Column
	@OneToMany
	private ArrayList<OpcoesRespostas> opcoes = new ArrayList<OpcoesRespostas>();

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public NivelPergunta getNivelPergunta() {
		return nivelPergunta;
	}

	public void setTipo(NivelPergunta nivel) {
		this.nivelPergunta = nivel;
	}

	public char getOpcaoCorreta() {
		return opcaoCorreta;
	}

	public void setOpcaoCorreta(char opcaoCorreta) {
		this.opcaoCorreta = opcaoCorreta;
	}

	public ArrayList<OpcoesRespostas> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(ArrayList<OpcoesRespostas> opcoes) {
		this.opcoes = opcoes;
	}
	
	
	public void addOpcao(OpcoesRespostas opcao){
		this.opcoes.add(opcao);
	}
	
	public void removerOpcao(int posicao){
		this.opcoes.remove(posicao);
	}

}