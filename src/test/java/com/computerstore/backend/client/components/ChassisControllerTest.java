package com.computerstore.backend.client.components;

/*import com.computerstore.backend.App;
import com.computerstore.backend.domain.components.Chassis;
import com.computerstore.backend.factories.components.ChassisFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;*/

/**
 * Created by Aiden on 2016/10/23.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes =  App.class)
@WebAppConfiguration
@IntegrationTest({"server.port= 8080"})
public class ChassisControllerTest {

    final String BASE_URL =  "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template =  new TestRestTemplate();
    }

    @Test
    public void createChassis() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Chassis chassis = ChassisFactory.getChassis("Cooler Master","Large case","100","2500.00");
        URI uri = restTemplate.postForLocation(BASE_URL +"/chassis/",chassis,Chassis.class);
    }

    @Test
    public void readChassisByID() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Chassis chassiss = restTemplate.getForObject(BASE_URL + "/chassis/1",Chassis.class);
        System.out.println(chassiss);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void findAllChassis() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> chassis = restTemplate.getForObject(BASE_URL + "/chassis_s/",List.class);
        System.out.println(chassis);
    }

    @Test
    public void updateChassis() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Chassis chassis = ChassisFactory.getChassis("Cooler Master","Large case","100","2500.00");
        restTemplate.put(BASE_URL + "/chassis/1",chassis);
        System.out.println(chassis);
    }

    @Test
    public void deleteChassis() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL+"/chassis/1");
    }
}*/
