package com.projetfinal.etablissement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "introuvable")
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4877553019536336845L;

}
