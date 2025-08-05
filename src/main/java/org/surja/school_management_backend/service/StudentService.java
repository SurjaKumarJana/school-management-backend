package org.surja.school_management_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surja.school_management_backend.entity.Student;
import org.surja.school_management_backend.repository.StudentRepo;


import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student getById(Long id){
        try{
            Student existingStd = studentRepo.findById(id).get();
            return existingStd;
        }catch (NoSuchElementException e){
            return  null;
        }
    }

    public Student create(Student student){
        Student newStd = studentRepo.save(student);
        return  newStd;
    }

    public Student update(Long id,Student student){
        try{
            Student existingStd = studentRepo.findById(id).get();

            existingStd.setName(student.getName());
            existingStd.setEmail(student.getEmail());
            existingStd.setCgpa(student.getCgpa());
            existingStd.setDept(student.getDept());

            studentRepo.save(existingStd);

            return existingStd;
        }catch (NoSuchElementException e){
            return  null;
        }

    }

    public Student delete(Long id){
        try{
            Student existingStd = studentRepo.findById(id).get();
            studentRepo.delete(existingStd);
            return existingStd;
        }catch (NoSuchElementException e){
            return  null;
        }
    }


}
