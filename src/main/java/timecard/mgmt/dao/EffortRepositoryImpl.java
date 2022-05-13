package timecard.mgmt.dao;

import org.springframework.stereotype.Repository;
import timecard.mgmt.bean.Effort;
import timecard.mgmt.bean.EffortRepository;
import timecard.mgmt.dao.hibernate.EffortRepoJPA;

import java.util.List;

@Repository
public class EffortRepositoryImpl  implements EffortRepository {
    private final EffortRepoJPA effortRepoJPA;

    public EffortRepositoryImpl(EffortRepoJPA effortRepoJPA) {
        this.effortRepoJPA = effortRepoJPA;
    }

    @Override
    public void saveAll(List<Effort> efforts) {
        this.effortRepoJPA.saveAll(efforts);
    }
}
