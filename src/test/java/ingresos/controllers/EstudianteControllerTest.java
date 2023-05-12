package ingresos.controllers;

import ingresos.domain.Estudiante;
import ingresos.service.EstudianteService;
import ingresos.domain.Estudiante;
import ingresos.domain.InfoAcademica;
import ingresos.domain.InfoEconomica;
import ingresos.domain.InfoPersonal;
import ingresos.service.EstudianteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EstudianteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EstudianteService service;

    @InjectMocks
    private EstudianteController controller;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testSave() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);
        estudiante.setDiligenciado(true);
        estudiante.setInfoPersonal(new InfoPersonal());
        estudiante.setInfoEconomica(new InfoEconomica());
        estudiante.setInfoAcademica(new InfoAcademica());

        when(service.save(any(Estudiante.class))).thenReturn(estudiante);

        mockMvc.perform(MockMvcRequestBuilders.post("/estudiante")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"diligenciado\":true,\"infoPersonal\":{},\"infoEconomica\":{},\"infoAcademica\":{}}"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.diligenciado").value(true))
            .andExpect(jsonPath("$.infoPersonal").isNotEmpty())
            .andExpect(jsonPath("$.infoEconomica").isNotEmpty())
            .andExpect(jsonPath("$.infoAcademica").isNotEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);
        estudiante.setDiligenciado(true);
        estudiante.setInfoPersonal(new InfoPersonal());
        estudiante.setInfoEconomica(new InfoEconomica());
        estudiante.setInfoAcademica(new InfoAcademica());

        when(service.getById(1L)).thenReturn(Optional.of(estudiante));

        mockMvc.perform(MockMvcRequestBuilders.get("/estudiante/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.infoPersonal").isNotEmpty())
            .andExpect(jsonPath("$.infoEconomica").isNotEmpty())
            .andExpect(jsonPath("$.infoAcademica").isNotEmpty());
    }

    @Test
    public void testGetAll() throws Exception {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setId(1L);
        estudiante1.setDiligenciado(true);
        estudiante1.setInfoPersonal(new InfoPersonal());
        estudiante1.setInfoEconomica(new InfoEconomica());
        estudiante1.setInfoAcademica(new InfoAcademica());

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setId(2L);
        estudiante2.setDiligenciado(true);
        estudiante2.setInfoPersonal(new InfoPersonal());
        estudiante2.setInfoEconomica(new InfoEconomica());
        estudiante2.setInfoAcademica(new InfoAcademica());

        List<Estudiante> estudiantes = Arrays.asList(estudiante1, estudiante2);

        when(service.getAll()).thenReturn(estudiantes);

        mockMvc.perform(MockMvcRequestBuilders.get("/estudiante"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].infoPersonal").isNotEmpty())
            .andExpect(jsonPath("$[0].infoEconomica").isNotEmpty())
            .andExpect(jsonPath("$[0].infoAcademica").isNotEmpty())
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].infoPersonal").isNotEmpty())
            .andExpect(jsonPath("$[1].infoEconomica").isNotEmpty())
            .andExpect(jsonPath("$[1].infoAcademica").isNotEmpty())
            .andDo(print());
    }

    @Test
    public void testUpdateById() throws Exception {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);
        estudiante.setDiligenciado(true);
        estudiante.setInfoPersonal(new InfoPersonal());
        estudiante.setInfoEconomica(new InfoEconomica());
        estudiante.setInfoAcademica(new InfoAcademica());

        when(service.updateById(any(Estudiante.class), any(Long.class))).thenReturn(estudiante);

        mockMvc.perform(MockMvcRequestBuilders.put("/estudiante/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"diligenciado\":true,\"infoPersonal\":{},\"infoEconomica\":{},\"infoAcademica\":{}}"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.diligenciado").value(true))
            .andExpect(jsonPath("$.infoPersonal").isNotEmpty())
            .andExpect(jsonPath("$.infoEconomica").isNotEmpty())
            .andExpect(jsonPath("$.infoAcademica").isNotEmpty());
    }

    @Test
    public void testDeleteById() throws Exception {
        when(service.delete(1L)).thenReturn(true);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/estudiante/1"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        assert(content.equals("Estudiante eliminado con exito"));
    }
}
