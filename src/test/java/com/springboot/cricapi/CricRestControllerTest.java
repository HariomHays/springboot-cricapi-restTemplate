package com.springboot.cricapi;


import com.springboot.cricapi.model.JsonCricScore;
import com.springboot.cricapi.service.CricApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CricRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CricApiService cricApiService;


    private JsonCricScore mockResponse = new JsonCricScore("Sunrisers Hyderabad","Chennai Super Kings","140/8");

    @Test
    public void testGetScore() throws Exception {

        String urlTemplate = "/cric/getscore?matchId=1136617";

        Mockito.when(
                cricApiService.getCricScore(Mockito.anyInt())).thenReturn(mockResponse);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(urlTemplate)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"Team-1\":\"Sunrisers Hyderabad\",\"Team-2\":\"Chennai Super Kings\",\"Winning team’s score\":\"140/8\",\"Round rotation\":\"8140/\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}
