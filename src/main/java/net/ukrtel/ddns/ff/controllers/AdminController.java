package net.ukrtel.ddns.ff.controllers;

import net.ukrtel.ddns.ff.domain.Job;
import net.ukrtel.ddns.ff.services.JobsService;
import net.ukrtel.ddns.ff.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UsersService usersService;
    private JobsService jobsService;

    @Autowired
    public AdminController(UserDetailsService usersService, JobsService jobsService) {
        this.usersService = (UsersService) usersService;
        this.jobsService = jobsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAdminSection() {
        return "admin";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String manageUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "admin/users";
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String manageJobs(Model model) {
        if (!model.containsAttribute("jobs")) {
            model.addAttribute("jobs", jobsService.getAllJobs());
        }
        return "admin/jobs";
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public String addOrEditJob(@Valid Job job, Errors errors) {
        if (errors.hasErrors()) {
            return "admin/jobs";
        }

        jobsService.save(job);
        return "redirect:/admin/jobs";
    }

    @RequestMapping("/jobs/delete/{jobId}")
    public String deleteJob(@PathVariable long jobId,
                            RedirectAttributes model) {

        model.addFlashAttribute(jobsService.findOne(jobId));
        jobsService.deleteJobById(jobId);
        return "redirect:/admin/jobs";
    }
}
