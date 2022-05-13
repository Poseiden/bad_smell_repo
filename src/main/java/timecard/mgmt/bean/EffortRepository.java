package timecard.mgmt.bean;

import java.util.List;

public interface EffortRepository {
    void saveAll(List<Effort> efforts);
}
