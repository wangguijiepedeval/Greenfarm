import request from '@/utils/request'

// 查询敏感字过滤列表
export function listTz_sens_word(query) {
  return request({
    url: '/Greenfarm/tz_sens_word/list',
    method: 'get',
    params: query
  })
}

// 查询敏感字过滤详细
export function getTz_sens_word(sensId) {
  return request({
    url: '/Greenfarm/tz_sens_word/' + sensId,
    method: 'get'
  })
}

// 新增敏感字过滤
export function addTz_sens_word(data) {
  return request({
    url: '/Greenfarm/tz_sens_word',
    method: 'post',
    data: data
  })
}

// 修改敏感字过滤
export function updateTz_sens_word(data) {
  return request({
    url: '/Greenfarm/tz_sens_word',
    method: 'put',
    data: data
  })
}

// 删除敏感字过滤
export function delTz_sens_word(sensId) {
  return request({
    url: '/Greenfarm/tz_sens_word/' + sensId,
    method: 'delete'
  })
}
