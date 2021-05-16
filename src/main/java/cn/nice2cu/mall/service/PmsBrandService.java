package cn.nice2cu.mall.service;

import cn.nice2cu.mall.mbg.model.PmsBrand;
import java.util.List;

/**
 * @author sqzhao
 * @date 2021年05月16日 10:17
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
