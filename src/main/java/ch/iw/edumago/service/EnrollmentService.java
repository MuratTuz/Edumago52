package ch.iw.edumago.service;

import ch.iw.edumago.model.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDTO create(EnrollmentDTO enrollment);

    List<EnrollmentDTO> findAll();

    EnrollmentDTO findById(Long id);

}
