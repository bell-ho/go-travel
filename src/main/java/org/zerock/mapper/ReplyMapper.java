package org.zerock.mapper;

import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo); //��� �ۼ�
	
	public ReplyVo read(int reply_no); // ����Ѱ� ���������
	
	public int delete(int reply_no); //��� ����
	
	public int update(ReplyVo vo); //��� ����
}
