package ai.cvbird.cvbirdpromoemailservice.controller;


import ai.cvbird.cvbirdpromoemailservice.service.UserEmailStoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = {UserEmailController.class})
public class UserEmailControllerTest {

    @MockBean
    UserEmailStoreService userEmailStoreService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveEmail() throws Exception {
      //  EmailDTO emailDTO = new EmailDTO(null, "KVr@e.com");
        final ResultActions result = mockMvc.perform(post("/promo/email")
//                 .content(objectMapper.writeValueAsString(emailDTO))
                               .content("{ \"email\": \"KedgVe.com\" }")
                                .contentType(MediaType.APPLICATION_JSON));
//                .andExpect(status().isCreated())
//                .andDo(print());
        result
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"email\":\"Please provide a valid email address\"}"));
//                .andExpect(jsonPath("$", is(true)));
    }
}
