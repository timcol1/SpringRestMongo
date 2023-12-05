package avlyakulov.timur.SpringRestMongo.mapper;

import avlyakulov.timur.SpringRestMongo.dto.StudentDTO;
import avlyakulov.timur.SpringRestMongo.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toStudentDTO(Student student);

    Student toStudentModel(StudentDTO studentDTO);
}