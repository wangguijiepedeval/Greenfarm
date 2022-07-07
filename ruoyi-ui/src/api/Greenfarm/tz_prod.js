import request from '@/utils/request'

// 查询商品列表
export function listTz_prod(query) {
  return request({
    url: '/Greenfarm/tz_prod/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getTz_prod(prodId) {
  return request({
    url: '/Greenfarm/tz_prod/' + prodId,
    method: 'get'
  })
}

// 新增商品
export function addTz_prod(data) {
  return request({
    url: '/Greenfarm/tz_prod',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateTz_prod(data) {
  return request({
    url: '/Greenfarm/tz_prod',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delTz_prod(prodId) {
  return request({
    url: '/Greenfarm/tz_prod/' + prodId,
    method: 'delete'
  })
}
