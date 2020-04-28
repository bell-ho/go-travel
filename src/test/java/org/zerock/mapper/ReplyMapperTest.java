package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml ")
@Log4j
public class ReplyMapperTest {
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
//	@Test //Mapper ���� �׽�Ʈ 
	public void testMapper() {
		log.info(mapper);
	}
	
//	@Test //��۵�� �׽�Ʈ 
	public void testInsert() {
		ReplyVo vo = new ReplyVo();
		vo.setBOARD_NO(56L);
		vo.setMEM_NO(1);
		vo.setREPLY_CONTENT("������");
		log.info("vo : "+vo);
		mapper.insert(vo);
		
	}
	
//	@Test //��� �Ѱ� ��������� �׽�Ʈ
	public void testGet() {
		log.info("��� "+mapper.read(1));
		
	}
	
//	@Test //��� ���� �׽�Ʈ
	public void testDelete() {
		log.info("����"+mapper.delete(1));
	}
	
//	@Test //��� ���� �׽�Ʈ
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setREPLY_NO(1);
		vo.setMEM_NO(1);
		vo.setREPLY_CONTENT("����");
		log.info("����"+mapper.update(vo));
	}
}
