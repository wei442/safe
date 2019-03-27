package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Org;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class OrgVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgId;

	private Integer enterpriseId;

    private Integer parentOrgId;

    private String parentOrgName;

    private String orgName;

    private String orgAlias;

    private String orgTelphone;

    private Integer orgStatus;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    private List<OrgVo> orgList;

    /**
     * 实体转换
     * @param org
     * @return OrgVo
     */
    public OrgVo convertToOrgVo(Org org) {
    	OrgVoConvert convert = new OrgVoConvert();
    	return convert.doBackward(org);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<OrgVo>
     */
    public List<OrgVo> convertToOrgVoList(List<Org> list) {
    	OrgVoConvert convert = new OrgVoConvert();
    	List<OrgVo> orgVoList = null;
    	OrgVo orgVo = null;
    	if(list != null && !list.isEmpty()) {
    		orgVoList = new ArrayList<OrgVo>(list.size());
    		ListIterator<Org> it = list.listIterator();
    		while(it.hasNext()) {
    			Org org = it.next();
    			orgVo = convert.doBackward(org);
    			orgVoList.add(orgVo);
    		}
    	}
    	return orgVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class OrgVoConvert extends Converter<OrgVo, Org> {

    	@Override
    	protected Org doForward(OrgVo orgVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param org
    	 * @return OrgVo
    	 */
		@Override
		protected OrgVo doBackward(Org org) {
			OrgVo orgVo = new OrgVo();
			BeanUtils.copyProperties(org, orgVo);
			orgVo.setOrgId(org.getId());
			return orgVo;
		}

    }

}