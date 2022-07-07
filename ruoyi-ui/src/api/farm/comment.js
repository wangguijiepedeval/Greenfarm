import request from '@/utils/request'

// 查询comment管理列表
export function listComment(query) {
  return request({
    url: '/farm/comment/list',
    method: 'get',
    params: query
  })
}

// 查询comment管理详细
export function getComment(commentatorid) {
  return request({
    url: '/farm/comment/' + commentatorid,
    method: 'get'
  })
}

// 新增comment管理
export function addComment(data) {
  return request({
    url: '/farm/comment',
    method: 'post',
    data: data
  })
}

// 修改comment管理
export function updateComment(data) {
  return request({
    url: '/farm/comment',
    method: 'put',
    data: data
  })
}

// 删除comment管理
export function delComment(commentatorid) {
  return request({
    url: '/farm/comment/' + commentatorid,
    method: 'delete'
  })
}
