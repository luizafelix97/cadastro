package br.com.sistemadecadastro.controller;

import javax.validation.Valid;

import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.service.MinisterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/ministerio")
public class MinisterioController {
	
	@Autowired
	private MinisterioService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Ministerio ministerio) {
		return "ministerio/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("ministerio", service.buscarTodos());
		return "ministerio/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Ministerio ministerio, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "ministerio/cadastro";
		}
		
		service.salvar(ministerio);
		attr.addFlashAttribute("success", "Ministerio inserido com sucesso.");
		return "redirect:/ministerio/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("ministerio", service.buscarPorId(id));
		return "ministerio/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Ministerio ministerio, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "ministerio/cadastro";
		}
		
		service.editar(ministerio);
		attr.addFlashAttribute("success", "Ministerio editado com sucesso.");
		return "redirect:/ministerio/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.ministerioTemCargos(id)) {
			model.addAttribute("fail", "Ministerio não removido. Possui cargo(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Ministerio excluído com sucesso.");
		}
		
		return listar(model);
	}
	
	
}
