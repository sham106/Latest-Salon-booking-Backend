package com.example.cutesalon.controller;

import com.example.cutesalon.model.Appointment;
import com.example.cutesalon.service.AppointmentService;
import com.example.cutesalon.service.EmailSendServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "https://cutesalon.vercel.app", allowCredentials = "true", allowedHeaders = "*")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final EmailSendServiceImp emailSendServiceImp;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, EmailSendServiceImp emailSendServiceImp) {
        this.appointmentService = appointmentService;
        this.emailSendServiceImp = emailSendServiceImp;
    }

    @PostMapping("/add")
    public String  add(@RequestBody Appointment appointment){
        appointmentService.saveAppointment(appointment);

        String to = appointment.getEmail(); // Get the user's email from the appointment object
        String subject = "Appointment Confirmation";
        String text = "Dear " + appointment.getName() + ",\n\n" +
                "Your appointment for " + appointment.getServiceName() + " on " + appointment.getDate() +
                " at " + appointment.getTime() + " has been confirmed.\n\n" +
                "Thank you for choosing our salon.\n\n" +
                "Best regards,\n" +
                "Your Salon Team";
        emailSendServiceImp.sendEmail(to, subject, text);

        return "New Application Done!!";
    }
       
    

    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable int id){
        appointmentService.deleteService(id);
    }
}


