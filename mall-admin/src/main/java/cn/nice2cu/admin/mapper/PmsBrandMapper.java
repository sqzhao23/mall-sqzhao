package cn.nice2cu.admin.mapper;

import cn.nice2cu.admin.domain.entity.PmsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author sqzhao
 * @since 2021-05-26
 */
public interface PmsBrandMapper extends BaseMapper<PmsBrand> {
    IPage<PmsBrand> selectPageVo(Page<?> page);
}
