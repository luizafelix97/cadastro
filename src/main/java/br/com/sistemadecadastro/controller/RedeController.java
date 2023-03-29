package br.com.sistemadecadastro.controller;

import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.domain.Rede;
import br.com.sistemadecadastro.service.MinisterioService;
import br.com.sistemadecadastro.service.RedeService;
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
@RequestMapping("/rede")
public class RedeController {
    @Autowired
    private RedeService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Rede rede) {
        return "rede/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("rede", service.buscarTodos());
        return "rede/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Rede rede, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "rede/cadastro";
        }

        service.salvar(rede);
        attr.addFlashAttribute("success", "Rede inserido com sucesso.");
        return "redirect:/rede/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("rede", service.buscarPorId(id));
        return "rede/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Rede rede, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "rede/cadastro";
        }

        service.editar(rede);
        attr.addFlashAttribute("success", "Rede editado com sucesso.");
        return "redirect:/rede/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        if (service.redeTemCargos(id)) {
            model.addAttribute("fail", "Rede não removido. Possui cargo(s) vinculado(s).");
        } else {
            service.excluir(id);
            model.addAttribute("success", "Rede excluído com sucesso.");
        }

        return listar(model);
    }
}
