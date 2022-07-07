import request from '@/utils/request'

// 查询店铺信息列表
export function listTz_prod_prop(query) {
  return request({
    url: '/Greenfarm/tz_prod_prop/list',
    method: 'get',
    params: query
  })
}

// 查询店铺信息详细
export function getTz_prod_prop(propId) {
  return request({
    url: '/Greenfarm/tz_prod_prop/' + propId,
    method: 'get'
  })
}

// 新增店铺信息
export function addTz_prod_prop(data) {
  return request({
    url: '/Greenfarm/tz_prod_prop',
    method: 'post',
    data: data
  })
}

// 修改店铺信息
export function updateTz_prod_prop(data) {
  return request({
    url: '/Greenfarm/tz_prod_prop',
    method: 'put',
    data: data
  })
}

// 删除店铺信息
export function delTz_prod_prop(propId) {
  return request({
    url: '/Greenfarm/tz_prod_prop/' + propId,
    method: 'delete'
  })
}
