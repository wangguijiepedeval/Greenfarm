import request from '@/utils/request'

// 查询支付信息列表
export function listTz_order_settlement(query) {
  return request({
    url: '/Greenfarm/tz_order_settlement/list',
    method: 'get',
    params: query
  })
}

// 查询支付信息详细
export function getTz_order_settlement(settlementId) {
  return request({
    url: '/Greenfarm/tz_order_settlement/' + settlementId,
    method: 'get'
  })
}

// 新增支付信息
export function addTz_order_settlement(data) {
  return request({
    url: '/Greenfarm/tz_order_settlement',
    method: 'post',
    data: data
  })
}

// 修改支付信息
export function updateTz_order_settlement(data) {
  return request({
    url: '/Greenfarm/tz_order_settlement',
    method: 'put',
    data: data
  })
}

// 删除支付信息
export function delTz_order_settlement(settlementId) {
  return request({
    url: '/Greenfarm/tz_order_settlement/' + settlementId,
    method: 'delete'
  })
}
