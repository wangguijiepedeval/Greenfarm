import request from '@/utils/request'

// 查询店铺分组列表
export function listTz_prod_tag_reference(query) {
  return request({
    url: '/Greenfarm/tz_prod_tag_reference/list',
    method: 'get',
    params: query
  })
}

// 查询店铺分组详细
export function getTz_prod_tag_reference(referenceId) {
  return request({
    url: '/Greenfarm/tz_prod_tag_reference/' + referenceId,
    method: 'get'
  })
}

// 新增店铺分组
export function addTz_prod_tag_reference(data) {
  return request({
    url: '/Greenfarm/tz_prod_tag_reference',
    method: 'post',
    data: data
  })
}

// 修改店铺分组
export function updateTz_prod_tag_reference(data) {
  return request({
    url: '/Greenfarm/tz_prod_tag_reference',
    method: 'put',
    data: data
  })
}

// 删除店铺分组
export function delTz_prod_tag_reference(referenceId) {
  return request({
    url: '/Greenfarm/tz_prod_tag_reference/' + referenceId,
    method: 'delete'
  })
}
