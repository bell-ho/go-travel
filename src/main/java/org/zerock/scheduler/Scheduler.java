package org.zerock.scheduler;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.UploadFileVo;
import org.zerock.service.UploadFileService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class Scheduler {
	@Setter(onMethod_=@Autowired)
	private UploadFileService servce;
	
	@Scheduled(cron = "0 0/1 * * * * ")
	public void checkFiles() throws Exception {
		//System.out.println("��ť��Ƽ�ƾƾƾƾƾƾƾƾƾƤ��Ƥ��ä��������Ĵ��Ƥ�;�̤�;������;");
		int cnt = 0; // ���۽� ī��Ʈ�� 0 
		String path = this.getClass().getResource("").getPath(); //���� Ŭ������ ������� �� ������ ��θ� �˾ƿ´�
		int idx = path.indexOf("WEB-INF"); //���� ��ο��� WEB-INF�� �δ콺�� ���� ���ؿ´� 
		String realPath = path.substring(1,idx)+"resources\\upload"; // �δ콺�� 1���� WEB-INF�� �δ콺���� ���ڿ��� �ڸ��� upload��θ� �����Ѵ�
		File file = new File(realPath); //������ ��θ� ���Ϸ� �����Ѵ� 
		//System.out.println("����........");
		for (File info :FileUtils.listFiles(new File(realPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
			//�ݺ������̿��� ��������� ��� ������ ���ؿ� �ϳ��� info�� ����ش�
				String filepath = info.getPath();//��������� ��θ� �˾ƿ´�
				String file_name = info.getName().toString();//��������� �̸��� ���ؿ´� 
				List<UploadFileVo> list =servce.get(); // ���񽺸� �̿��� uploadfile DB���ִ� ���� ������ �´�
				//System.out.println("�����̸��������"+file_name);
				for(int i= 0 ; i<= list.size()-1 ; i++){ // upload ������ �ݺ������� ������ 
					//System.out.println("����");
					int vo_index = list.get(i).getFile_name().lastIndexOf("/")+1;
					//DB���� ������ ���� http://localhost:8080/resources/upload/2020\05\11/28019ece-463b-4acc-b579-3f5b2de7b69d.png
					//�̷����̶� �̸����� �߶�����Ѵ� �ڸ������� ���ڿ��� �ڿ������� /������ �δ콺�����Ѵ� 
					String DBFileName= list.get(i).getFile_name().substring(vo_index);
					// �ڿ������� ������� vo_index�� �̿��� ���ڿ��� �߶��ش� 
					//System.out.println(DBFileName); //���� DB���ִ� ���� �̸� -> �ǽð� ����
					//System.out.println(file_name); // ���� �������ִ� �����̸� -> old ����
					if(DBFileName.equals(file_name)) {//������ �����鼭 ���� �̸��� info�� ���Ѵ�						
						cnt++;//���� �̸��� ������� ī��Ʈ�� 1�� ����� 
					}
				}//�ݺ��� ����
				if(cnt != 1) {// cnt�� 1�� �ƴ϶�� �� ������ ������ �����̰ų� �߸��� �����̴�
					System.out.println("����");
					info.delete(); // ������ �����Ѵ� 
				}
        }//�ٽ� info�� �ϳ� ���� �����´� 
	}
}
