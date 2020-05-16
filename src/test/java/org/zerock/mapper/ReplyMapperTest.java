package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
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
		vo.setBoard_no(56L);
		vo.setReply_content("������");
		log.info("vo : "+vo);
		mapper.insert(vo);
		
	}
	
//	@Test //Ư�� �Խù� ��ȣ�� ��� ���������
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVo> replies = mapper.getListWithPaging(cri, 1L);
		replies.forEach(reply->log.info(reply));
	}
	
//	@Test //��� ���� �׽�Ʈ
	public void testDelete() {
		log.info("����"+mapper.delete(1));
	}
	
//	@Test //��� ���� �׽�Ʈ
	public void testGet() {
		log.info("��� 1�� ������ ����"+mapper.get(1));
	}
	
//	@Test //��� ���� �׽�Ʈ
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setReply_no(1);
		vo.setReply_content("����");
		log.info("����"+mapper.update(vo));
	}
}
