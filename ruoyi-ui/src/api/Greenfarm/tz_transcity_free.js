import request from '@/utils/request'

// 查询包邮信息列表
export function listTz_transcity_free(query) {
  return request({
    url: '/Greenfarm/tz_transcity_free/list',
    method: 'get',
    params: query
  })
}

// 查询包邮信息详细
export function getTz_transcity_free(transcityFreeId) {
  return request({
    url: '/Greenfarm/tz_transcity_free/' + transcityFreeId,
    method: 'get'
  })
}

// 新增包邮信息
export function addTz_transcity_free(data) {
  return request({
    url: '/Greenfarm/tz_transcity_free',
    method: 'post',
    data: data
  })
}

// 修改包邮信息
export function updateTz_transcity_free(data) {
  return request({
    url: '/Greenfarm/tz_transcity_free',
    method: 'put',
    data: data
  })
}

// 删除包邮信息
export function delTz_transcity_free(transcityFreeId) {
  return request({
    url: '/Greenfarm/tz_transcity_free/' + transcityFreeId,
    method: 'delete'
  })
}
