package com.foodtruck.api.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.servlet.http.HttpServletRequest

import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity.status

@ControllerAdvice
class ExceptionsHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun objectNotFound(exception: Exception, request: HttpServletRequest): ResponseEntity<*> {
        val err = ExceptionsAttributes(exception.message, exception.localizedMessage, request.requestURI, System.currentTimeMillis())
        return status(NOT_FOUND).body(err)
    }
}
