import request from '@/utils/request'

// 查询菜单管理列表
export function listTz_sys_menu(query) {
  return request({
    url: '/Greenfarm/tz_sys_menu/list',
    method: 'get',
    params: query
  })
}

// 查询菜单管理详细
export function getTz_sys_menu(menuId) {
  return request({
    url: '/Greenfarm/tz_sys_menu/' + menuId,
    method: 'get'
  })
}

// 新增菜单管理
export function addTz_sys_menu(data) {
  return request({
    url: '/Greenfarm/tz_sys_menu',
    method: 'post',
    data: data
  })
}

// 修改菜单管理
export function updateTz_sys_menu(data) {
  return request({
    url: '/Greenfarm/tz_sys_menu',
    method: 'put',
    data: data
  })
}

// 删除菜单管理
export function delTz_sys_menu(menuId) {
  return request({
    url: '/Greenfarm/tz_sys_menu/' + menuId,
    method: 'delete'
  })
}
