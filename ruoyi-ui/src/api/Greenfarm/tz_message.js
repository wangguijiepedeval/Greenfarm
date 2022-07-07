import request from '@/utils/request'

// 查询个人消息列表
export function listTz_message(query) {
  return request({
    url: '/Greenfarm/tz_message/list',
    method: 'get',
    params: query
  })
}

// 查询个人消息详细
export function getTz_message(id) {
  return request({
    url: '/Greenfarm/tz_message/' + id,
    method: 'get'
  })
}

// 新增个人消息
export function addTz_message(data) {
  return request({
    url: '/Greenfarm/tz_message',
    method: 'post',
    data: data
  })
}

// 修改个人消息
export function updateTz_message(data) {
  return request({
    url: '/Greenfarm/tz_message',
    method: 'put',
    data: data
  })
}

// 删除个人消息
export function delTz_message(id) {
  return request({
    url: '/Greenfarm/tz_message/' + id,
    method: 'delete'
  })
}
