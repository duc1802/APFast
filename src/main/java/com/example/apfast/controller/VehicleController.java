package com.example.apfast.controller;


import com.example.apfast.model.Member;
import com.example.apfast.model.Vehicle;
import com.example.apfast.service.MemberService;
import com.example.apfast.service.VehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Optional<Member> optionalMember = memberService.findByUserId(username);
        if (optionalMember.isPresent() && optionalMember.get().getPassword().equals(password)) {
            session.setAttribute("user", optionalMember.get());
            if ("admin".equals(optionalMember.get().getRole())) {
                return "redirect:/admin/welcome";
            } else if ("sale".equals(optionalMember.get().getRole())) {
                return "redirect:/sale/welcome";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Destroy session
        return "redirect:/";
    }

    @GetMapping("/admin/welcome")
    public String adminWelcome(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "admin-welcome";
    }

    @GetMapping("/sale/welcome")
    public String saleWelcome(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "sale-welcome";
    }
}
