package com.bitsatom.schoolify.config;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bitsatom.schoolify.exception.SchoolifyException;
import com.google.common.collect.Maps;

@ControllerAdvice
public class SchoolifyExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({SchoolifyException.class})
    public @ResponseBody Map<String, Object> handleRequestException(Exception ex) {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Request Error");
        map.put("cause", ex.getMessage());
        return map;
    }

}
