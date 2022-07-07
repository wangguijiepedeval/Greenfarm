import request from '@/utils/request'

// 查询地址信息列表
export function listTz_area(query) {
  return request({
    url: '/Greenfarm/tz_area/list',
    method: 'get',
    params: query
  })
}

// 查询地址信息详细
export function getTz_area(areaId) {
  return request({
    url: '/Greenfarm/tz_area/' + areaId,
    method: 'get'
  })
}

// 新增地址信息
export function addTz_area(data) {
  return request({
    url: '/Greenfarm/tz_area',
    method: 'post',
    data: data
  })
}

// 修改地址信息
export function updateTz_area(data) {
  return request({
    url: '/Greenfarm/tz_area',
    method: 'put',
    data: data
  })
}

// 删除地址信息
export function delTz_area(areaId) {
  return request({
    url: '/Greenfarm/tz_area/' + areaId,
    method: 'delete'
  })
}
