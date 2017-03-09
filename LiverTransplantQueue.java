public class LiverTransplantQueue<E> implements PriorityQueue<E> {
	
	private CQueue<E> queue;
	public static void main(String[] args)
    {
            LiverTransplantQueue<Patient> pq= new LiverTransplantQueue<Patient>();
            pq.add(new Patient("Smith",3));
            pq.add(new Patient("Chen",2));
            pq.add(new Patient("Jones",3));
            pq.add(new Patient("Wong",3));
            pq.add(new Patient("Gupta",2));
            pq.add(new Patient("Garcia",1));
            pq.add(new Patient("Brown",3));
            System.out.println("The list is");
            System.out.println(pq);  
            while(pq.size()>0)
            {
                        System.out.println("The next patient for the liver transplant is");
                        System.out.println(pq.poll());
         }

    }
	
	public LiverTransplantQueue()
	{
		queue = new CQueue<>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.empty();
	}

	@Override
	public void add(E x) {
		//queue.offer(x);
		
		//sort 
		
		/*queue.sort((Comparator<? super E>) new Comparator<Patient>() {
			@Override
			public int compare(Patient arg0, Patient arg1) {
				
				return arg1.priority > arg0.priority ? 1 : -1;
			}
        });*/
		
		if (size() == 0)
		{
			queue.offer(x);
			return;
		}
		
		if (size() == 1)
		{
			if (((Patient)queue.get(0)).priority >= ((Patient)x).priority)
			{
				queue.offer(x);
			}
			else
			{
				queue.insert(x, 0);
			}
			
			return;
		}
		
		boolean added = false;
		for (int i = 0; i < queue.size(); ++i)
		{
			if (((Patient)queue.get(i)).priority < ((Patient)x).priority)
			{
				queue.insert(x, i);
				added = true;
				break;
			}
			
			if (((Patient)queue.get(i)).priority == ((Patient)x).priority)
			{
				//System.out.println("case");
				int j = i + 1;
				for (; j < queue.size() && ((Patient)queue.get(j)).priority == ((Patient)queue.get(i)).priority; ++j)
				{
					
				}
				
				i = j;
				
				queue.insert(x, i);
				added = true;
				break;
			}
		}
		
		if (!added)
		{
			queue.offer(x);
		}
		
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return queue.poll();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return queue.peek();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}
	
	public String toString()
	{
		return queue.toString();
	}
}


