import request from '@/utils/request'

// 查询记录列表
export function listTz_order_refund(query) {
  return request({
    url: '/Greenfarm/tz_order_refund/list',
    method: 'get',
    params: query
  })
}

// 查询记录详细
export function getTz_order_refund(refundId) {
  return request({
    url: '/Greenfarm/tz_order_refund/' + refundId,
    method: 'get'
  })
}

// 新增记录
export function addTz_order_refund(data) {
  return request({
    url: '/Greenfarm/tz_order_refund',
    method: 'post',
    data: data
  })
}

// 修改记录
export function updateTz_order_refund(data) {
  return request({
    url: '/Greenfarm/tz_order_refund',
    method: 'put',
    data: data
  })
}

// 删除记录
export function delTz_order_refund(refundId) {
  return request({
    url: '/Greenfarm/tz_order_refund/' + refundId,
    method: 'delete'
  })
}
