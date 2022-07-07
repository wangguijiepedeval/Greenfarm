import request from '@/utils/request'

// 查询用户与角色对应关系列表
export function listTz_sys_user_role(query) {
  return request({
    url: '/Greenfarm/tz_sys_user_role/list',
    method: 'get',
    params: query
  })
}

// 查询用户与角色对应关系详细
export function getTz_sys_user_role(id) {
  return request({
    url: '/Greenfarm/tz_sys_user_role/' + id,
    method: 'get'
  })
}

// 新增用户与角色对应关系
export function addTz_sys_user_role(data) {
  return request({
    url: '/Greenfarm/tz_sys_user_role',
    method: 'post',
    data: data
  })
}

// 修改用户与角色对应关系
export function updateTz_sys_user_role(data) {
  return request({
    url: '/Greenfarm/tz_sys_user_role',
    method: 'put',
    data: data
  })
}

// 删除用户与角色对应关系
export function delTz_sys_user_role(id) {
  return request({
    url: '/Greenfarm/tz_sys_user_role/' + id,
    method: 'delete'
  })
}
