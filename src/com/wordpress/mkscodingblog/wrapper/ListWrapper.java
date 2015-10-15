package com.wordpress.mkscodingblog.wrapper;

import java.util.List;

import com.wordpress.mkscodingblog.action.Action;
import com.wordpress.mkscodingblog.func.Func;
import com.wordpress.mkscodingblog.impl.ListWrapperImpl;

public abstract class ListWrapper<T> {
	
	protected List<T> list;
	
	public ListWrapper(List<T> list) {
		this.list = list;
	}
	
	public abstract <T1> ListWrapperImpl<T> select(Func<T, T1> predicate);
	public abstract	ListWrapperImpl<T> forEach(Action<T> apply);
	public abstract <T1> ListWrapperImpl<T> where(Func<T, T1> predicate);
	public abstract T first(Func<T, Boolean> predicate);
	public abstract T last(Func<T, Boolean> apply);
	public abstract ListWrapperImpl<T> join(ListWrapperImpl<T> other);
	public abstract ListWrapperImpl<T> intersection(ListWrapperImpl<T> other);
	public abstract List<T> getList();
}

