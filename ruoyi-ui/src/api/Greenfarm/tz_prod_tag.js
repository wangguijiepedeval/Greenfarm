import request from '@/utils/request'

// 查询商品分组列表
export function listTz_prod_tag(query) {
  return request({
    url: '/Greenfarm/tz_prod_tag/list',
    method: 'get',
    params: query
  })
}

// 查询商品分组详细
export function getTz_prod_tag(id) {
  return request({
    url: '/Greenfarm/tz_prod_tag/' + id,
    method: 'get'
  })
}

// 新增商品分组
export function addTz_prod_tag(data) {
  return request({
    url: '/Greenfarm/tz_prod_tag',
    method: 'post',
    data: data
  })
}

// 修改商品分组
export function updateTz_prod_tag(data) {
  return request({
    url: '/Greenfarm/tz_prod_tag',
    method: 'put',
    data: data
  })
}

// 删除商品分组
export function delTz_prod_tag(id) {
  return request({
    url: '/Greenfarm/tz_prod_tag/' + id,
    method: 'delete'
  })
}
