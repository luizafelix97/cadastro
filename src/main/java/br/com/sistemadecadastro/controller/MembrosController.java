package br.com.sistemadecadastro.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import br.com.sistemadecadastro.domain.Cargo;
import br.com.sistemadecadastro.domain.Membros;
import br.com.sistemadecadastro.domain.enums.UF;
import br.com.sistemadecadastro.service.CargoService;
import br.com.sistemadecadastro.service.MembroService;
import br.com.sistemadecadastro.validator.FuncionarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembroService membroService;
	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Membros membros) {
		return "membro/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", membroService.buscarTodos());
		return "membro/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Membros membros, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "membro/cadastro";
		}
		
		membroService.salvar(membros);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/membros/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", membroService.buscarPorId(id));
		return "membros/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Membros membros, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "membro/cadastro";
		}
		
		membroService.editar(membros);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
		return "redirect:/membros/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		membroService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso.");
		return "redirect:/membros/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("funcionarios", membroService.buscarPorNome(nome));
		return "membro/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", membroService.buscarPorCargo(id));
		return "membro/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("funcionarios", membroService.buscarPorDatas(entrada, saida));
        return "membro/lista";
    }
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
