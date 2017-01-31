package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {
}
