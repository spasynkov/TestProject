package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.AppliantsRepository;
import net.ukrtel.ddns.ff.domain.Appliant;
import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliantsService {
    @Autowired
    private AppliantsRepository appliantsRepository;

    public void addAppliantWithJob(Appliant appliant, Job job) {
        appliant.setJob(job);
        //appliantsRepository.add(appliant);
        appliantsRepository.save(appliant);
    }
}
