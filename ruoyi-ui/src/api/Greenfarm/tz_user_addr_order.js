import request from '@/utils/request'

// 查询用户订单配送地址列表
export function listTz_user_addr_order(query) {
  return request({
    url: '/Greenfarm/tz_user_addr_order/list',
    method: 'get',
    params: query
  })
}

// 查询用户订单配送地址详细
export function getTz_user_addr_order(addrOrderId) {
  return request({
    url: '/Greenfarm/tz_user_addr_order/' + addrOrderId,
    method: 'get'
  })
}

// 新增用户订单配送地址
export function addTz_user_addr_order(data) {
  return request({
    url: '/Greenfarm/tz_user_addr_order',
    method: 'post',
    data: data
  })
}

// 修改用户订单配送地址
export function updateTz_user_addr_order(data) {
  return request({
    url: '/Greenfarm/tz_user_addr_order',
    method: 'put',
    data: data
  })
}

// 删除用户订单配送地址
export function delTz_user_addr_order(addrOrderId) {
  return request({
    url: '/Greenfarm/tz_user_addr_order/' + addrOrderId,
    method: 'delete'
  })
}
