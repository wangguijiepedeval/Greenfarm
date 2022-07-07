import request from '@/utils/request'

// 查询物流公司列表
export function listTz_delivery(query) {
  return request({
    url: '/Greenfarm/tz_delivery/list',
    method: 'get',
    params: query
  })
}

// 查询物流公司详细
export function getTz_delivery(dvyId) {
  return request({
    url: '/Greenfarm/tz_delivery/' + dvyId,
    method: 'get'
  })
}

// 新增物流公司
export function addTz_delivery(data) {
  return request({
    url: '/Greenfarm/tz_delivery',
    method: 'post',
    data: data
  })
}

// 修改物流公司
export function updateTz_delivery(data) {
  return request({
    url: '/Greenfarm/tz_delivery',
    method: 'put',
    data: data
  })
}

// 删除物流公司
export function delTz_delivery(dvyId) {
  return request({
    url: '/Greenfarm/tz_delivery/' + dvyId,
    method: 'delete'
  })
}
