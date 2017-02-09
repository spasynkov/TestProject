package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.Appliant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliantsRepository extends JpaRepository<Appliant, Long> {

    Appliant findAppliantByEmail(String email);
}
