package in.mrkhan.testcontroller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.mrkhan.controller.TutorialRestControllerApi;
import in.mrkhan.model.TutorialEntity;
import in.mrkhan.service.ITutorialsService;

@WebMvcTest(value = TutorialRestControllerApi.class)
public class TutorialRestControllerApiTest {

	@MockBean
	private ITutorialsService tutoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createTutorialsTest() throws Exception {
		when(tutoService.insertTutorialsInfo(ArgumentMatchers.any())).thenReturn("Insertion succeded!");

		TutorialEntity tEntity = new TutorialEntity(1, "java", "batch");
		ObjectMapper objMapper = new ObjectMapper();
		String entityJackson = objMapper.writeValueAsString(tEntity);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/api/inserttutorials")
				.contentType(MediaType.APPLICATION_JSON).content(entityJackson);

		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(201, status);

		/*
		 * MvcResult andReturn = perform.andReturn();
		 * 
		 * MockHttpServletResponse response = andReturn.getResponse();
		 * 
		 * int status = response.getStatus();
		 * 
		 */
		// assertEquals(201, status );

	}

	@Test
	public void getAllTutorialsTest() throws Exception {

		List<TutorialEntity> listOfEntity = new ArrayList<TutorialEntity>();

		when(tutoService.viewAllTutorials()).thenReturn(listOfEntity);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/getalltutorials");

		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(200, status);
	}

	@Test
	public void getTutorialbyIdTest() throws Exception {
		when(tutoService.getTutorialbyId(ArgumentMatchers.anyInt())).thenReturn(new TutorialEntity());

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/gettutorial/1");
		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(200, status);
	}

	@Test
	public void updateTutorialUsingIdTest() throws Exception {

	
		
		when(tutoService.updateTutorial(ArgumentMatchers.any())).thenReturn("updation succeded");

		TutorialEntity entityrecord = new TutorialEntity(1, "java", "starting");	
		ObjectMapper objMapper = new ObjectMapper();
		String entityAsString = objMapper.writeValueAsString(entityrecord);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.put("/api/updatetutorial")
				.contentType(MediaType.APPLICATION_JSON).content(entityAsString);

		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(200, status);

	}

	@Test
	public void deletetutorialbyIdTest() throws Exception {

		when(tutoService.deleteTutorialbyId(ArgumentMatchers.any())).thenReturn("id record deleted");

		TutorialEntity entityrecord = new TutorialEntity(1, "java", "starting");
		ObjectMapper objMapper = new ObjectMapper();
		String entityAsString = objMapper.writeValueAsString(entityrecord);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/api/deletetutorial/1")
				.contentType(MediaType.APPLICATION_JSON).content(entityAsString);

		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(200, status);

	}

	@Test
	public void deleteAllTutorialsTest() throws Exception {

		when(tutoService.deleteAllTutorials()).thenReturn("all record deleted");

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/api/deletetutorials");

		int status = mockMvc.perform(reqBuilder).andReturn().getResponse().getStatus();

		assertEquals(200, status);

	}

}
