package cn.nice2cu.admin.controller;


import cn.nice2cu.admin.service.UmsMemberService;
import cn.nice2cu.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author sqzhao
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @GetMapping(value = "/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @PostMapping(value = "/verifyAuthCode")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
}

