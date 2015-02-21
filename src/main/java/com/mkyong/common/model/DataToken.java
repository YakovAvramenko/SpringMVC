package com.mkyong.common.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
@Deprecated
public class DataToken implements Serializable {
	
	private Date date;
	
	public DataToken() {
		date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DataToken [date=" + date + "]";
	}

	public Map toMap() {
		try {
			return BeanUtils.describe(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
