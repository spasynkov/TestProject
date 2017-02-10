package net.ukrtel.ddns.ff.controllers;

import net.ukrtel.ddns.ff.domain.Appliant;
import net.ukrtel.ddns.ff.domain.Job;
import net.ukrtel.ddns.ff.exceptions.DuplicateEmailForAppliantException;
import net.ukrtel.ddns.ff.exceptions.NoAppliantForJobRequestedException;
import net.ukrtel.ddns.ff.services.AppliantsService;
import net.ukrtel.ddns.ff.services.AppliesService;
import net.ukrtel.ddns.ff.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/jobs")
public class JobsController {
    private JobsService jobsService;
    private AppliesService appliesService;
    private AppliantsService appliantsService;

    @Autowired
    public JobsController(JobsService jobsService, AppliesService appliesService, AppliantsService appliantsService) {
        this.jobsService = jobsService;
        this.appliesService = appliesService;
        this.appliantsService = appliantsService;
    }

    @RequestMapping(method = GET)
    public String listJobs(Model model) {
        model.addAttribute("jobsList", jobsService.getAllJobs());
        return "jobs";
    }

    @RequestMapping(value = "/apply/*", method = GET)
    public String showForm(Model model) {

        model.addAttribute(new Appliant());
        return "applyForm";
    }

    @RequestMapping(value = "/apply/{jobId}", method = POST)
    public String apply(@PathVariable("jobId") int jobId,
                        RedirectAttributes model,
                        HttpServletRequest request,
                        @Valid Appliant appliant,
                        Errors errors) {

        // checking if there were some errors while submitting th form
        if (errors.hasErrors()) {
            return "applyForm";
        }

        Job job = jobsService.findOne(jobId);

        // checking if person identified by email already applied to this job
        if (appliantsService.isAppliantWithEmailExists(appliesService.getAllAppliantsByJob(job), appliant.getEmail())) {
            throw new DuplicateEmailForAppliantException("Email '" + appliant.getEmail() + "' is already in use.");
        }

        appliesService.createNewApply(
                appliant,
                job,
                request);

        model.addFlashAttribute(appliant);

        return "redirect:/jobs/{jobId}";
    }

    @RequestMapping(value = "/{jobId}", method = GET)
    public String applied(@PathVariable("jobId") int jobId,
                          Model model) {

        if (!model.containsAttribute("appliant")) {
            throw new NoAppliantForJobRequestedException("" + jobId);
        }
        model.addAttribute(jobsService.getJobDescription(jobId));
        return "applied";
    }
}
