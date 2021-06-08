package cn.nice2cu.admin.service;

import cn.nice2cu.admin.domain.entity.UmsMember;
import cn.nice2cu.common.api.CommonResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author sqzhao
 * @since 2021-06-07
 */
public interface UmsMemberService extends IService<UmsMember> {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
