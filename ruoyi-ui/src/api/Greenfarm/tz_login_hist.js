import request from '@/utils/request'

// 查询登录历史列表
export function listTz_login_hist(query) {
  return request({
    url: '/Greenfarm/tz_login_hist/list',
    method: 'get',
    params: query
  })
}

// 查询登录历史详细
export function getTz_login_hist(id) {
  return request({
    url: '/Greenfarm/tz_login_hist/' + id,
    method: 'get'
  })
}

// 新增登录历史
export function addTz_login_hist(data) {
  return request({
    url: '/Greenfarm/tz_login_hist',
    method: 'post',
    data: data
  })
}

// 修改登录历史
export function updateTz_login_hist(data) {
  return request({
    url: '/Greenfarm/tz_login_hist',
    method: 'put',
    data: data
  })
}

// 删除登录历史
export function delTz_login_hist(id) {
  return request({
    url: '/Greenfarm/tz_login_hist/' + id,
    method: 'delete'
  })
}
