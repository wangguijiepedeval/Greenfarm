import request from '@/utils/request'

// 查询goods_relation管理列表
export function listGoods_relation(query) {
  return request({
    url: '/farm/goods_relation/list',
    method: 'get',
    params: query
  })
}

// 查询goods_relation管理详细
export function getGoods_relation(farmid) {
  return request({
    url: '/farm/goods_relation/' + farmid,
    method: 'get'
  })
}

// 新增goods_relation管理
export function addGoods_relation(data) {
  return request({
    url: '/farm/goods_relation',
    method: 'post',
    data: data
  })
}

// 修改goods_relation管理
export function updateGoods_relation(data) {
  return request({
    url: '/farm/goods_relation',
    method: 'put',
    data: data
  })
}

// 删除goods_relation管理
export function delGoods_relation(farmid) {
  return request({
    url: '/farm/goods_relation/' + farmid,
    method: 'delete'
  })
}
