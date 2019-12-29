package ch.iw.edumago.service.impl;

import ch.iw.edumago.dto.StudentDTO;
import ch.iw.edumago.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements StudentService {

    @Override
    public StudentDTO create(StudentDTO student) {
        return null;
    }
}
