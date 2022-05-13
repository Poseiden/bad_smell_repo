package timecard.mgmt.dao.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import timecard.mgmt.bean.Effort;

@Repository
public interface EffortRepoJPA extends JpaRepository<Effort, String> {
}
