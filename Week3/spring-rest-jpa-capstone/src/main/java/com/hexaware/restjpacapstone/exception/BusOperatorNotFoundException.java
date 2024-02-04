package com.hexaware.restjpacapstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


//	public class BusOperatorNotFoundException extends RuntimeException {
//
//	    public BusOperatorNotFoundException(String msg) {
//	        super(msg);
//	    }
//	}

public class BusOperatorNotFoundException extends ResponseStatusException {

    public BusOperatorNotFoundException(HttpStatus status, String msg) {
        super(status, msg);
    }
}