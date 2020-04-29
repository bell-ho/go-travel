package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test
	public void testList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap();
	}

//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/registerBoard")
				.param("board_kinds", "1")
				.param("board_title", "�Խù� ����")
				.param("board_content", "�Խù� ����")
				.param("mem_no", "1"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}

//	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("board_no", "56")).andReturn()
				.getModelAndView().getModelMap());
	}

//	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("board_no", "85")
				.param("board_title", "������ �Խù� ����")
				.param("board_content", "������ �Խù� ����"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}

//	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("board_no", "56"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
}
