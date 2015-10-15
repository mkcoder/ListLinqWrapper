package com.wordpress.mkscodingblog.func;

@FunctionalInterface
public interface Func<T, TResult> {
	TResult func(T t);
}
