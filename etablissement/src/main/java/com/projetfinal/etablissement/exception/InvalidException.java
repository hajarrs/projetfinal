package com.projetfinal.etablissement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST, reason = "donnees invalides")
public class InvalidException extends RuntimeException {

	private static final long serialVersionUID = 8727350019080553722L;

}