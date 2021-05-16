package cn.nice2cu.mall.common;

/**
 * 封装 API 的错误码
 * @author sqzhao
 * @date 2021年05月16日 10:16
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
