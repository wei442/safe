package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Post;
import com.github.pagehelper.Page;

public interface IBootPostService {

    /**
	 * 分页查询
	 * @param page
	 * @param Post
	 * @return List<Post>
	 */
	public List<Post> selectPostListByPage(Page<?> page, Post Post);

	/**
	 * 不分页查询
	 * @param Post
	 * @return List<Post>
	 */
	public List<Post> selectPostList(Post Post);

    /**
     * 根据id查询岗位
     * @param id
     * @return Post
     */
	public Post selectPostById(Integer id);

    /**
     * 插入岗位
     * @param Post
     * @return Integer
     */
	public Integer insertPost(Post Post);

    /**
     * 修改岗位
     * @param Post
     * @return Integer
     */
	public Integer modifyPost(Post Post);

}