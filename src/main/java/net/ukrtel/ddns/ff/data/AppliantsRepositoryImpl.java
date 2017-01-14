package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.Appliant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppliantsRepositoryImpl implements AppliantsRepository {
    private List<Appliant> list = new ArrayList<Appliant>();

    public void add(Appliant appliant) {
        list.add(appliant);
        appliant.setId(list.size() - 1);
    }
}
