import request from '@/utils/request'

// 查询订单详情列表
export function listTz_transport(query) {
  return request({
    url: '/Greenfarm/tz_transport/list',
    method: 'get',
    params: query
  })
}

// 查询订单详情详细
export function getTz_transport(transportId) {
  return request({
    url: '/Greenfarm/tz_transport/' + transportId,
    method: 'get'
  })
}

// 新增订单详情
export function addTz_transport(data) {
  return request({
    url: '/Greenfarm/tz_transport',
    method: 'post',
    data: data
  })
}

// 修改订单详情
export function updateTz_transport(data) {
  return request({
    url: '/Greenfarm/tz_transport',
    method: 'put',
    data: data
  })
}

// 删除订单详情
export function delTz_transport(transportId) {
  return request({
    url: '/Greenfarm/tz_transport/' + transportId,
    method: 'delete'
  })
}
