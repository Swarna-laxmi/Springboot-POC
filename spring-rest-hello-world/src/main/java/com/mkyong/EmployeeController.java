package com.mkyong;

import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
import com.mkyong.error.EmployeeNotFoundException;
import com.mkyong.error.EmployeeUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // Find
    @GetMapping("/employees")
    List<Employee> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/employees")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Find
    @GetMapping("/employees/{id}")
    Employee findOne(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // Save or update
    @PutMapping("/employees/{id}")
    Employee saveOrUpdate(@RequestBody Employee newEmployee, @PathVariable int id) {

        return repository.findById(id)
                .map(x -> {
                    x.setFirstName(newEmployee.getFirstName());
                    x.setLastName(newEmployee.getLastName());
                    //x.setDob(newEmployee.getDob());
                    x.setEmpId(newEmployee.getEmpId());
                    x.setEmailId(newEmployee.getEmailId());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    // update author only
    @PatchMapping("/employees/{id}")
    Employee patch(@RequestBody Map<String, String> update, @PathVariable int id) {

        return repository.findById(id)
                .map(x -> {

                    String empId = update.get("empId");
                    if (!StringUtils.isEmpty(empId)) {
                        x.setEmailId(empId);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new EmployeeUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new EmployeeNotFoundException(id);
                });

    }

    @DeleteMapping("/employees/{id}")
    void deleteBook(@PathVariable int id) {
        repository.deleteById(id);
    }

}
