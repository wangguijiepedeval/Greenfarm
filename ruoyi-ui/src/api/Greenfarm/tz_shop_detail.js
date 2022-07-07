import request from '@/utils/request'

// 查询商家管理列表
export function listTz_shop_detail(query) {
  return request({
    url: '/Greenfarm/tz_shop_detail/list',
    method: 'get',
    params: query
  })
}

// 查询商家管理详细
export function getTz_shop_detail(shopId) {
  return request({
    url: '/Greenfarm/tz_shop_detail/' + shopId,
    method: 'get'
  })
}

// 新增商家管理
export function addTz_shop_detail(data) {
  return request({
    url: '/Greenfarm/tz_shop_detail',
    method: 'post',
    data: data
  })
}

// 修改商家管理
export function updateTz_shop_detail(data) {
  return request({
    url: '/Greenfarm/tz_shop_detail',
    method: 'put',
    data: data
  })
}

// 删除商家管理
export function delTz_shop_detail(shopId) {
  return request({
    url: '/Greenfarm/tz_shop_detail/' + shopId,
    method: 'delete'
  })
}
