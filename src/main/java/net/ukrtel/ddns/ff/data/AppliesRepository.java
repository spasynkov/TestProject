package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Apply;
import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliesRepository extends JpaRepository<Apply, Long> {
    List<Apply> findAllByJob(Job job);
}
