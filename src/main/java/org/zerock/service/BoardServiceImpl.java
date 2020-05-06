package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVo;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	@Setter(onMethod_ =@Autowired )
	private BoardMapper mapper;

	@Override
	public void register(BoardVo board) {
		// TODO Auto-generated method stub
		
		log.info("등록..."+board);
		mapper.insertSelectkey(board);
	}
	
	//자유
	@Override 
	public BoardVo get(Long BOARD_NO) {
		// TODO Auto-generated method stub
		log.info("get....."+BOARD_NO);
		return mapper.read(BOARD_NO);
	}
	
	//후기
//	@Override
//	public BoardVo getTrip(Long BOARD_NO) {
//		// TODO Auto-generated method stub
//		log.info("get....."+BOARD_NO);
//		return mapper.readTrip(BOARD_NO);
//	}

	@Override
	public boolean modify(BoardVo board) {
		// TODO Auto-generated method stub
		log.info("modify...."+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long BOARD_NO) {
		// TODO Auto-generated method stub
		log.info("remove...."+BOARD_NO);
		return mapper.delete(BOARD_NO)==1;
	}

	@Override
	public List<BoardVo> getFreeList() {
		// TODO Auto-generated method stub
		log.info("getList.......");
		
		return mapper.getFreeList();
	}
	
	@Override
	public List<BoardVo> getTripList() {
		// TODO Auto-generated method stub
		log.info("getList.......");
		
		return mapper.getTripList();
	}
	
	
}
