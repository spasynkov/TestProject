package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.AppliantsRepository;
import net.ukrtel.ddns.ff.data.AppliesRepository;
import net.ukrtel.ddns.ff.domain.Appliant;
import net.ukrtel.ddns.ff.domain.Apply;
import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
public class AppliesService {
    @Autowired
    private AppliesRepository appliesRepository;

    @Autowired
    private AppliantsRepository appliantsRepository;


    public void createNewApply(Appliant appliant, Job job, HttpServletRequest request) {
        Apply apply = new Apply();

        Appliant newAppliant = appliantsRepository.findAppliantByEmail(appliant.getEmail());
        // if there is no such appliant in database
        // or if there is one with same email, but with different other values
        if (newAppliant == null || !areAppliantsEquals(appliant, newAppliant)) {
            // saving appliant from the form into the database
            newAppliant = appliantsRepository.save(appliant);
        }
        apply.setAppliant(newAppliant);

        apply.setJob(job);
        apply.setIp(request.getRemoteAddr());               // setting client's ip
        apply.setTimestamp(System.currentTimeMillis());     // setting timestamp of client's request

        appliesRepository.save(apply);
    }

    public List<Appliant> getAllAppliantsByJob(Job job) {
        List<Appliant> appliants = new LinkedList<>();
        for (Apply apply : appliesRepository.findAllByJob(job)) {
            appliants.add(apply.getAppliant());
        }
        return appliants;
    }

    private boolean areAppliantsEquals(Appliant appliantFromForm, Appliant appliantFromDatabse) {
        return appliantFromDatabse.getEmail().equals(appliantFromForm.getEmail())
                && appliantFromDatabse.getFirstname().equals(appliantFromForm.getFirstname())
                && appliantFromDatabse.getSurname().equals(appliantFromForm.getSurname())
                && appliantFromDatabse.getDescription().equals(appliantFromForm.getDescription());
    }
}
