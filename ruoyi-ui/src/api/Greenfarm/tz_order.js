import request from '@/utils/request'

// 查询订单列表
export function listTz_order(query) {
  return request({
    url: '/Greenfarm/tz_order/list',
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getTz_order(orderId) {
  return request({
    url: '/Greenfarm/tz_order/' + orderId,
    method: 'get'
  })
}

// 新增订单
export function addTz_order(data) {
  return request({
    url: '/Greenfarm/tz_order',
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateTz_order(data) {
  return request({
    url: '/Greenfarm/tz_order',
    method: 'put',
    data: data
  })
}

// 删除订单
export function delTz_order(orderId) {
  return request({
    url: '/Greenfarm/tz_order/' + orderId,
    method: 'delete'
  })
}
