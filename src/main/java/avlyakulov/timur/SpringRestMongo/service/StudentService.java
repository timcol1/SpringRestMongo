package avlyakulov.timur.SpringRestMongo.service;

import avlyakulov.timur.SpringRestMongo.exceptions.ModelNotFoundException;
import avlyakulov.timur.SpringRestMongo.exceptions.NumberOfPassportAlreadyExists;
import avlyakulov.timur.SpringRestMongo.model.Student;
import avlyakulov.timur.SpringRestMongo.repository.StudentCriteriaRepositoryImpl;
import avlyakulov.timur.SpringRestMongo.repository.StudentRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentCriteriaRepositoryImpl studentCriteriaRepository;

    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String PASSPORT = "numberPassport";


    public StudentService(StudentRepository studentRepository, StudentCriteriaRepositoryImpl studentCriteriaRepository) {
        this.studentRepository = studentRepository;
        this.studentCriteriaRepository = studentCriteriaRepository;
    }


    public List<Student> getAllStudents(Map<String, String> params) {
        if (params.isEmpty()) {
            return studentRepository.findAll();
        }
        List<Criteria> criteriaList = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            switch (entry.getKey()) {
                case "name" -> criteriaList.add(createCriteriaIs(NAME, entry.getValue()));
                case "age" -> {
                    List<String> ages = List.of(entry.getValue().split("-"));
                    criteriaList.add(createCriteriaBetween(AGE, ages.get(0), ages.get(1)));
                }
                case "numberPassport" -> {
                    List<String> passports = List.of(entry.getValue().split("-"));
                    criteriaList.add(createCriteriaBetween(PASSPORT, passports.get(0), passports.get(1)));
                }
            }
        }


        return studentCriteriaRepository.findAll(new Query().addCriteria(new Criteria().andOperator(criteriaList)));

    }

    private Criteria createCriteriaIs(String key, String param) {
        return Criteria.where(key).is(param);
    }

    private Criteria createCriteriaIn(String key, List<String> params) {
        return Criteria.where(key).in(params);
    }

    private Criteria createCriteriaBetween(String key, String firstValue, String secondValue) {
        return Criteria.where(key).gte(firstValue).lte(secondValue);
    }

    @Transactional
    public Student createStudent(Student student) {
        checkStudentByNumberOfPassport(student);
        return studentRepository.save(student);
    }


    @Transactional
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student updateStudent(String id, Student updatedStudent) {
        Optional<Student> studentById = studentRepository.findById(id);
        studentById.ifPresentOrElse(s -> {
            setAllParametersFromNewStudent(s, updatedStudent);
            studentRepository.save(s);
        }, () -> {
            throw throwModelNotFoundException(id);
        });
        return updatedStudent;
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> throwModelNotFoundException(id));
    }

    private ModelNotFoundException throwModelNotFoundException(String id) {
        return new ModelNotFoundException(HttpStatus.NOT_FOUND, String.format("Student with such id %s doesn't exist", id));
    }

    private void checkStudentByNumberOfPassport(Student student) {
        Student studentByNumberPassport = studentRepository.findStudentByNumberPassport(student.getNumberPassport());
        if (studentByNumberPassport != null) {
            throw new NumberOfPassportAlreadyExists(HttpStatus.BAD_REQUEST, String.format("Student with such number passport %s already exists", student.getNumberPassport()));
        }
    }

    private void setAllParametersFromNewStudent(Student student, Student updatedStudent) {
        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
    }


}
