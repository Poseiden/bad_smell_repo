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
public class Employee {
    private String id;
    private List<String> assignmentIds;
    private List<String> effortIds;
    private List<String> timeCardIds;
}
