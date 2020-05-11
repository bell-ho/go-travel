package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.UploadFileVo;

public interface UploadFileMapper {
	
	public List<UploadFileVo>getTripList(Criteria cri);	// �ı�Խñ� ���
	
	public int insert(UploadFileVo uploadVo);	//�Խñ� ���
	
	public List<UploadFileVo>getListWithPaging(Criteria cri);
	
	public int totalAll(Criteria cri);
	
	public int totalTrip(Criteria cri);
	
	public int deleteFileAll(Long board_no);
	
	public List<UploadFileVo> get();
}
