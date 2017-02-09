package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliesRepository extends JpaRepository<Apply, Long> {
}
