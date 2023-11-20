package avlyakulov.timur.SpringRestMongo.sevice;

import avlyakulov.timur.SpringRestMongo.model.Address;
import avlyakulov.timur.SpringRestMongo.model.Gender;
import avlyakulov.timur.SpringRestMongo.model.Student;
import avlyakulov.timur.SpringRestMongo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(String id, Student student) {
        Optional<Student> studentById = studentRepository.findById(id);
        studentById.ifPresentOrElse(s -> {
            setAllParametersFromNewStudent(s, student);
        }, () -> {
            throw new IllegalStateException("Student wasn't found");
        });
        return studentById.get();
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void setAllParametersFromNewStudent(Student oldStudent, Student changedStudent) {
        oldStudent.setFirstName(changedStudent.getFirstName());
        oldStudent.setLastName(changedStudent.getLastName());
        oldStudent.setEmail(changedStudent.getEmail());
        oldStudent.setGender(changedStudent.getGender());
        oldStudent.setAddress(changedStudent.getAddress());
        oldStudent.setFavouriteSubjects(changedStudent.getFavouriteSubjects());
        oldStudent.setTotalSpentInBooks(changedStudent.getTotalSpentInBooks());
    }
}
