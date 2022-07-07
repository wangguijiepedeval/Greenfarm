import request from '@/utils/request'

// 查询用户积分管理列表
export function listTz_score_log(query) {
  return request({
    url: '/Greenfarm/tz_score_log/list',
    method: 'get',
    params: query
  })
}

// 查询用户积分管理详细
export function getTz_score_log(id) {
  return request({
    url: '/Greenfarm/tz_score_log/' + id,
    method: 'get'
  })
}

// 新增用户积分管理
export function addTz_score_log(data) {
  return request({
    url: '/Greenfarm/tz_score_log',
    method: 'post',
    data: data
  })
}

// 修改用户积分管理
export function updateTz_score_log(data) {
  return request({
    url: '/Greenfarm/tz_score_log',
    method: 'put',
    data: data
  })
}

// 删除用户积分管理
export function delTz_score_log(id) {
  return request({
    url: '/Greenfarm/tz_score_log/' + id,
    method: 'delete'
  })
}
