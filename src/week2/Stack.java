package week2;
public class Stack {
	public static void main(String[] args) {
		String data = "{()}{}";
		Stack a=new Stack();
		System.out.print(a.isBalanced(data));
	}

	boolean isBalanced(String data) {

		String openparanthesis="[{(";
		String closedparanthesis="]})";
		int size= data.length();

		Stackkk stk=new Stackkk(size);

		for(int i=0; i<size;i++) { 
			char paranthesis = data.charAt(i);
			if(openparanthesis.indexOf(paranthesis)!=-1) 
			{
				stk.push(paranthesis);
				System.out.println(data);
			}
			else
			{
				int index=closedparanthesis.indexOf(paranthesis);
				char opening=openparanthesis.charAt(index);
				if(stk.pop()!=opening) {
					return false;
				}
			}
		}
 
		if(stk.peak()==-1) {
			return true;
		}
		else{return false;}

	}

}