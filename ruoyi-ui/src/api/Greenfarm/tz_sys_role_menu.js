import request from '@/utils/request'

// 查询角色与菜单对应关系列表
export function listTz_sys_role_menu(query) {
  return request({
    url: '/Greenfarm/tz_sys_role_menu/list',
    method: 'get',
    params: query
  })
}

// 查询角色与菜单对应关系详细
export function getTz_sys_role_menu(id) {
  return request({
    url: '/Greenfarm/tz_sys_role_menu/' + id,
    method: 'get'
  })
}

// 新增角色与菜单对应关系
export function addTz_sys_role_menu(data) {
  return request({
    url: '/Greenfarm/tz_sys_role_menu',
    method: 'post',
    data: data
  })
}

// 修改角色与菜单对应关系
export function updateTz_sys_role_menu(data) {
  return request({
    url: '/Greenfarm/tz_sys_role_menu',
    method: 'put',
    data: data
  })
}

// 删除角色与菜单对应关系
export function delTz_sys_role_menu(id) {
  return request({
    url: '/Greenfarm/tz_sys_role_menu/' + id,
    method: 'delete'
  })
}
