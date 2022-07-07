import request from '@/utils/request'

// 查询cart管理列表
export function listCart(query) {
  return request({
    url: '/farm/cart/list',
    method: 'get',
    params: query
  })
}

// 查询cart管理详细
export function getCart(userid) {
  return request({
    url: '/farm/cart/' + userid,
    method: 'get'
  })
}

// 新增cart管理
export function addCart(data) {
  return request({
    url: '/farm/cart',
    method: 'post',
    data: data
  })
}

// 修改cart管理
export function updateCart(data) {
  return request({
    url: '/farm/cart',
    method: 'put',
    data: data
  })
}

// 删除cart管理
export function delCart(userid) {
  return request({
    url: '/farm/cart/' + userid,
    method: 'delete'
  })
}
