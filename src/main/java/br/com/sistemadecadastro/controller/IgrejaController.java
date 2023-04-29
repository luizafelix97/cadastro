package br.com.sistemadecadastro.controller;

import br.com.sistemadecadastro.domain.Igreja;
import br.com.sistemadecadastro.service.IgrejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/igreja")
public class IgrejaController {

    @Autowired
    private IgrejaService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Igreja igreja){ return "igreja/cadastro"; }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("igreja", service.buscarTodos());
        return "igreja/lista";
    }

    @PostMapping("/salvar")
    public String salva(@Valid Igreja igreja, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "igreja/cadastro";
        }

        service.salvar(igreja);
        attr.addFlashAttribute("success", "Igreja inserida com sucesso.");
        return "redirect:/igreja/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("igreja", service.buscarPorId(id));
        return "igreja/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Igreja igreja, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "igreja/cadastro";
        }

        service.editar(igreja);
        attr.addFlashAttribute("success", "Igreja editada com sucesso.");
        return "redirect:/igreja/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        service.excluir(id);
        model.addAttribute("success", "Igreja excluído com sucesso.");

        return listar(model);
    }
}
