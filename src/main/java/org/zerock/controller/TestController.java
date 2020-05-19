package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVo;

import com.google.gson.Gson;

@Controller
public class TestController {
	@RequestMapping(value = "/ajax/test" , produces = "aplication/json;charset=UTF-8" )
	@ResponseBody
	public String test2() {
		System.out.println("test ��Ʈ�ѷ� �Դϴ�.");
		String r = "ok";
		MemberVo vo =new MemberVo();
		vo.setMem_email("seraaa");
		Gson g = new Gson();
		return g.toJson(vo);
	}
}
