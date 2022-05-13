package timecard.mgmt.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

@Entity
@Table
@Data
@NoArgsConstructor
public class Effort {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Generated(GenerationTime.INSERT)
    private String id;
    private String employeeId;
    private LocalDate workingDay;
    private int workingHours;
    private String locationId;
    private boolean billable;
    private String note;

    private String subProjectId;
    private String projectId;
    @Enumerated(STRING)
    private EffortStatus effortStatus;

    public Effort(String employeeId, LocalDate workingDay, int workingHours, String locationId,
                  boolean billable, String note, String subProjectId, String projectId, EffortStatus effortStatus) {
        this.employeeId = employeeId;
        this.workingDay = workingDay;
        this.workingHours = workingHours;
        this.locationId = locationId;
        this.billable = billable;
        this.note = note;
        this.subProjectId = subProjectId;
        this.projectId = projectId;
        this.effortStatus = effortStatus;
    }
}
