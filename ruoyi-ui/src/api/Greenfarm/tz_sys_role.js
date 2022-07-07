import request from '@/utils/request'

// 查询角色列表
export function listTz_sys_role(query) {
  return request({
    url: '/Greenfarm/tz_sys_role/list',
    method: 'get',
    params: query
  })
}

// 查询角色详细
export function getTz_sys_role(roleId) {
  return request({
    url: '/Greenfarm/tz_sys_role/' + roleId,
    method: 'get'
  })
}

// 新增角色
export function addTz_sys_role(data) {
  return request({
    url: '/Greenfarm/tz_sys_role',
    method: 'post',
    data: data
  })
}

// 修改角色
export function updateTz_sys_role(data) {
  return request({
    url: '/Greenfarm/tz_sys_role',
    method: 'put',
    data: data
  })
}

// 删除角色
export function delTz_sys_role(roleId) {
  return request({
    url: '/Greenfarm/tz_sys_role/' + roleId,
    method: 'delete'
  })
}
