package ch.iw.edumago.service;

import ch.iw.edumago.model.EnrollmentDTO;

public interface EnrollmentService {

    EnrollmentDTO create(EnrollmentDTO enrollment);
    Long add(EnrollmentDTO enrollmentDTO);
}
