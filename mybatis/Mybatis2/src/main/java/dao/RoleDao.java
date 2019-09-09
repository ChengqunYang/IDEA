package dao;

import domain.Role;

import java.util.List;

/**
 *  查询所有角色
 */
public interface RoleDao {
    List<Role> findAll();
}
