package cn.nice2cu.admin.service.impl;

import cn.nice2cu.admin.domain.entity.PmsBrand;
import cn.nice2cu.admin.mapper.PmsBrandMapper;
import cn.nice2cu.admin.service.PmsBrandService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author sqzhao
 * @since 2021-05-26
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Autowired PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return this.list();
    }

    @Override
    public boolean createBrand(PmsBrand brand) {
        return this.save(brand);
    }

    @Override
    public boolean updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return this.updateById(brand);
    }

    @Override
    public boolean deleteBrand(Long id) {
        return this.removeById(id);
    }

    @Override
    public IPage<PmsBrand> listBrand(int pageNum, int pageSize) {
        Page<PmsBrand> page = new Page<>(pageNum, pageSize);
        return pmsBrandMapper.selectPageVo(page);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return this.getById(id);
    }
}
