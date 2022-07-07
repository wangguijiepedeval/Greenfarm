import request from '@/utils/request'

// 查询goods管理列表
export function listGoods(query) {
  return request({
    url: '/farm/goods/list',
    method: 'get',
    params: query
  })
}

// 查询goods管理详细
export function getGoods(goodsid) {
  return request({
    url: '/farm/goods/' + goodsid,
    method: 'get'
  })
}

// 新增goods管理
export function addGoods(data) {
  return request({
    url: '/farm/goods',
    method: 'post',
    data: data
  })
}

// 修改goods管理
export function updateGoods(data) {
  return request({
    url: '/farm/goods',
    method: 'put',
    data: data
  })
}

// 删除goods管理
export function delGoods(goodsid) {
  return request({
    url: '/farm/goods/' + goodsid,
    method: 'delete'
  })
}
