package wst.CRUDExecutors.Rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.generated.Person;

@Service
public class RestDeleteExecutor implements CRUDPersonExecutor {

    @Override
    public void execute(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("1","1");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        map.add("id", person.getId().toString());
        try {
            ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:7070/db/delete",
                    request,
                    Boolean.class);
            System.out.println("Delete result: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
