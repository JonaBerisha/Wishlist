package com.example.wishlist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
   @Autowired
    private MockMvc mockMvc;

   @Test
    void register_shouldRedirect()throws Exception{
       mockMvc.perform(post("/register")
                       .param("email", "a@a.dk")
               .param("name", "test")
               .param("password", "1234")
               .param("birthDate","2000-01-01"))
               .andExpect(status().is3xxRedirection());
   }
}
