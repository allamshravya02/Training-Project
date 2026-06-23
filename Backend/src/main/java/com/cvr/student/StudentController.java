package com.cvr.student;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")

 class StudentController {

	private StudentService ss;
	public StudentController(StudentService ss) {
		this.ss=ss;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Student st) {
		ss.save(st);
	}
	@GetMapping("/{id}")
	public Student find (@PathVariable Integer id) {
		return ss.find(id).get();
	}
	@GetMapping
	public List<Student> findAll(){
		return ss.findAll();
	}
	@PutMapping("/{id}")
	public Student update(
	        @PathVariable Integer id,
	        @RequestBody Student st) {

	    return ss.update(id, st);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	    ss.delete(id);
	}
	
}
