import request from '@/utils/request'

// 查询rent_relation管理列表
export function listRent_relation(query) {
  return request({
    url: '/farm/rent_relation/list',
    method: 'get',
    params: query
  })
}

// 查询rent_relation管理详细
export function getRent_relation(userid) {
  return request({
    url: '/farm/rent_relation/' + userid,
    method: 'get'
  })
}

// 新增rent_relation管理
export function addRent_relation(data) {
  return request({
    url: '/farm/rent_relation',
    method: 'post',
    data: data
  })
}

// 修改rent_relation管理
export function updateRent_relation(data) {
  return request({
    url: '/farm/rent_relation',
    method: 'put',
    data: data
  })
}

// 删除rent_relation管理
export function delRent_relation(userid) {
  return request({
    url: '/farm/rent_relation/' + userid,
    method: 'delete'
  })
}
