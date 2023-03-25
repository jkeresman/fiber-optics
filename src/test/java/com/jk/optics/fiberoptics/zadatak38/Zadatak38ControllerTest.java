package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.config.StaticResourcesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class Zadatak38ControllerTest {
    private static final String POST_REQUEST_ZADATAK_38 = """
            {
               "Pod": -40,
               "b": 150.0,
               "delta-lambda": 20.0,
               "lambda": 0.25,
               "alpha": 0.25,
               "alpha-s": 0.25,
               "alpha-k": 0.4,
               "nb": 5000,
               "l1": 10.0,
               "d": 1.0,
               "ms": 8.0
            }
            """;

    @Mock
    private Zadatak38Service zadatak38Service;
    @Mock
    private StaticResourcesService staticResourcesService;

    @Test
    public void testPost() throws Exception {

        //GIVEN
        Zadatak38Controller controller = new Zadatak38Controller(zadatak38Service, staticResourcesService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Zadatak38Response response = new Zadatak38Response(
                new BigDecimal("117.6000000000000227373675443232059478759765625"),
                new BigDecimal("10"),
                new BigDecimal("20"),
                new BigDecimal("-69.4")
        );

        //WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/zadatak/38/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(POST_REQUEST_ZADATAK_38);

        when(zadatak38Service.solve(any())).thenReturn(response);

        //THEN
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.snagaPrijemnikadbW").value("-69.4"))
                .andExpect(jsonPath("$.rjesenjeA").value("117.6000000000000227373675443232059478759765625"))
                .andExpect(jsonPath("$.rjesenjeB").value("10"))
                .andExpect(jsonPath("$.rjesenjeC").value("20"));
    }
}