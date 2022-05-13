package timecard.mgmt.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Timecard {
    private String id;
    private String employeeId;
    private Period period;
    private int totalHours;
    private List<Entry> entries;
}
