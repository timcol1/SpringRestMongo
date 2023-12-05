package avlyakulov.timur.SpringRestMongo.sevice;

import avlyakulov.timur.SpringRestMongo.model.Student;
import avlyakulov.timur.SpringRestMongo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student createStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student updateStudent(String id, Student student) {
        Optional<Student> studentById = studentRepository.findById(id);
        studentById.ifPresentOrElse(s -> {
            setAllParametersFromNewStudent(s, student);
            studentRepository.save(s);
        }, () -> {
            throw new IllegalStateException("Student wasn't found");
        });
        return student;
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
        oldStudent.setFavoriteBook(changedStudent.getFavoriteBook());
    }
}
