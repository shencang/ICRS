package com.shencangblue.design.icrs.service.admin;


import com.shencangblue.design.icrs.dao.adminDao.AdminRoleMenuDao;

import com.shencangblue.design.icrs.model.admin.AdminRoleMenu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;


@Service
public class AdminRoleMenuService {
    @Resource
    AdminRoleMenuDao adminRoleMenuDao;

    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDao.findAllByRid(rid);
    }

    @Modifying
    @Transactional
    public void deleteAllByRid(int rid) {
        adminRoleMenuDao.deleteAllByRid(rid);
    }

    public void save(AdminRoleMenu rm) {
        adminRoleMenuDao.save(rm);
    }

    @Modifying
    @Transactional
    public boolean updateRoleMenu(int rid, LinkedHashMap menusIds) {
        try {
            deleteAllByRid(rid);
            for (Object value : menusIds.values()) {
                for (int mid : (List<Integer>) value) {
                    AdminRoleMenu rm = new AdminRoleMenu();
                    rm.setRid(rid);
                    rm.setMid(mid);
                    adminRoleMenuDao.save(rm);
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
