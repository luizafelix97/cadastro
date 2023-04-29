package br.com.sistemadecadastro.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import br.com.sistemadecadastro.domain.Intencao;

import br.com.sistemadecadastro.domain.enums.UF;
import br.com.sistemadecadastro.service.IntencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/intencao")
public class IntencaoController {
	
	@Autowired
	private IntencaoService intencaoService;
		
		
	@GetMapping("/cadastrar")
	public String cadastrar(Intencao intencao) {
		return "intencao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("fornecedor", intencaoService.buscarTodos());
		return "intencao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Intencao intencao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "intencao/cadastro";
		}
		
		intencaoService.salvar(intencao);
		attr.addFlashAttribute("success", "Intenção inserida com sucesso.");
		return "redirect:/intencao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fornecedor", intencaoService.buscarPorId(id));
		return "intencao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Intencao intencao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "intencao/cadastro";
		}
		
		intencaoService.editar(intencao);
		attr.addFlashAttribute("success", "Intenção editada com sucesso.");
		return "redirect:/intencao/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		intencaoService.excluir(id);
		attr.addFlashAttribute("success", "Intenção removida com sucesso.");
		return "redirect:/intencao/listar";
	}	

}
