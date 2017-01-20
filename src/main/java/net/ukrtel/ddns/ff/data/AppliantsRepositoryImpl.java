package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.Appliant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppliantsRepositoryImpl implements AppliantsRepository {
    private final List<Appliant> list = new ArrayList<Appliant>();

    public int add(Appliant appliant) {
        int result;

        synchronized (list) {
            list.add(appliant);
            result = list.size();
        }

        appliant.setId(result - 1);

        return result;
    }
}
