package war.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import war.account.AccountRepository;
import war.model.Farmer;

import java.util.List;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Long > {


List<Farmer> findFarmersByWojewodztwo(String wojewodztwo);


List<Farmer> findByLogin (String login);
//    @Query(" from Farmer where login like 'admin'")
//      List<Farmer> getByLogin();


}
