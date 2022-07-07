import request from '@/utils/request'

// 查询购物车商品列表
export function listTz_category_prop(query) {
  return request({
    url: '/Greenfarm/tz_category_prop/list',
    method: 'get',
    params: query
  })
}

// 查询购物车商品详细
export function getTz_category_prop(id) {
  return request({
    url: '/Greenfarm/tz_category_prop/' + id,
    method: 'get'
  })
}

// 新增购物车商品
export function addTz_category_prop(data) {
  return request({
    url: '/Greenfarm/tz_category_prop',
    method: 'post',
    data: data
  })
}

// 修改购物车商品
export function updateTz_category_prop(data) {
  return request({
    url: '/Greenfarm/tz_category_prop',
    method: 'put',
    data: data
  })
}

// 删除购物车商品
export function delTz_category_prop(id) {
  return request({
    url: '/Greenfarm/tz_category_prop/' + id,
    method: 'delete'
  })
}
