import request from '@/utils/request'

// 查询文件管理列表
export function listTz_attach_file(query) {
  return request({
    url: '/Greenfarm/tz_attach_file/list',
    method: 'get',
    params: query
  })
}

// 查询文件管理详细
export function getTz_attach_file(fileId) {
  return request({
    url: '/Greenfarm/tz_attach_file/' + fileId,
    method: 'get'
  })
}

// 新增文件管理
export function addTz_attach_file(data) {
  return request({
    url: '/Greenfarm/tz_attach_file',
    method: 'post',
    data: data
  })
}

// 修改文件管理
export function updateTz_attach_file(data) {
  return request({
    url: '/Greenfarm/tz_attach_file',
    method: 'put',
    data: data
  })
}

// 删除文件管理
export function delTz_attach_file(fileId) {
  return request({
    url: '/Greenfarm/tz_attach_file/' + fileId,
    method: 'delete'
  })
}
