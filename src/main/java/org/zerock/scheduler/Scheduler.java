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
//@Component
public class Scheduler {
	@Setter(onMethod_ = @Autowired)
	private UploadFileService servce;

	@Scheduled(cron = "0 0/1 * * * * ")
	public void checkFiles() throws Exception {
		String path = this.getClass().getResource("").getPath();
		// ���� Ŭ������ �������(�������)�� �˾ƿ´�

		int idx = path.indexOf("WEB-INF");
		// ���� ��ο��� WEB-INF�� �ε����� ���� ���ؿ´�

		String realPath = path.substring(1, idx) + "resources\\upload";
		// 1���� WEB-INF�� �ε������� ���ڿ��� �ڸ��� upload��θ� �����Ѵ�

		File file = new File(realPath);
		// ������ ��θ� ���Ϸ� �����Ѵ�

		for (File info : FileUtils.listFiles(new File(realPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
			// �ݺ������̿��� ��������� ��� ������ ���ؿ� �ϳ��� info�� ��´�

			int cnt = 0;
			// ���۽� ī��Ʈ�� 0

			String filepath = info.getPath();
			// info�� ��� ������ ��θ� filepath�� ��´�

			String file_name = info.getName().toString();
			// ��������� �̸��� getName()�� �̿��Ͽ� ���ϰ� file_name�� ��´�

			List<UploadFileVo> list = servce.get();
			// servce.get()�� �̿��� uploadfile�� ���� DB���ִ� ���� ������ �´�

			// System.out.println("�����̸��������"+file_name);

			for (int i = 0; i <= list.size(); i++) {
				// uploadfile�� �ݺ������� ������

				// System.out.println("����");

				int vo_index = list.get(i).getFile_name().lastIndexOf("/") + 1;
				// DB���� ������ ����
				// http://localhost:8080/resources/upload/2020\\05\\11/28019ece-463b-4acc-b579-3f5b2de7b69d.png
				// �̷� ������ �ּ����� �����η� �߶�����Ѵ� �ڸ������� ���ڿ��� �ǵڿ������� �ι�° / ������ �ε����� ���Ѵ�

				String DBFileName = list.get(i).getFile_name().substring(vo_index);
				// �ڿ������� ������� vo_index�� �̿��� ���ڿ��� �߶��ش�
				// �׷� 2020\05\11/28019ece-463b-4acc-b579-3f5b2de7b69d.png �̷� �������� �߸���

				// System.out.println("DB���ִ� ���� �̸� : "+DBFileName); //���� DB���ִ� ���� �̸� -> ���� �ǽð� ����
				// System.out.println("������ �ִ� ���� �̸� : "+file_name); // ���� �������ִ� �����̸� -> old ����

				if (DBFileName.equals(file_name)) {
					// ������ �����鼭 ���� �̸��� info�� ��
					cnt++;
					// ���� �̸��� ������� ī��Ʈ ����
				}
			}
			if (cnt != 1) {
				// cnt�� 1�� �ƴ϶�� �� ������ ������ �����̰ų� �߸��� �����̴�
				System.out.println("����");
				info.delete();

			}
		} // �ٽ� info�� �ϳ� ���� �����´�
	}

}