import request from '@/utils/request'

// 查询单品SKU列表
export function listTz_sku(query) {
  return request({
    url: '/Greenfarm/tz_sku/list',
    method: 'get',
    params: query
  })
}

// 查询单品SKU详细
export function getTz_sku(skuId) {
  return request({
    url: '/Greenfarm/tz_sku/' + skuId,
    method: 'get'
  })
}

// 新增单品SKU
export function addTz_sku(data) {
  return request({
    url: '/Greenfarm/tz_sku',
    method: 'post',
    data: data
  })
}

// 修改单品SKU
export function updateTz_sku(data) {
  return request({
    url: '/Greenfarm/tz_sku',
    method: 'put',
    data: data
  })
}

// 删除单品SKU
export function delTz_sku(skuId) {
  return request({
    url: '/Greenfarm/tz_sku/' + skuId,
    method: 'delete'
  })
}
