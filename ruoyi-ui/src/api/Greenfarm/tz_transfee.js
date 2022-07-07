import request from '@/utils/request'

// 查询运费信息列表
export function listTz_transfee(query) {
  return request({
    url: '/Greenfarm/tz_transfee/list',
    method: 'get',
    params: query
  })
}

// 查询运费信息详细
export function getTz_transfee(transfeeId) {
  return request({
    url: '/Greenfarm/tz_transfee/' + transfeeId,
    method: 'get'
  })
}

// 新增运费信息
export function addTz_transfee(data) {
  return request({
    url: '/Greenfarm/tz_transfee',
    method: 'post',
    data: data
  })
}

// 修改运费信息
export function updateTz_transfee(data) {
  return request({
    url: '/Greenfarm/tz_transfee',
    method: 'put',
    data: data
  })
}

// 删除运费信息
export function delTz_transfee(transfeeId) {
  return request({
    url: '/Greenfarm/tz_transfee/' + transfeeId,
    method: 'delete'
  })
}
