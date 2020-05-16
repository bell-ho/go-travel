package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo); //��� �ۼ�
	
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria  cri,		// ��� ����Ʈ
										@Param("board_no") Long board_no); 
	
	public int delete(int reply_no); //��� ����
	
	public int update(ReplyVo vo); //��� ���� 
	
	public ReplyVo get(int reply_no); //��� �Ѱ������� ����
	
	public int deleteReplyAll(Long board_no); //�Խù��� �ִ� ��� �������
	
	public int deleteMember(String mem_id);
}
