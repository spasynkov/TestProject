package net.ukrtel.ddns.ff.controllers;

import net.ukrtel.ddns.ff.Appliant;
import net.ukrtel.ddns.ff.data.AppliantsRepository;
import net.ukrtel.ddns.ff.data.JobsRepository;
import net.ukrtel.ddns.ff.exceptions.JobsIdOutOfBoundsException;
import net.ukrtel.ddns.ff.exceptions.NoAppliantForJobRequestedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/jobs")
public class JobsController {

    private JobsRepository jobsRepository;
    private AppliantsRepository appliantsRepository;

    @Autowired
    public JobsController(JobsRepository jobsRepository, AppliantsRepository appliantsRepository) {
        this.jobsRepository = jobsRepository;
        this.appliantsRepository = appliantsRepository;
    }

    @RequestMapping(method = GET)
    public String listJobs(Model model) {
        model.addAttribute("jobsList", jobsRepository.getAll());
        return "jobs";
    }

    @RequestMapping(value = "/apply/{jobId}", method = GET)
    public String showForm(@PathVariable int jobId,
                           Model model) {

        checkJobId(jobId);
        model.addAttribute(new Appliant(jobsRepository.findOne(jobId)));
        return "applyForm";
    }

    @RequestMapping(value = "/apply/{jobId}", method = POST)
    public String apply(@PathVariable("jobId") int jobId,
                        RedirectAttributes model,
                        @Valid Appliant appliant,
                        Errors errors) {

        checkJobId(jobId);
        if (errors.hasErrors()) {
            model.addAttribute(appliant);
            return "applyForm";
        }

        appliantsRepository.add(appliant);
        model.addFlashAttribute(appliant);

        return "redirect:/jobs/{jobId}";
    }

    @RequestMapping(value = "/{jobId}", method = GET)
    public String applied(@PathVariable("jobId") int jobId,
                          Model model) {

        checkJobId(jobId);
        if (!model.containsAttribute("appliant")) {
            throw new NoAppliantForJobRequestedException("" + jobId);
        }
        model.addAttribute(jobId);
        return "applied";
    }

    private void checkJobId(int jobId) {
        if (jobId < 0 || jobId >= jobsRepository.getAll().size())
            throw new JobsIdOutOfBoundsException("No job with id #" + jobId);
    }
}
