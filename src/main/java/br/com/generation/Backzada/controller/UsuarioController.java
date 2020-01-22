package br.com.generation.Backzada.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.Backzada.model.Usuario;
import br.com.generation.Backzada.security.Token;
import br.com.generation.Backzada.security.Autenticator;


@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
		if(usuario.getEmail().equals("italo@italo.com")&& usuario.getSenha().equals("123456")) {
		
			//Sumilando que recuperou o usuario do banco de dados
			usuario.setId(1);
			usuario.setNome("italo andrew");
			
			//contruindo o token
			
			String tk = Autenticator.generateToken(usuario);
			System.out.println ("Token Gerado = "+tk);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
			
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
	
}