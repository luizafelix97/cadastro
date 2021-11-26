package br.com.sistemadecadastro.controller;

import java.time.LocalDate;

import javax.validation.Valid;
import br.com.sistemadecadastro.domain.Fornecedor;

import br.com.sistemadecadastro.domain.enums.UF;
import br.com.sistemadecadastro.service.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
		
		
	@GetMapping("/cadastrar")
	public String cadastrar(Fornecedor fornecedor) {
		return "fornecedor/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("fornecedor", fornecedorService.buscarTodos());
		return "fornecedor/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Fornecedor fornecedor, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fornecedor/cadastro";
		}
		
		fornecedorService.salvar(fornecedor);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/fornecedores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fornecedor", fornecedorService.buscarPorId(id));
		return "fornecedor/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Fornecedor fornecedor, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fornecedor/cadastro";
		}
		
		fornecedorService.editar(fornecedor);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
		return "redirect:/fornecedor/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		fornecedorService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso.");
		return "redirect:/fornecedor/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("fornecedor", fornecedorService.buscarPorNome(nome));
		return "fornecedor/lista";
	}
	
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("fornecedor", fornecedorService.buscarPorDatas(entrada, saida));
        return "fornecedor/lista";
    }
		
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
