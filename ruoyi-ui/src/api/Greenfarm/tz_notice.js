import request from '@/utils/request'

// 查询公告列表
export function listTz_notice(query) {
  return request({
    url: '/Greenfarm/tz_notice/list',
    method: 'get',
    params: query
  })
}

// 查询公告详细
export function getTz_notice(id) {
  return request({
    url: '/Greenfarm/tz_notice/' + id,
    method: 'get'
  })
}

// 新增公告
export function addTz_notice(data) {
  return request({
    url: '/Greenfarm/tz_notice',
    method: 'post',
    data: data
  })
}

// 修改公告
export function updateTz_notice(data) {
  return request({
    url: '/Greenfarm/tz_notice',
    method: 'put',
    data: data
  })
}

// 删除公告
export function delTz_notice(id) {
  return request({
    url: '/Greenfarm/tz_notice/' + id,
    method: 'delete'
  })
}
