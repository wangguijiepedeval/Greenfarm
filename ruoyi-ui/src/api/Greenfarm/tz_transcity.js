import request from '@/utils/request'

// 查询tz_transcity列表
export function listTz_transcity(query) {
  return request({
    url: '/Greenfarm/tz_transcity/list',
    method: 'get',
    params: query
  })
}

// 查询tz_transcity详细
export function getTz_transcity(transcityId) {
  return request({
    url: '/Greenfarm/tz_transcity/' + transcityId,
    method: 'get'
  })
}

// 新增tz_transcity
export function addTz_transcity(data) {
  return request({
    url: '/Greenfarm/tz_transcity',
    method: 'post',
    data: data
  })
}

// 修改tz_transcity
export function updateTz_transcity(data) {
  return request({
    url: '/Greenfarm/tz_transcity',
    method: 'put',
    data: data
  })
}

// 删除tz_transcity
export function delTz_transcity(transcityId) {
  return request({
    url: '/Greenfarm/tz_transcity/' + transcityId,
    method: 'delete'
  })
}
