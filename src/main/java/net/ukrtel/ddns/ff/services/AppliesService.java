package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.AppliantsRepository;
import net.ukrtel.ddns.ff.data.AppliesRepository;
import net.ukrtel.ddns.ff.domain.Appliant;
import net.ukrtel.ddns.ff.domain.Apply;
import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AppliesService {
    @Autowired
    private AppliesRepository appliesRepository;

    @Autowired
    private AppliantsRepository appliantsRepository;


    public void createApplyFromAppliantAndJob(Appliant appliant, Job job, HttpServletRequest request) {
        Apply apply = new Apply();
        apply.setAppliant(appliantsRepository.save(appliant));
        apply.setJob(job);
        apply.setIp(request.getRemoteAddr());
        apply.setTimestamp(System.currentTimeMillis());

        appliesRepository.save(apply);
    }
}
