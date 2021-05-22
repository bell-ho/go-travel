package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVo;

import java.util.List;

public interface BoardMapper {

    List<BoardVo> getFreeList();    // �����Խñ� ���

    List<BoardVo> getTripList();    // �ı�Խñ� ���

    List<BoardVo> getMyList(String mem_nickname); // �ڱⰡ ���� �Խ���

    void insert(BoardVo board);    //�Խñ� ���

    void insertSelectkey(BoardVo board); //�Խñ� ���

    BoardVo read(Long board_no); //�����Խñ� ��

    int delete(Long board_no); //�Խñ� ����

    int update(BoardVo board); //�Խñ� ����

    void updateReplyCnt(@Param("board_no") Long board_no, @Param("amount") int amount);

    int deleteMember(String mem_id);

    int updateBoardhit(Long board_no);
}
