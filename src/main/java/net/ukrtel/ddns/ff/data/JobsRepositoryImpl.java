package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobsRepositoryImpl implements JobsRepository {

    private List<Job> list = new ArrayList<Job>();

    public JobsRepositoryImpl() {
        list.add(new Job(list.size(), "Super cool job #1"));
        list.add(new Job(list.size(), "Super cool job #2"));
        list.add(new Job(list.size(), "Super cool job #3"));
        list.add(new Job(list.size(), "Super cool job #4"));
    }

    public List<Job> getAll() {
        return list;
    }

    public Job findOne(long id) {
        return list.get((int) id);
    }
}
