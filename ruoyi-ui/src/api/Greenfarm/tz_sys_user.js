import request from '@/utils/request'

// 查询系统用户列表
export function listTz_sys_user(query) {
  return request({
    url: '/Greenfarm/tz_sys_user/list',
    method: 'get',
    params: query
  })
}

// 查询系统用户详细
export function getTz_sys_user(userId) {
  return request({
    url: '/Greenfarm/tz_sys_user/' + userId,
    method: 'get'
  })
}

// 新增系统用户
export function addTz_sys_user(data) {
  return request({
    url: '/Greenfarm/tz_sys_user',
    method: 'post',
    data: data
  })
}

// 修改系统用户
export function updateTz_sys_user(data) {
  return request({
    url: '/Greenfarm/tz_sys_user',
    method: 'put',
    data: data
  })
}

// 删除系统用户
export function delTz_sys_user(userId) {
  return request({
    url: '/Greenfarm/tz_sys_user/' + userId,
    method: 'delete'
  })
}
