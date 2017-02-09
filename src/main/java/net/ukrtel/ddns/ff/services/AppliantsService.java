package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.AppliantsRepository;
import net.ukrtel.ddns.ff.domain.Appliant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliantsService {
    @Autowired
    AppliantsRepository appliantsRepository;

    public boolean isAppliantWithEmailExists(String email) {
        Appliant appliant = appliantsRepository.findAppliantByEmail(email);

        return appliant != null;
    }
}
