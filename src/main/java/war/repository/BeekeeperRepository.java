package war.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import war.model.Beekeeper;

import java.util.List;

/*@Repository*/
public interface BeekeeperRepository  extends JpaRepository<Beekeeper, Long> {

    List<Beekeeper> findByWojewodztwo(String wojewodztwo);
    List<Beekeeper> findByWojewodztwoContaining(String wojewodztwo);
    List<Beekeeper> findByWojewodztwoContainingIgnoreCase(String wojewodzwto);

}

