package timecard.mgmt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import timecard.mgmt.dto.SubmitTimecardDTO;
import timecard.mgmt.service.TimecardService;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class TimecardController {

    private final TimecardService timecardService;

    public TimecardController(TimecardService timecardService) {
        this.timecardService = timecardService;
    }

    @PostMapping("/timecards/submit")
    @ResponseStatus(OK)
    public void submitTimecard(@RequestBody SubmitTimecardDTO submitTimecardDto) {
        //讲师注释：bad smell，直接调用了，没有区分 application 和 domain service
        this.timecardService.save(submitTimecardDto);
    }

}
