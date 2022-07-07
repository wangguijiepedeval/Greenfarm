import request from '@/utils/request'

// 查询用户列表
export function listTz_user(query) {
  return request({
    url: '/Greenfarm/tz_user/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getTz_user(userId) {
  return request({
    url: '/Greenfarm/tz_user/' + userId,
    method: 'get'
  })
}

// 新增用户
export function addTz_user(data) {
  return request({
    url: '/Greenfarm/tz_user',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateTz_user(data) {
  return request({
    url: '/Greenfarm/tz_user',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delTz_user(userId) {
  return request({
    url: '/Greenfarm/tz_user/' + userId,
    method: 'delete'
  })
}
