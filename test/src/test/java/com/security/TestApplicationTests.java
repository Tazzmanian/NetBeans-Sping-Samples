package com.security;

import com.security.controller.MainController;
import com.security.model.User;
import com.security.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class TestApplicationTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> people = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setFirstName("Teodor");
        user.setLastName("Todorov");
        user.setEmail("banskaliqtabg@yahoo.com");
        user.setPhone("0123456789");
        people.add(user);

        when(userService.findAll()).thenReturn(people);

        System.out.println("Test" + view().name("/users"));

        String users = "    { "
                + "        \"id\": 1, "
                + "        \"firstName\": \"Teodor\", "
                + "        \"lastName\": \"Todorov\", "
                + "        \"email\": \"banskaliqtabg@yahoo.com\", "
                + "        \"phone\": \"0123456789\" "
                + "    }";

        MvcResult result = mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // TODO test the content
        //assertTrue(result.toString().equals(users));
    }

}
