package com.jquery.basic.controller;

import com.jquery.basic.domain.Member;
import com.jquery.basic.dto.MemberForm;
import com.jquery.basic.service.MemberService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/signUp")
  public String signUpPage() {
    return "/member/signUp";
  }

  @ResponseBody
  @PostMapping(value = {"/memberDupCheck"})
  public Map<String, Object> memberDupCheck(@RequestParam Map<String, Object> params,
    Model model) {
    MemberForm memberForm = new MemberForm();
    memberForm.setUserId(params.get("userId").toString());
    memberForm.setPassword(params.get("password").toString());
    memberForm.setNickname(params.get("nickname").toString());

    Map<String, Object> result = new HashMap<String, Object>();
    Optional<Member> memberDb = memberService.findByLoginId(memberForm.getUserId());

    if (memberDb.isEmpty()) {
      result.put("result", "ok");
    } else {
      result.put("result", "no");
    }

    return result;
  }

  @ResponseBody
  @PostMapping(value = {"/memberSignUp"})
  public Map<String, Object> memberSignUp(@RequestParam Map<String, Object> params) {
    MemberForm memberForm = new MemberForm();
    memberForm.setUserId(params.get("userId").toString());
    memberForm.setPassword(params.get("password").toString());
    memberForm.setNickname(params.get("nickname").toString());

    memberService.signUp(memberForm);

    Map<String, Object> result = new HashMap<String, Object>();
    result.put("redirect", "/");

    return result;
  }
}
