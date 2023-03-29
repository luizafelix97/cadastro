package br.com.sistemadecadastro.conversor;

import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.service.MinisterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

;

@Component
public class StringToDepartamentoConverter implements Converter<String, Ministerio> {
	
	@Autowired
	private MinisterioService service;

	@Override
	public Ministerio convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
