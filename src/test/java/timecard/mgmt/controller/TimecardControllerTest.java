package timecard.mgmt.controller;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import timecard.mgmt.base.APIBaseTest;
import timecard.mgmt.bean.Effort;
import timecard.mgmt.bean.VerifyProjectExistDTO;
import timecard.mgmt.dao.hibernate.EffortRepoJPA;
import timecard.mgmt.dto.EffortDTO;
import timecard.mgmt.dto.EntryDTO;
import timecard.mgmt.dto.SubEntryDTO;
import timecard.mgmt.dto.SubmitTimecardDTO;
import timecard.mgmt.proxy.ProjectServiceProxy;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static timecard.mgmt.exception.ErrorKey.PROJECTS_OR_SUBPROJECTS_NOT_EXIST;

public class TimecardControllerTest extends APIBaseTest {
    @MockBean
    private ProjectServiceProxy projectService;
    @Autowired
    private EffortRepoJPA effortRepoJPA;


    @Test
    public void testSubmitTimecard_1() throws Exception {
        //given
        when(projectService.verifyData(any())).thenReturn(Lists.newArrayList());

        //when and then
        SubmitTimecardDTO submitTimeCardDTO = buildSubmitTimeCardDTO();
        this.mockMvc.perform(post("/timecards/submit")
                        .contentType(APPLICATION_JSON)
                        .content(JSON.toJSONString(submitTimeCardDTO)))
                .andExpect(status().isOk());

	Effort effort = this.effortRepoJPA.findAll().get(0);
        System.out.println(effort.getId());
        System.out.println(effort.getProjectId());
        System.out.println(effort.getSubProjectId());
        System.out.println(effort.getEmployeeId());
        System.out.println(effort.getEffortStatus());

    }

    @Test
    public void testSubmitTimecard_2() throws Exception {
        //given
        when(projectService.verifyData(any())).
                thenReturn(Lists.newArrayList(new VerifyProjectExistDTO("some not exist project ids", Sets.newHashSet())));

        //when and then
        SubmitTimecardDTO submitTimeCardDTO = buildSubmitTimeCardDTO();
        this.mockMvc.perform(post("/timecards/submit")
                .contentType(APPLICATION_JSON)
                .content(JSON.toJSONString(submitTimeCardDTO)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.error", is(PROJECTS_OR_SUBPROJECTS_NOT_EXIST.toString())));
    }

    private SubmitTimecardDTO buildSubmitTimeCardDTO() {
        SubmitTimecardDTO submitTimeCardDTO = new SubmitTimecardDTO();
        submitTimeCardDTO.setEmployeeId("employeeId");

        EntryDTO entryDTO = new EntryDTO();
        entryDTO.setProjectId("projectId");

        EffortDTO effortDTO = new EffortDTO();
        effortDTO.setDate(LocalDate.of(2022, 1, 1).toString());
        effortDTO.setWorkingHours(8);
        effortDTO.setNote("note");

        SubEntryDTO subEntryDTO = new SubEntryDTO();
        subEntryDTO.setBillable(true);
        subEntryDTO.setLocationCode("CN");
        subEntryDTO.setSubProjectId("subprojectID");

        subEntryDTO.setEfforts(Lists.newArrayList(effortDTO));
        entryDTO.setSubEntries(Lists.newArrayList(subEntryDTO));
        submitTimeCardDTO.setEntries(Lists.newArrayList(entryDTO));

        return submitTimeCardDTO;
    }

}
