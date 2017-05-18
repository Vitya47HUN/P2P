package com.greenfox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.controller.MessageController;
import com.greenfox.model.Message;
import com.greenfox.model.Reciever;
import com.greenfox.model.User;
import com.greenfox.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class P2pApplicationTests {


  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MessageRepository repository;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private ObjectMapper mapper;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .build();
  }

  @Test
  public void testMessageReceiveEndpoint() throws Exception {
    String content = getContent();
    ResultActions actual = mockMvc.perform(post(MessageController.receiveLink)
            .contentType(MediaType.APPLICATION_JSON)
            .content(content))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().json("{ \"status\" : \"OK\"}"));
  }

  private String getContent() throws JsonProcessingException {
    Reciever reciever = new Reciever();
    reciever.setUser(getUser());
    reciever.setMessage(getMessage());
    return mapper.writeValueAsString(reciever);
  }

  private Message getMessage() {
    return new Message("Imre", "Sleep more");
  }

  private User getUser() {
    return new User(1, "Pista");
  }
}
