package timecard.mgmt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class EntryDTO {
    @NonNull
    private String projectId;
    @NonNull
    private List<SubEntryDTO> subEntries;
}
