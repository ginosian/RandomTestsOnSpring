import com.mefis.controller.MainController;
import com.mefis.dto.ProfileDTO;
import com.mefis.service.ProfileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Created by Lion on 7/28/16.
 */
public class MainControllerTest {

    @Mock
    ProfileService profileService;


    InternalResourceViewResolver viewResolver;
    @InjectMocks
    MainController mainController;

    MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(mainController).setViewResolvers(viewResolver).build();

        Mockito.when(profileService.getAllProfiles()).thenAnswer(new Answer<ArrayList<ProfileDTO>>() {
            @Override
            public ArrayList<ProfileDTO> answer(InvocationOnMock invocation) throws Throwable {
                ProfileDTO profileDTO = new ProfileDTO("Vle");
                profileDTO.setId(1);
                ArrayList<ProfileDTO> profileList = new ArrayList<>();
                profileList.add(profileDTO);
                return profileList;
            }
        });
    }

    @Test
    public void testGetAllProfiles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/get"))
                .andExpect(forwardedUrl("/WEB-INF/hello.jsp"))
                .andExpect(model().attributeExists("message"));


    }






}
