import request from '@/utils/request'

// 查询orders管理列表
export function listOrders(query) {
  return request({
    url: '/farm/orders/list',
    method: 'get',
    params: query
  })
}

// 查询orders管理详细
export function getOrders(orderid) {
  return request({
    url: '/farm/orders/' + orderid,
    method: 'get'
  })
}

// 新增orders管理
export function addOrders(data) {
  return request({
    url: '/farm/orders',
    method: 'post',
    data: data
  })
}

// 修改orders管理
export function updateOrders(data) {
  return request({
    url: '/farm/orders',
    method: 'put',
    data: data
  })
}

// 删除orders管理
export function delOrders(orderid) {
  return request({
    url: '/farm/orders/' + orderid,
    method: 'delete'
  })
}
