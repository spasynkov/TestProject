package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Job;

import java.util.List;

public interface JobsRepository {
    Job findOne(long id);
    List<Job> getAll();
    void add(Job job);
    void update(Job job);
    void delete(long jobId);
    void delete(Job job);
}
