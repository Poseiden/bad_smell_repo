package timecard.mgmt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class EffortDTO {
    @NonNull
    private String date;
    private int workingHours;
    @NonNull
    private String note;
}
