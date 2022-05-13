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
public class Entry {
    private int hours;
    private String projectId;
    private List<SubEntry> subEntries;
}
