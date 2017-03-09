import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class CQueue<T> implements IQueue<T> {

	
	private ArrayList<T> list;
	public CQueue()
	{
		list = new ArrayList<T>();
	}
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	
	public int size()
	{
		return list.size();
	}
	
	public void insert(T item, int element)
	{
		list.add(element, item);
	}
	
	public T get(int i)
	{
		return list.get(i);
	}

	@Override
	public boolean offer(T item) {
		// TODO Auto-generated method stub
		return list.add(item);
	}

	@Override
	public T poll() {
		
		if (empty())
		{
			return null;
		}
		
		return list.remove(0);
	}

	@Override
	public T peek() {
		if (empty())
		{
			return null;
		}
		
		return list.get(0);
	}
	
	public void sort(Comparator<? super T> comparator)
	{
		list.sort(comparator);
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	
	public CQueue<T> reverse()
	{
		Stack<T> stack = new Stack<T>();
		while (!list.isEmpty())
		{
			stack.push(poll());
		}
		
		while (!stack.empty())
		{
			offer(stack.pop());
		}
		
		return this;
	}
	
	public CQueue<T> append(CQueue<T> queue)
	{
		while (!queue.empty())
			offer(queue.poll());
		
		return this;
	}
	
	public CQueue<T> alternate(CQueue<T> queue)
	{
		CQueue<T> newqueue = new CQueue<T>();
		
		boolean b1 = false;
		boolean b2 = false;
		
		
		while (true)
		{
			
			if (!this.empty())
			{
				newqueue.offer(this.poll());
				
				if (this.empty())
				{
					b1 = true;
				}
			}
			
			if (!queue.empty())
			{
				newqueue.offer(queue.poll());
				
				if (queue.empty())
				{
					b2 = true;
				}
			}
			
			if (b1 && b2)
				break;
		}
		
		while (!newqueue.empty())
		{
			this.offer(newqueue.poll());
		}
		return this;
		
	}
	
	public static void main(String[] args)
	{
		CQueue<String> test = new CQueue<String>();
		test.offer("One");
		test.offer("Two");
		test.offer("Three");
		test.offer("Four");
		test.offer("Five");
		
		//test.reverse();
		
		
		CQueue<String> test2 = new CQueue<String>();
		
		test2.offer("Six");
		test2.offer("Seven");
		test2.offer("Eight");
		
		//test.append(test2);
		
		test.alternate(test2);
		
		System.out.println(test.toString());
		
		/*while (!test.empty())
		{
			System.out.println(test.poll());
		}*/
	}


	
}
