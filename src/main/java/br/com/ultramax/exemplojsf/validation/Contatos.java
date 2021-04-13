package br.com.ultramax.exemplojsf.validation;

import java.util.regex.Pattern;

public class Contatos {
	public static boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern emailVal = Pattern.compile(regex);
		if (email == null)
			return false;
		else
			return emailVal.matcher(email).matches();
	}
	
	public static boolean validarTelefone(String telefone) {
		try {
			Long.parseLong(telefone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
