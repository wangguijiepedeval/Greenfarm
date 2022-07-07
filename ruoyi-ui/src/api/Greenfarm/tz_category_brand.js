import request from '@/utils/request'

// 查询购物车与品牌列表
export function listTz_category_brand(query) {
  return request({
    url: '/Greenfarm/tz_category_brand/list',
    method: 'get',
    params: query
  })
}

// 查询购物车与品牌详细
export function getTz_category_brand(id) {
  return request({
    url: '/Greenfarm/tz_category_brand/' + id,
    method: 'get'
  })
}

// 新增购物车与品牌
export function addTz_category_brand(data) {
  return request({
    url: '/Greenfarm/tz_category_brand',
    method: 'post',
    data: data
  })
}

// 修改购物车与品牌
export function updateTz_category_brand(data) {
  return request({
    url: '/Greenfarm/tz_category_brand',
    method: 'put',
    data: data
  })
}

// 删除购物车与品牌
export function delTz_category_brand(id) {
  return request({
    url: '/Greenfarm/tz_category_brand/' + id,
    method: 'delete'
  })
}
