package com.jquery.basic.controller;

import com.jquery.basic.dto.MemberForm;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String loginPage() {
    return "/login/loginPage";
  }

  @ResponseBody
  @PostMapping(value = {"/loginCheck"})
  public Map<String, Object> loginCheck(@RequestParam Map<String, Object> params,
         Model model){
    MemberForm memberForm = new MemberForm();
    memberForm.setUserId(params.get("userId").toString());
    memberForm.setPassword(params.get("password").toString());
    memberForm.setNickname(params.get("nickname").toString());

    System.out.println("memberForm = " + memberForm);

    Map<String, Object> result = new HashMap<String, Object>();
    result.put("resultCd", "success");
    result.put("resultMsg", "post 통신 성공.");

    return result;
  }
}
