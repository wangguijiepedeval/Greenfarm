import request from '@/utils/request'

// 查询userinfo管理列表
export function listUserinfo(query) {
  return request({
    url: '/farm/userinfo/list',
    method: 'get',
    params: query
  })
}

// 查询userinfo管理详细
export function getUserinfo(uesrid) {
  return request({
    url: '/farm/userinfo/' + uesrid,
    method: 'get'
  })
}

// 新增userinfo管理
export function addUserinfo(data) {
  return request({
    url: '/farm/userinfo',
    method: 'post',
    data: data
  })
}

// 修改userinfo管理
export function updateUserinfo(data) {
  return request({
    url: '/farm/userinfo',
    method: 'put',
    data: data
  })
}

// 删除userinfo管理
export function delUserinfo(uesrid) {
  return request({
    url: '/farm/userinfo/' + uesrid,
    method: 'delete'
  })
}
