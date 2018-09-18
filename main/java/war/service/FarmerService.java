package war.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import war.account.AccountRepository;
import war.model.Farmer;
import war.repository.FarmerRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FarmerService {

    private FarmerRepository farmerRepository;
    private AccountRepository accountRepository;


}

  // private Date current_date = new Date();

//    public void delete(Farmer farmer){
//     if( farmer.getEndDate()== current_date){
//         farmerRepository.delete(farmer);
//        }
//
//    }

