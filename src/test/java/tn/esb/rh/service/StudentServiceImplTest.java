package tn.esb.rh.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esb.rh.entity.Student;
import tn.esb.rh.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService ;

    Student student = new Student(1, "name1","adress1", 20.00);
    List<Student> listStudents = new ArrayList<Student>() {
        {
            add(new Student(2, "name2","adress2", 30.00));
            add(new Student(3, "name3","adress3", 10.00));
        }
    };


    @Test
    @Order(2)
    public void testRetrieveAllStudents() {

        Mockito.when(studentRepository.findAll()).thenReturn(listStudents);

        List<Student> listU = studentService.getStudents();

        Assertions.assertEquals(2, listU.size());
    }


   /* @Test
    @Order(3)
    public void testAddStudent() {

        Mockito.when(studentRepository.save(Mockito.anyObject())).
                thenReturn(listStudents.add(student));


        studentService.registerStudent(student);

        Assertions.assertEquals(3, listStudents.size());
    }


    @Test
    @Order(4)
    public void testRemoveStudent() {


        Mockito.when(studentRepository.deleteById(listStudents.get(0).getRollNumber())).
         then(listStudents.remove(0));



        Assertions.assertEquals(2, listStudents.size());
    }


    */
}
