package br.edu.ifes.sr.poo2.model.factory;

import br.edu.ifes.sr.poo2.model.NivelPergunta;
import br.edu.ifes.sr.poo2.model.Pergunta;

public class CriadorDePerguntasImpl extends AbstractCriadorDePerguntas {
	private PerguntaFactory perguntaFacil = new PerguntaFacilFactory();
	private PerguntaFactory perguntaMedia = new PerguntaMediaFactory();
	private PerguntaFactory perguntaDificil = new PerguntaDificilFactory();

	@Override
	public Pergunta criarPerguntas(NivelPergunta nivel) {
		if(nivel == NivelPergunta.FACIL){
			return perguntaFacil.criarPergunta(nivel);
		}
		else{
			if(nivel == NivelPergunta.MEDIA){
				return perguntaMedia.criarPergunta(nivel);
			}
			else{
				return perguntaDificil.criarPergunta(nivel);
			}
		}
	}
	

}
