import request from '@/utils/request'

// 查询属性值列表
export function listTz_prod_prop_value(query) {
  return request({
    url: '/Greenfarm/tz_prod_prop_value/list',
    method: 'get',
    params: query
  })
}

// 查询属性值详细
export function getTz_prod_prop_value(valueId) {
  return request({
    url: '/Greenfarm/tz_prod_prop_value/' + valueId,
    method: 'get'
  })
}

// 新增属性值
export function addTz_prod_prop_value(data) {
  return request({
    url: '/Greenfarm/tz_prod_prop_value',
    method: 'post',
    data: data
  })
}

// 修改属性值
export function updateTz_prod_prop_value(data) {
  return request({
    url: '/Greenfarm/tz_prod_prop_value',
    method: 'put',
    data: data
  })
}

// 删除属性值
export function delTz_prod_prop_value(valueId) {
  return request({
    url: '/Greenfarm/tz_prod_prop_value/' + valueId,
    method: 'delete'
  })
}
