import request from '@/utils/request'

// 查询购物车列表
export function listTz_basket(query) {
  return request({
    url: '/Greenfarm/tz_basket/list',
    method: 'get',
    params: query
  })
}

// 查询购物车详细
export function getTz_basket(basketId) {
  return request({
    url: '/Greenfarm/tz_basket/' + basketId,
    method: 'get'
  })
}

// 新增购物车
export function addTz_basket(data) {
  return request({
    url: '/Greenfarm/tz_basket',
    method: 'post',
    data: data
  })
}

// 修改购物车
export function updateTz_basket(data) {
  return request({
    url: '/Greenfarm/tz_basket',
    method: 'put',
    data: data
  })
}

// 删除购物车
export function delTz_basket(basketId) {
  return request({
    url: '/Greenfarm/tz_basket/' + basketId,
    method: 'delete'
  })
}
