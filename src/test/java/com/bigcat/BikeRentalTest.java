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

//    Random rand = new Random();
//
//
//    @Test
//    public void signUp() throws Exception {
//        String newStaff = "{\"username\":\"test_username"+rand_int1+"\",\"password\":\"test_password"+rand_int2+"\"}";
//            mockMvc.perform(MockMvcRequestBuilders.post("/staff/sign-up")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(newStaff)
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andReturn();
//    }

    @Test
    public void login() throws Exception {
        String newStaff = "{\"username\":\"test_username\",\"password\":\"test_password\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newStaff)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


}

