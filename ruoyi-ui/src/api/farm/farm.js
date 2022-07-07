import request from '@/utils/request'

// 查询farm管理列表
export function listFarm(query) {
  return request({
    url: '/farm/farm/list',
    method: 'get',
    params: query
  })
}

// 查询farm管理详细
export function getFarm(farmid) {
  return request({
    url: '/farm/farm/' + farmid,
    method: 'get'
  })
}

// 新增farm管理
export function addFarm(data) {
  return request({
    url: '/farm/farm',
    method: 'post',
    data: data
  })
}

// 修改farm管理
export function updateFarm(data) {
  return request({
    url: '/farm/farm',
    method: 'put',
    data: data
  })
}

// 删除farm管理
export function delFarm(farmid) {
  return request({
    url: '/farm/farm/' + farmid,
    method: 'delete'
  })
}
