package com.example.demo_account.controller;

import com.example.demo_account.IntegrationTestSupport;
import com.example.demo_account.dto.CreateAccountRequest;
import com.example.demo_account.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.nio.cs.Surrogate.is;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "server-port=0",
        "command.line.runner.enabled=false"
})
@RunWith(SpringRunner.class)
@DirtiesContext
class AccountControllerTest extends IntegrationTestSupport {

   // @Test
  //  public void testCreateAccount_whenCustomerIdExits_shouldCreateAccountAndReturnAccountDto() throws Exception {
//        // Customer customer = customerRepository.save(generateCustomer());
//        CreateAccountRequest request = generateCreateAccountRequest(customer.getId(), 100);
//
//        this.mockMvc.perform(post(ACCOUNT_API_ENDPOINT)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(request)))
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", notNullValue()))
//                .andExpect(jsonPath("$.balance", is(100)))
//                .andExpect(jsonPath("$.customer.id", is(customer.getId())))
//                .andExpect(jsonPath("$.customer.name", is(customer.getName())))
//                .andExpect(jsonPath("$.customer.surname", is(customer.getSurname())))
//                .andExpect(jsonPath("$.transactions", hasSize(1)));
//    }
}