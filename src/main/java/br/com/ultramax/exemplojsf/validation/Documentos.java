package br.com.ultramax.exemplojsf.validation;

import java.util.InputMismatchException;

public class Documentos {
	public static boolean validarCPF(String CPF) {
		if (CPF == "00000000000" || CPF == "11111111111" ||
				CPF == "22222222222" || CPF == "33333333333" ||
				CPF == "44444444444" || CPF == "55555555555" ||
				CPF == "66666666666" || CPF == "77777777777" ||
				CPF == "88888888888" || CPF == "99999999999") {
			return false;
		} else {
			char dig10, dig11;
			int sm, i, r, num, peso;
			try {
				sm = 0;
				peso = 10;
				for (i=0; i<9; i++) {
					num = (int)(CPF.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
					dig10 = '0';
				else dig10 = (char)(r + 48);

				sm = 0;
				peso = 11;

				for(i=0; i<10; i++) {
					num = (int)(CPF.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
					dig11 = '0';
				else dig11 = (char)(r + 48);

				if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
					return true;
				else
					return false;

			} catch (InputMismatchException e) {
				return false;
			}
		}
	}
}
