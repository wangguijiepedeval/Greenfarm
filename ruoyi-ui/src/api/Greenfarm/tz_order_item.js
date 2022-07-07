import request from '@/utils/request'

// 查询订单项列表
export function listTz_order_item(query) {
  return request({
    url: '/Greenfarm/tz_order_item/list',
    method: 'get',
    params: query
  })
}

// 查询订单项详细
export function getTz_order_item(orderItemId) {
  return request({
    url: '/Greenfarm/tz_order_item/' + orderItemId,
    method: 'get'
  })
}

// 新增订单项
export function addTz_order_item(data) {
  return request({
    url: '/Greenfarm/tz_order_item',
    method: 'post',
    data: data
  })
}

// 修改订单项
export function updateTz_order_item(data) {
  return request({
    url: '/Greenfarm/tz_order_item',
    method: 'put',
    data: data
  })
}

// 删除订单项
export function delTz_order_item(orderItemId) {
  return request({
    url: '/Greenfarm/tz_order_item/' + orderItemId,
    method: 'delete'
  })
}
