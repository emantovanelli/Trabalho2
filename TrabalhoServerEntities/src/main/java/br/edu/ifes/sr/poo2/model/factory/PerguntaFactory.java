package br.edu.ifes.sr.poo2.model.factory;

import br.edu.ifes.sr.poo2.model.NivelPergunta;
import br.edu.ifes.sr.poo2.model.Pergunta;

public abstract class PerguntaFactory {
	
	public Pergunta criarPergunta(NivelPergunta nivel){
		Pergunta pergunta = selecionarPergunta(nivel);
		return pergunta;
	}
	protected abstract Pergunta selecionarPergunta(NivelPergunta nivel);
}
