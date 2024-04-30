package cc.xuepeng.ray.framework.module.system.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.system.dao.SysRoleUserRelationDao;
import cc.xuepeng.ray.framework.module.system.domain.entity.SysRoleUserRelation;
import cc.xuepeng.ray.framework.module.system.service.SysRoleUserGrantService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色与用户关系的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysRoleUserGrantServiceImpl
        extends ServiceImpl<SysRoleUserRelationDao, SysRoleUserRelation>
        implements SysRoleUserGrantService {

    /**
     * 保存系统角色与用户的关系
     *
     * @param roleCode  角色编号
     * @param userCodes 用户编号集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(final String roleCode, final List<String> userCodes) {
        QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getRoleCode, roleCode);
        super.remove(wrapper);
        final List<SysRoleUserRelation> relations = new ArrayList<>();
        userCodes.forEach(userCode -> {
            SysRoleUserRelation relation = new SysRoleUserRelation();
            relation.setRoleCode(roleCode);
            relation.setUserCode(userCode);
            relations.add(relation);
        });
        super.saveBatch(relations);
    }

    /**
     * 根据角色编号查询用户编号集合
     *
     * @param roleCode 角色编号
     * @return 用户编号集合
     */
    @Override
    public List<String> findUsersByRoleCode(final String roleCode) {
        QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getRoleCode, roleCode);
        List<SysRoleUserRelation> relations = super.list(wrapper);
        List<String> userCodes = new ArrayList<>();
        relations.forEach(relation -> userCodes.add(relation.getUserCode()));
        return userCodes;
    }

    /**
     * 根据用户编号查询角色编号集合
     *
     * @param userCode 用户编号
     * @return 角色编号集合
     */
    @Override
    public List<String> findRolesByUserCode(final String userCode) {
        QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getUserCode, userCode);
        List<SysRoleUserRelation> relations = super.list(wrapper);
        List<String> roleCodes = new ArrayList<>();
        relations.forEach(relation -> roleCodes.add(relation.getRoleCode()));
        return roleCodes;
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysRoleUserRelation> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

}
