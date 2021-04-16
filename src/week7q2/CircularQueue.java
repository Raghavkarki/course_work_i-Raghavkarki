package week7q2;

public class CircularQueue {
	
	int queue[]= new int[6];
	int rear;
	int front;
	int size;
	
		
		public static void main(String[] args) {
			CircularQueue soft= new CircularQueue();
			soft.enqueue(20);
			soft.enqueue(40);
			soft.enqueue(50);
			soft.enqueue(70);
			soft.enqueue(80);
			soft.enqueue(90);
			soft.dequeue();
			soft.display();
		}

	
	
	
	
	public void enqueue( int value) {
		if(!isFull()) {
			queue[rear]=value;
			rear=(rear+1)%6;
			size=size+1;
			
		}else {
			System.out.println("Queue is full");
		}
		
		
		
	}
	
	public void dequeue() {
		if(!isEmpty()) {
			front=(front+1)%6;
			size=size-1;
			
		}else {
			System.out.println("Queue is empty");
			
		}
		
	
	}
	public boolean isEmpty() {
		return size==0;
		
		
	}
	
	public boolean isFull() {
		return size==6;
	}
	public void display() {
		System.out.println("Rear "+ rear);
		System.out.println("Front "+ front);
		System.out.println("Size "+ size);
		System.out.println("Element in queue");
		for(int i=0;i<size;i++) {
			System.out.println(queue[(front+i)%6] + "");
		}
		System.out.println("Actual Array::");
		for(int i:queue) {
			System.out.println(i +" ");
		}
	}

}