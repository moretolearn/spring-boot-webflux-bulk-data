package com.moretolearn;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Flux<Employee> loadEmployees() {
        return repository.streamAll().limitRate(1000);
//                .doOnNext(e ->
//                        System.out.println("DB → " + e.id())
//                );
    }
}
