package org.payservice.adapter.in.web;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisteredBankAccountControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisteredBankAccount() throws Exception {

        RegisteredBankAccountRequest request = new RegisteredBankAccountRequest("1", "국민은행", "0001112232",true);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/banking/account/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
            )
            .andExpect(MockMvcResultMatchers.status().isOk());
            //.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)));

    }
}