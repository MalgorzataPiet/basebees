package war.service;

import war.model.Farmer;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FarmerService {
    private List<Farmer> farmers = new ArrayList<>();

    public List<Farmer> search(String login, String wojewodztwo, String uprawa) {
        return farmers.stream()
                .filter(farmer -> farmer.getLogin().contains(login))
                .filter(farmer -> farmer.getWojewodztwo().contains(wojewodztwo))
                .filter(farmer -> farmer.getUprawa().contains(uprawa))
                .collect(toList());
    }
}
