package com.bigcat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BikeRentalTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllRents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rent")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleRent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rent/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleRent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rent/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewRent() throws Exception {
        String newRent = "{\"customername\":\"Cat\",\"checkout\":\"10/10/10\",\"checkin\":\"11/10/10\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/rent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newRent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}

