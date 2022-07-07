import request from '@/utils/request'

// 查询热搜列表
export function listTz_hot_search(query) {
  return request({
    url: '/Greenfarm/tz_hot_search/list',
    method: 'get',
    params: query
  })
}

// 查询热搜详细
export function getTz_hot_search(hotSearchId) {
  return request({
    url: '/Greenfarm/tz_hot_search/' + hotSearchId,
    method: 'get'
  })
}

// 新增热搜
export function addTz_hot_search(data) {
  return request({
    url: '/Greenfarm/tz_hot_search',
    method: 'post',
    data: data
  })
}

// 修改热搜
export function updateTz_hot_search(data) {
  return request({
    url: '/Greenfarm/tz_hot_search',
    method: 'put',
    data: data
  })
}

// 删除热搜
export function delTz_hot_search(hotSearchId) {
  return request({
    url: '/Greenfarm/tz_hot_search/' + hotSearchId,
    method: 'delete'
  })
}
