import request from '@/utils/request'

// 查询产品类目列表
export function listTz_category(query) {
  return request({
    url: '/Greenfarm/tz_category/list',
    method: 'get',
    params: query
  })
}

// 查询产品类目详细
export function getTz_category(categoryId) {
  return request({
    url: '/Greenfarm/tz_category/' + categoryId,
    method: 'get'
  })
}

// 新增产品类目
export function addTz_category(data) {
  return request({
    url: '/Greenfarm/tz_category',
    method: 'post',
    data: data
  })
}

// 修改产品类目
export function updateTz_category(data) {
  return request({
    url: '/Greenfarm/tz_category',
    method: 'put',
    data: data
  })
}

// 删除产品类目
export function delTz_category(categoryId) {
  return request({
    url: '/Greenfarm/tz_category/' + categoryId,
    method: 'delete'
  })
}
