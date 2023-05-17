package com.vo;

import java.io.Serializable;

public class CategoryVO implements Serializable {

	private static final long serialVersionUID = -5488829418875615692L;

	private String name;
	private Long count;

	public CategoryVO(String name, Long count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CategoryVO [name=" + name + ", count=" + count + "]";
	}

}
