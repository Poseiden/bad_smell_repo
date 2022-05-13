package timecard.mgmt.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subproject {
    private String id;
    private List<String> effortIds;
    private List<String> subEntries;
}
