package cn.nice2cu.admin.service.impl;

import cn.nice2cu.admin.domain.entity.UmsMember;
import cn.nice2cu.admin.mapper.UmsMemberMapper;
import cn.nice2cu.admin.service.UmsMemberService;
import cn.nice2cu.common.api.CommonResult;
import cn.nice2cu.common.service.RedisService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author sqzhao
 * @since 2021-06-07
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 生成验证码
     * @author zhaosq
     * @date 2021/6/8 11:34
     * @param telephone
     * @return cn.nice2cu.common.api.CommonResult
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }


    /**
     * 对输入的验证码进行校验
     * @author zhaosq
     * @date 2021/6/8 11:35
     * @param telephone
     * @param authCode
     * @return cn.nice2cu.common.api.CommonResult
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}

