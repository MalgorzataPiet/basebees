package war.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import war.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Long > {




}
