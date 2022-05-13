package timecard.mgmt.proxy;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import timecard.mgmt.bean.VerifyProjectExistDTO;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;

@Component
public class ProjectServiceProxy {

    public List<VerifyProjectExistDTO> verifyData(List<VerifyProjectExistDTO> verifyProjectExistDTOs) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> uriVariables = Maps.newHashMap();
        uriVariables.put("projects", JSONObject.toJSONString(verifyProjectExistDTOs));
        //todo magic number, 写死的字符串
        return restTemplate.exchange("http://localhost:8081/projects/invalid-project-ids?projects={projects}",
                GET, null, new ParameterizedTypeReference<List<VerifyProjectExistDTO>>() {
        }, uriVariables).getBody();
    }
}
