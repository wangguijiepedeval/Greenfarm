import request from '@/utils/request'

// 查询orders_customer_relation管理列表
export function listOrders_customer_relation(query) {
  return request({
    url: '/farm/orders_customer_relation/list',
    method: 'get',
    params: query
  })
}

// 查询orders_customer_relation管理详细
export function getOrders_customer_relation(ordersid) {
  return request({
    url: '/farm/orders_customer_relation/' + ordersid,
    method: 'get'
  })
}

// 新增orders_customer_relation管理
export function addOrders_customer_relation(data) {
  return request({
    url: '/farm/orders_customer_relation',
    method: 'post',
    data: data
  })
}

// 修改orders_customer_relation管理
export function updateOrders_customer_relation(data) {
  return request({
    url: '/farm/orders_customer_relation',
    method: 'put',
    data: data
  })
}

// 删除orders_customer_relation管理
export function delOrders_customer_relation(ordersid) {
  return request({
    url: '/farm/orders_customer_relation/' + ordersid,
    method: 'delete'
  })
}
