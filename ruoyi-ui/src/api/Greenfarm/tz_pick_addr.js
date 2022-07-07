import request from '@/utils/request'

// 查询用户配送地址列表
export function listTz_pick_addr(query) {
  return request({
    url: '/Greenfarm/tz_pick_addr/list',
    method: 'get',
    params: query
  })
}

// 查询用户配送地址详细
export function getTz_pick_addr(addrId) {
  return request({
    url: '/Greenfarm/tz_pick_addr/' + addrId,
    method: 'get'
  })
}

// 新增用户配送地址
export function addTz_pick_addr(data) {
  return request({
    url: '/Greenfarm/tz_pick_addr',
    method: 'post',
    data: data
  })
}

// 修改用户配送地址
export function updateTz_pick_addr(data) {
  return request({
    url: '/Greenfarm/tz_pick_addr',
    method: 'put',
    data: data
  })
}

// 删除用户配送地址
export function delTz_pick_addr(addrId) {
  return request({
    url: '/Greenfarm/tz_pick_addr/' + addrId,
    method: 'delete'
  })
}
