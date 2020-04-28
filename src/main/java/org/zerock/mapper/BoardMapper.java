package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from board where BOARD_NO >0")
	public List<BoardVo>getList();	//�Խñ� ���
	
	public void insert(BoardVo board);	//�Խñ� ���
	
	public void insertSelectkey(BoardVo board); //�Խñ� ���
	
	public BoardVo read(Long board_no); //�Խñ� ��
	
	public int delete(Long board_no); //�Խñ� ����
	
	public int update(BoardVo board); //�Խñ� ����
}
