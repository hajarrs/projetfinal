package com.projetfinal.etablissement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST, reason = "ajout impossible")
public class OverlapException extends RuntimeException {

	private static final long serialVersionUID = 7563018934494937481L;

}
