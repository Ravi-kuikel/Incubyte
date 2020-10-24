public class StringCalculator
{
	public int Add(String numbers)
	{
		if (numbers.isEmpty())
		{
			return 0;
		}
		String delimiter=",";
		int sum=0;
		String number="";
		if(numbers.matches("//(.*)\n(.*)"))
		{
			int k;
			delimiter="";
			if (numbers.charAt(2)=='[')
			{
				for(k=numbers.indexOf('\n')+1;k<numbers.length();k++)
				{
					if( Character.isDigit(numbers.charAt(k)) || numbers.charAt(k)=='\n'|| numbers.charAt(k)=='-')
						
					{
						number=number+numbers.charAt(k);
						
					}
					else
					{
						int l;
						for(l=k+1;l<numbers.length();l++)
						{
							if( Character.isDigit(numbers.charAt(l)) || numbers.charAt(l)=='\n'|| numbers.charAt(l)=='-')
								
							{
								break;
								
							}
							
							
							
						}
						number=number+',';
						k=l-1;
					}
				}
				delimiter=",";
				numbers = number;
			}
			else
			{
				delimiter=delimiter+numbers.charAt(2);
				numbers = numbers.substring(4);
			}
			
			
			
		}
		
		numbers=numbers+delimiter;
		int l=numbers.length();
		int count=0;
		char ch;
		int i;
		String no="";
		String negative="";
		
		for( i=0;i<l;i++)
		{	
			ch=numbers.charAt(i);
			if (ch!=delimiter.charAt(0)&&ch!='\n')
			{
				if (ch=='-')
				{
					count=1;
					int j;
					for(j=i;numbers.charAt(j)!=delimiter.charAt(0);j++)
					{
						
						negative=negative+numbers.charAt(j);
						System.out.println(negative);
					}
					i=j+delimiter.length()-1;
					
				}
				else
				{
				no=no+ch;
				i=i+delimiter.length()-1;
				}
				
			}
			else
			{
				if (Integer.parseInt(no)<=1000)
				{
				System.out.println(no);
				sum=sum+Integer.parseInt(no);
				}
				no="";
		    }
			
			
			
		}
		if (count==0)
		{
			System.out.println(sum);
			return sum;
		}
		else
		{
			throw new IllegalArgumentException("negatives not allowed" + negative);
			
			
		}
	}
}