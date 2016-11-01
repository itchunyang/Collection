public interface Queue<E> extends Collection<E>{
    boolean add(E e);
    boolean offer(E e);

    E remove();
    E poll();

    E element();
    E peek();
}



		可能报异常	不会报异常	可能阻塞	 设定等待时间
入队		add(e)		offer(e)	put(e)	 offer(e, timeout, unit)
出队		remove()	poll()		take()	 poll(timeout, unit)
查看		element()	peek()		无		 无