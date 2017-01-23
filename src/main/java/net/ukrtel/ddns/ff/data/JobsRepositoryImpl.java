package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobsRepositoryImpl implements JobsRepository {

    private static long lastId = 0;
    private List<Job> list = new ArrayList<Job>();

    public JobsRepositoryImpl() {
        list.add(new Job(lastId++, "Super cool job #1"));
        list.add(new Job(lastId++, "Super cool job #2"));
        list.add(new Job(lastId++, "Super cool job #3"));
        list.add(new Job(lastId++, "Super cool job #4"));
    }

    public Job findOne(long id) {
        return list.get((int) id);
    }

    public List<Job> getAll() {
        return list;
    }

    public void add(Job job) {
        if (job.getId() == null) job.setId(lastId++);
        list.add(job);
    }

    public void update(Job job) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(job.getId())) {
                list.remove(i);
                break;
            }
        }
        add(job);
    }

    public void delete(long jobId) {
        list.remove((int) jobId);
    }

    public void delete(Job job) {
        list.remove(job);
    }
}
