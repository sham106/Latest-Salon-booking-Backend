package com.example.cutesalon.service;

import com.example.cutesalon.model.Appointment;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AppointmentService {
    public Appointment saveAppointment(Appointment appointment);
    public List<Appointment> getAllAppointments();

    void deleteService(int id);

}
