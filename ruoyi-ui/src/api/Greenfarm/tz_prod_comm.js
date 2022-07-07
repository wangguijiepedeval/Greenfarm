import request from '@/utils/request'

// 查询商品评论列表
export function listTz_prod_comm(query) {
  return request({
    url: '/Greenfarm/tz_prod_comm/list',
    method: 'get',
    params: query
  })
}

// 查询商品评论详细
export function getTz_prod_comm(prodCommId) {
  return request({
    url: '/Greenfarm/tz_prod_comm/' + prodCommId,
    method: 'get'
  })
}

// 新增商品评论
export function addTz_prod_comm(data) {
  return request({
    url: '/Greenfarm/tz_prod_comm',
    method: 'post',
    data: data
  })
}

// 修改商品评论
export function updateTz_prod_comm(data) {
  return request({
    url: '/Greenfarm/tz_prod_comm',
    method: 'put',
    data: data
  })
}

// 删除商品评论
export function delTz_prod_comm(prodCommId) {
  return request({
    url: '/Greenfarm/tz_prod_comm/' + prodCommId,
    method: 'delete'
  })
}
