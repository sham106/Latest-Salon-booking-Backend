package com.example.cutesalon.service;

import com.example.cutesalon.model.Appointment;
import com.example.cutesalon.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment saveAppointment(Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteService(int id) {
        appointmentRepository.deleteById(id);
    }
}
