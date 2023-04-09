package br.com.sistemadecadastro.validator;

import java.time.LocalDate;

import br.com.sistemadecadastro.domain.Membros;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Membros.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Membros f = (Membros) object;
		
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
