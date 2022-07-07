import request from '@/utils/request'

// 查询用户收藏管理列表
export function listTz_user_collection(query) {
  return request({
    url: '/Greenfarm/tz_user_collection/list',
    method: 'get',
    params: query
  })
}

// 查询用户收藏管理详细
export function getTz_user_collection(id) {
  return request({
    url: '/Greenfarm/tz_user_collection/' + id,
    method: 'get'
  })
}

// 新增用户收藏管理
export function addTz_user_collection(data) {
  return request({
    url: '/Greenfarm/tz_user_collection',
    method: 'post',
    data: data
  })
}

// 修改用户收藏管理
export function updateTz_user_collection(data) {
  return request({
    url: '/Greenfarm/tz_user_collection',
    method: 'put',
    data: data
  })
}

// 删除用户收藏管理
export function delTz_user_collection(id) {
  return request({
    url: '/Greenfarm/tz_user_collection/' + id,
    method: 'delete'
  })
}
