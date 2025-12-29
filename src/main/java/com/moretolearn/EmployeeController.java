package com.moretolearn;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(
        value = "/stream",
        produces = MediaType.APPLICATION_NDJSON_VALUE
    )
    public Flux<Employee> streamEmployees() {
        return service.loadEmployees()
        		 .buffer(250)
        	        .flatMap(Flux::fromIterable);
    }
}

