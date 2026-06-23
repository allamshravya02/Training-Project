package com.cvr.student;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private StudentRepo sr;
	public StudentService(StudentRepo sr) {
		this.sr=sr;
	}
	public void save(Student st){
		sr.save(st);
	}
	public Optional<Student> find(int id) {
		return sr.findById(id);
	}
	public List<Student> findAll(){
		return sr.findAll();
	}
	public Student update(int id, Student st) {

	    Student existing = sr.findById(id)
	            .orElseThrow();

	    existing.setName(st.getName());
	    existing.setRollno(st.getRollno());
	    existing.setCourse(st.getCourse());

	    return sr.save(existing);
	}

	public void delete(int id) {
	    sr.deleteById(id);
	}
}
