package br.edu.ifes.sr.poo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.controller.model.ServicoTemp;
import br.edu.ifes.sr.poo2.model.Categoria;
import br.edu.ifes.sr.poo2.model.Gerente;
import br.edu.ifes.sr.poo2.model.Servico;
import br.edu.ifes.sr.poo2.service.CategoriaService;
import br.edu.ifes.sr.poo2.service.GerenteService;
import br.edu.ifes.sr.poo2.service.ServicoService;

@Controller
@RequestMapping("/servico")
public class ServicoController extends AbstractController {

	@Autowired
	private ServicoService service;

	@Autowired
	private GerenteService gerenteService;

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody ServicoTemp servicotemp) {
		try {

			Gerente gerente = gerenteService.find(servicotemp.getIdGerente());

			if (gerente == null || gerente.getServico() != null || servicotemp.getIdCategoria() == 0) {
				return new ResponseEntity<String>("-1",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			Servico servico = new Servico();
			Categoria categoria = categoriaService.find(servicotemp.getIdCategoria());
			
			servico.setCategoria(categoria);
			servico.setUrl(servicotemp.getUrl());
			
			// Salvando o servico
			service.save(servico);

			// adicionando o servico no gerente
			gerente.setServico(servico);

			gerenteService.save(gerente);

			return new ResponseEntity<String>(servico.getId().toString(),
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Retornando um lista de gerentes
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Servico>> get() {
		try {

			List<Servico> servicos = service.findAll();

			return new ResponseEntity<List<Servico>>(servicos, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Servico>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
