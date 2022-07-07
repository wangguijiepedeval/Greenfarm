import request from '@/utils/request'

// 查询系统配置信息列表
export function listTz_sys_config(query) {
  return request({
    url: '/Greenfarm/tz_sys_config/list',
    method: 'get',
    params: query
  })
}

// 查询系统配置信息详细
export function getTz_sys_config(id) {
  return request({
    url: '/Greenfarm/tz_sys_config/' + id,
    method: 'get'
  })
}

// 新增系统配置信息
export function addTz_sys_config(data) {
  return request({
    url: '/Greenfarm/tz_sys_config',
    method: 'post',
    data: data
  })
}

// 修改系统配置信息
export function updateTz_sys_config(data) {
  return request({
    url: '/Greenfarm/tz_sys_config',
    method: 'put',
    data: data
  })
}

// 删除系统配置信息
export function delTz_sys_config(id) {
  return request({
    url: '/Greenfarm/tz_sys_config/' + id,
    method: 'delete'
  })
}
