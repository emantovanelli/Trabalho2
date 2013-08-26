package br.edu.ifes.sr.poo2.model.factory;

import br.edu.ifes.sr.poo2.model.NivelPergunta;
import br.edu.ifes.sr.poo2.model.Pergunta;

public interface CriadorDePerguntas {
	Pergunta criarPergunta(NivelPergunta nivel);
}
