package timecard.mgmt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class SubmitTimecardDTO {
    @NonNull
    private String employeeId;

    @NonNull
    List<EntryDTO> entries;
}
