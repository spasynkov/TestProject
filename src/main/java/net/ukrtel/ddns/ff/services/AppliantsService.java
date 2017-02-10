package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.domain.Appliant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppliantsService {
    public boolean isAppliantWithEmailExists(List<Appliant> appliants, String email) {
        for (Appliant appliant : appliants) {
            if (appliant.getEmail().equals(email)) return true;
        }
        return false;
    }
}
