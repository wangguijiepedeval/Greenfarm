import request from '@/utils/request'

// 查询商品收藏列表
export function listTz_prod_favorite(query) {
  return request({
    url: '/Greenfarm/tz_prod_favorite/list',
    method: 'get',
    params: query
  })
}

// 查询商品收藏详细
export function getTz_prod_favorite(favoriteId) {
  return request({
    url: '/Greenfarm/tz_prod_favorite/' + favoriteId,
    method: 'get'
  })
}

// 新增商品收藏
export function addTz_prod_favorite(data) {
  return request({
    url: '/Greenfarm/tz_prod_favorite',
    method: 'post',
    data: data
  })
}

// 修改商品收藏
export function updateTz_prod_favorite(data) {
  return request({
    url: '/Greenfarm/tz_prod_favorite',
    method: 'put',
    data: data
  })
}

// 删除商品收藏
export function delTz_prod_favorite(favoriteId) {
  return request({
    url: '/Greenfarm/tz_prod_favorite/' + favoriteId,
    method: 'delete'
  })
}
