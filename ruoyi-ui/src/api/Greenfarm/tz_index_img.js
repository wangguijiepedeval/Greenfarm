import request from '@/utils/request'

// 查询主页轮播图列表
export function listTz_index_img(query) {
  return request({
    url: '/Greenfarm/tz_index_img/list',
    method: 'get',
    params: query
  })
}

// 查询主页轮播图详细
export function getTz_index_img(imgId) {
  return request({
    url: '/Greenfarm/tz_index_img/' + imgId,
    method: 'get'
  })
}

// 新增主页轮播图
export function addTz_index_img(data) {
  return request({
    url: '/Greenfarm/tz_index_img',
    method: 'post',
    data: data
  })
}

// 修改主页轮播图
export function updateTz_index_img(data) {
  return request({
    url: '/Greenfarm/tz_index_img',
    method: 'put',
    data: data
  })
}

// 删除主页轮播图
export function delTz_index_img(imgId) {
  return request({
    url: '/Greenfarm/tz_index_img/' + imgId,
    method: 'delete'
  })
}
