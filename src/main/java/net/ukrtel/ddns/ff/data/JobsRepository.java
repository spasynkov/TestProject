package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Job;

import java.util.List;

public interface JobsRepository {
    List<Job> getAll();
    Job findOne(long id);
}
