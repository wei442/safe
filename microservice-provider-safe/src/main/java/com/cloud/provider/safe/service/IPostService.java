package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.rest.request.page.post.PostPageRequest;
import com.github.pagehelper.Page;

public interface IPostService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Post>
	 */
	public List<Post> selectListByPage(Page<?> page, PostPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Post>
	 */
	public List<Post> selectList(PostPageRequest param);

    /**
     * 根据id查询岗位
     * @param id
     * @return Post
     */
	public Post selectById(Integer id);

    /**
     * 插入岗位
     * @param Post
     * @return Integer
     */
	public Integer insert(Post post);

 	/**
  	 * 根据id删除岗位
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改岗位
     * @param Post
     * @return Integer
     */
	public Integer modify(Post post);

}