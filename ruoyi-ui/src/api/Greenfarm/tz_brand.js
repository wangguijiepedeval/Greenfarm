import request from '@/utils/request'

// 查询品牌列表
export function listTz_brand(query) {
  return request({
    url: '/Greenfarm/tz_brand/list',
    method: 'get',
    params: query
  })
}

// 查询品牌详细
export function getTz_brand(brandId) {
  return request({
    url: '/Greenfarm/tz_brand/' + brandId,
    method: 'get'
  })
}

// 新增品牌
export function addTz_brand(data) {
  return request({
    url: '/Greenfarm/tz_brand',
    method: 'post',
    data: data
  })
}

// 修改品牌
export function updateTz_brand(data) {
  return request({
    url: '/Greenfarm/tz_brand',
    method: 'put',
    data: data
  })
}

// 删除品牌
export function delTz_brand(brandId) {
  return request({
    url: '/Greenfarm/tz_brand/' + brandId,
    method: 'delete'
  })
}
