package cn.nice2cu.admin.service;

import cn.nice2cu.admin.domain.entity.PmsBrand;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author sqzhao
 * @since 2021-05-26
 */
public interface PmsBrandService extends IService<PmsBrand> {
    List<PmsBrand> listAllBrand();

    boolean createBrand(PmsBrand brand);

    boolean updateBrand(Long id, PmsBrand brand);

    boolean deleteBrand(Long id);

    IPage<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
