package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

public interface ReplyService {
	
	public int insert(ReplyVo vo); //��� �ۼ�
	
	public ReplyVo get(int reply_no); //��� 1�� ���������
	
	public int delete(int reply_no); //��� ����
	
	public int update(ReplyVo vo); // ��� ����
	
	public List<ReplyVo> getListWithPaging(Criteria cri , Long board_no); //�Խñ��� ��� ������ ����
	
	public int deleteReplyAll(Long board_no);
}
