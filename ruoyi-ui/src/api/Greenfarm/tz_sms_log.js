import request from '@/utils/request'

// 查询短信记录列表
export function listTz_sms_log(query) {
  return request({
    url: '/Greenfarm/tz_sms_log/list',
    method: 'get',
    params: query
  })
}

// 查询短信记录详细
export function getTz_sms_log(id) {
  return request({
    url: '/Greenfarm/tz_sms_log/' + id,
    method: 'get'
  })
}

// 新增短信记录
export function addTz_sms_log(data) {
  return request({
    url: '/Greenfarm/tz_sms_log',
    method: 'post',
    data: data
  })
}

// 修改短信记录
export function updateTz_sms_log(data) {
  return request({
    url: '/Greenfarm/tz_sms_log',
    method: 'put',
    data: data
  })
}

// 删除短信记录
export function delTz_sms_log(id) {
  return request({
    url: '/Greenfarm/tz_sms_log/' + id,
    method: 'delete'
  })
}
