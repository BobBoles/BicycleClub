package ie.umbrella.bike.club.controller;

import ie.umbrella.bike.club.entity.Member;
import ie.umbrella.bike.club.exception.ResourceNotFoundException;
import ie.umbrella.bike.club.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.match.ContentRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void getAllMembers() throws Exception {
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("john@doe.com", "John", "Doe"));

        when(memberService.getAll()).thenReturn(memberList);


        mockMvc.perform(get("/bicycleclub"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));

        Mockito.verify(memberService).getAll();
    }

    @Test
    void findMemberTest() throws Exception {
        Member johnDoe = new Member("john@doe.com", "John", "Doe");
        johnDoe.setId(123L); //usually set by hibernate

        when(memberService.findMemberById(123L)).thenReturn(johnDoe);
        mockMvc.perform(get("/bicycleclub/123"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindByIdWithInvalidId() throws Exception {
        // mock the service to throw an IllegalArgumentException
        when(memberService.findMemberById(anyLong())).thenThrow(new ResourceNotFoundException("Member not found"));

        // send a request to the endpoint with an invalid id
        mockMvc.perform(get("/bicycleclub/123"))
                .andExpect(status().isNotFound());
    }
}
