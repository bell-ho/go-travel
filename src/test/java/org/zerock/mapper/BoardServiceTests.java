package org.zerock.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ =@Autowired )
	private BoardService service;
	
//	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
//	@Test
	public void testRegister() {
		
		BoardVo board = new BoardVo();
		
		board.setBOARD_KINDS(1);
		board.setBOARD_TITLE("�׽�Ʈ0428");
		board.setBOARD_HIT(5);
		board.setBOARD_CONTENT("�׽�Ʈ����");
		board.setMEM_NO(1);
		
		service.register(board);
		
		log.info("������ �Խù� ��ȣ"+board.getBOARD_NO());
	}
	
//	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}
	
//	@Test
	public void testGet() {
		log.info(service.get(61L));
	}
	
//	@Test
	public void testDelete() {
		log.info("���� ���: "+service.remove(61L));
	}
	
	@Test
	public void testUpdate() {
		BoardVo board = service.get(56L);
		
		if(board == null) {
			return;
		}
		board.setBOARD_TITLE("�������");
		log.info("modify ���:"+service.modify(board));
	}
}
