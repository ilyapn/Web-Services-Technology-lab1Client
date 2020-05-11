package wst.CRUDExecutors.Rest;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.generated.Person;

import java.util.List;

@Service
public class RestFindExecutor implements CRUDPersonExecutor {
    @Override
    public void execute(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        if (person.getName() != null)
            map.add("name", person.getName());
        if (person.getSurname() != null)
            map.add("surname", person.getSurname());
        if (person.getPatronymic() != null)
            map.add("patronymic", person.getPatronymic());
        if (person.getWeight() != null)
            map.add("age", person.getAge().getValue().toString());
        if (person.getAge() != null)
            map.add("weight", person.getWeight().getValue().toString());
        try {
            ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:7070/db/find",
                    List.class,request);
            response.getBody().forEach(s -> System.out.println(s.toString()));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
