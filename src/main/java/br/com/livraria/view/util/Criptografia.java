package br.com.livraria.view.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Criptografia {
	
	private static PasswordEncoder chave = new BCryptPasswordEncoder();

	public static PasswordEncoder getChave() {
		return chave;
	}

	
}
