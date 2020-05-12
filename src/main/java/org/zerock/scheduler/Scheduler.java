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
      //System.out.println("松泥軒銅焼焼焼焼焼焼焼焼焼焼た焼ちっだちい趨板刊焼っ;ぬぞ;けぁい;");
      String path = this.getClass().getResource("").getPath(); //薄薦 適掘什税 弘軒井稽 聡 辞獄税 井稽研 硝焼紳陥
      int idx = path.indexOf("WEB-INF"); //薄薦 井稽拭辞 WEB-INF税 昔伎什税 葵聖 姥背紳陥 
      String realPath = path.substring(1,idx)+"resources\\upload"; // 昔伎什亜 1採斗 WEB-INF税 昔伎什猿走 庚切伸聖 切献板 upload井稽研 竺舛廃陥
      File file = new File(realPath); //辞獄税 井稽研 督析稽 走舛廃陥 
      //System.out.println("松降........");
      for (File info :FileUtils.listFiles(new File(realPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
         int cnt = 0; // 獣拙獣 朝錘闘澗 0 
         //鋼差庚聖戚遂背 辞獄井稽税 乞窮 督析聖 姥背人 馬蟹梢 info拭 眼焼層陥
            String filepath = info.getPath();//眼延督析税 井稽研 硝焼紳陥
            String file_name = info.getName().toString();//眼延督析税 戚硯聖 姥背紳陥 
            List<UploadFileVo> list =servce.get(); // 辞搾什研 戚遂背 uploadfile DB拭赤澗 葵聖 亜走壱 紳陥
            //System.out.println("督析戚硯亜走壱身"+file_name);
            for(int i= 0 ; i<= list.size()-1 ; i++){ // upload 督析聖 鋼差庚生稽 宜鍵陥 
               //System.out.println("搾嘘掻");
               int vo_index = list.get(i).getFile_name().lastIndexOf("/")+1;
               //DB拭辞 亜走紳 葵精 http://localhost:8080/resources/upload/2020\05\11/28019ece-463b-4acc-b579-3f5b2de7b69d.png
               //戚訓縦戚虞 戚硯生稽 設虞操醤廃陥 切牽奄是背 庚切伸税 及拭辞採斗 /猿走税 昔伎什研姥廃陥 
               String DBFileName= list.get(i).getFile_name().substring(vo_index);
               // 及拭辞採斗 亜走壱紳 vo_index研 戚遂背 庚切伸聖 設虞層陥 
               //System.out.println("DB拭赤澗 督析 戚硯 : "+DBFileName); //搾嘘拝 DB拭赤澗 督析 戚硯 -> 叔獣娃 督析
               //System.out.println("辞獄拭 赤澗 督析 戚硯 : "+file_name); // 搾嘘拝 辞獄拭赤澗 督析戚硯 -> old 督析
               if(DBFileName.equals(file_name)) {//督析聖 宜軒檎辞 督析 戚硯引 info人 搾嘘廃陥                  
                  cnt++;//旭精 戚硯戚 赤聖井酔 朝錘闘研 1稽 幻窮陥 
               }
            }//鋼差庚 曽戟
            if(cnt != 1) {// cnt亜 1戚 焼艦虞檎 益 督析精 肢薦吉 督析戚暗蟹 設公吉 督析戚陥
               System.out.println("肢薦");
               info.delete(); // 督析聖 肢薦廃陥 
            }
        }//陥獣 info研 馬蟹 幻級嬢辞 襖鎧紳陥 
   }
}