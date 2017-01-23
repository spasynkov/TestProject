package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.JobsRepository;
import net.ukrtel.ddns.ff.domain.Job;
import net.ukrtel.ddns.ff.exceptions.JobsIdOutOfBoundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    private JobsRepository jobsRepository;

    @Autowired
    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public List<Job> getAllJobs() {
        return jobsRepository.getAll();
    }

    public Job findOne(long jobId) {
        checkJobId(jobId);
        return jobsRepository.findOne(jobId);
    }

    public String getJobDescription(long jobId) {
        checkJobId(jobId);
        return jobsRepository.findOne(jobId).getDescription();
    }

    private void checkJobId(long jobId) {
        if (jobId < 0 || jobId >= jobsRepository.getAll().size())
            throw new JobsIdOutOfBoundsException("No job with id #" + jobId);
    }

    public void deleteJobById(long id) {
        checkJobId(id);
        jobsRepository.delete(id);
    }

    public void save(Job job) {
        if (job.getId() == null) jobsRepository.add(job);
        else jobsRepository.update(job);
    }
}
