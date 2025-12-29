package com.moretolearn.service;

import org.springframework.stereotype.Service;

import com.moretolearn.entity.Employee;
import com.moretolearn.repository.EmployeeRepository;

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
