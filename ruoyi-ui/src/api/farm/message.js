import request from '@/utils/request'

// 查询message管理列表
export function listMessage(query) {
  return request({
    url: '/farm/message/list',
    method: 'get',
    params: query
  })
}

// 查询message管理详细
export function getMessage(messageid) {
  return request({
    url: '/farm/message/' + messageid,
    method: 'get'
  })
}

// 新增message管理
export function addMessage(data) {
  return request({
    url: '/farm/message',
    method: 'post',
    data: data
  })
}

// 修改message管理
export function updateMessage(data) {
  return request({
    url: '/farm/message',
    method: 'put',
    data: data
  })
}

// 删除message管理
export function delMessage(messageid) {
  return request({
    url: '/farm/message/' + messageid,
    method: 'delete'
  })
}
