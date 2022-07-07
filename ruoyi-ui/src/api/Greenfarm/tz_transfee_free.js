import request from '@/utils/request'

// 查询运费信息列表
export function listTz_transfee_free(query) {
  return request({
    url: '/Greenfarm/tz_transfee_free/list',
    method: 'get',
    params: query
  })
}

// 查询运费信息详细
export function getTz_transfee_free(transfeeFreeId) {
  return request({
    url: '/Greenfarm/tz_transfee_free/' + transfeeFreeId,
    method: 'get'
  })
}

// 新增运费信息
export function addTz_transfee_free(data) {
  return request({
    url: '/Greenfarm/tz_transfee_free',
    method: 'post',
    data: data
  })
}

// 修改运费信息
export function updateTz_transfee_free(data) {
  return request({
    url: '/Greenfarm/tz_transfee_free',
    method: 'put',
    data: data
  })
}

// 删除运费信息
export function delTz_transfee_free(transfeeFreeId) {
  return request({
    url: '/Greenfarm/tz_transfee_free/' + transfeeFreeId,
    method: 'delete'
  })
}
