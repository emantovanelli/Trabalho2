package br.edu.ifes.sr.poo2.model.factory;

import br.edu.ifes.sr.poo2.model.NivelPergunta;
import br.edu.ifes.sr.poo2.model.Pergunta;

public class PerguntaMediaFactory extends PerguntaFactory {
	protected Pergunta selecionarPergunta(NivelPergunta nivel) {
		if(nivel == NivelPergunta.MEDIA){
			Pergunta p = new Pergunta();
			p.setTipo(nivel);
			return p;
		}
		else{
			return null;
		}
	}

}
