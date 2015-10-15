package com.wordpress.mkscodingblog.impl;

import java.util.ArrayList;
import java.util.List;

import com.wordpress.mkscodingblog.action.Action;
import com.wordpress.mkscodingblog.func.Func;
import com.wordpress.mkscodingblog.wrapper.ListWrapper;

public class ListWrapperImpl<T> extends ListWrapper<T> {

	public ListWrapperImpl(List<T> list) {
		super(list);
	}
	
	private ListWrapperImpl<T> ToWrapper(List<T> temp) {
		return new ListWrapperImpl<T>(temp);
	}

	@Override
	public <T2> ListWrapperImpl<T> select(Func<T, T2> predicate) {
		List<T> temp = new ArrayList<T>();
		for ( T t : list )
			if ( (Boolean) predicate.func(t) ) 
				temp.add(t);
		return ToWrapper(temp);
	}
	
	@Override
	public ListWrapperImpl<T> forEach(Action<T> call) {
		for ( T t : list )
			call.action(t);		
		return ToWrapper(list);
	}

	@Override
	public T first(Func<T, Boolean> apply) {
		for ( T t : list)
			if ( apply.func(t) )
				return t;
		return null;
	}

	@Override
	public <T1> ListWrapperImpl<T> where(Func<T, T1> predicate) {
		// TODO: unimplemented
		return null;
	}

	@Override
	public T last(Func<T, Boolean> apply) {
		T r = null;
		for ( T t : list)
			if ( apply.func(t) )
				r = t;
		return r;
	}

	@Override
	public ListWrapperImpl<T> join(ListWrapperImpl<T> other) {
		for (T o : other.list) {
			boolean addToList = true;
			for (T t : list)
				if ( t == o )
					addToList = false;
			if ( addToList ) list.add(o);
		}
		return ToWrapper(list);
	}
	
	@Override
	public List<T> getList() {
		return list;
	}

	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{ "));
		for (T t : list )
			sb.append(t+" ");
		sb.append(" }\n");
		return sb.toString();
	}

	@Override
	public ListWrapperImpl<T> intersection(ListWrapperImpl<T> other) {
		List<T> r = new ArrayList<T>();
		for (T o : other.list) {
			boolean addToList = false;
			for (T t : list)
				if ( t == o )
					addToList = true;
			if ( addToList ) r.add(o);
		}		
		return ToWrapper(r);		
	}

	public void replace(ListWrapperImpl<T> l) {
		// TODO Auto-generated method stub
		l.list = this.list;
	}
	
}
