package wffgenerator;

import java.util.*;

public class Generator
{
	public static boolean hasNext(String s)
	{
		if (s.matches(".*w.*"))
			return true;
		else
			return false;

	}

	public static void display(ArrayList<String> array)
	{
		for (int i = 0; i < array.size(); i = i + 4)
		{
			System.out.printf("%s\t%s\t%s\t%s\n", array.get(i), array.get(i + 1), array.get(i + 2), array.get(i + 3));
		}
	}

	public static boolean filter(String tmp)
	{
		boolean as = false, bs = false;
		char[] charArray = tmp.toCharArray();
		for (char c : charArray)
		{
			if (c == 'A')
				as = true;
			if (c == 'B')
			{
				bs = true;
				if (!as)
					return false;
			}
			if (c == 'C')
			{
				if (!as || !bs)
					return false;
			}
		}
		return true;
	}

	public static void main(String args[])
	{
		String str = "w";
		Queue<String> queue = new LinkedList<String>();
		ArrayList<String> array = new ArrayList<String>();
		queue.add(str);

		while (array.size() != 1000)
		{
			String tmp;
			if (hasNext(queue.peek()))
			{
				queue.add(queue.peek().replaceFirst("w", "T"));
				queue.add(queue.peek().replaceFirst("w", "F"));
				queue.add(queue.peek().replaceFirst("w", "A"));
				queue.add(queue.peek().replaceFirst("w", "B"));
				queue.add(queue.peek().replaceFirst("w", "C"));
				queue.add(queue.peek().replaceFirst("w", "w>w"));
				queue.add(queue.peek().replaceFirst("w", "w&w"));
				queue.add(queue.peek().replaceFirst("w", "w+w"));
				queue.add(queue.peek().replaceFirst("w", "~w"));
				queue.add(queue.peek().replaceFirst("w", "(w)"));
				queue.remove();
			} else
			{
				tmp = queue.peek();
				if (filter(tmp))
				{
					array.add(queue.peek());
					queue.remove();
				}
				else
				queue.remove();
			}
		}
		display(array);
		// System.out.println(array.toString());
	}

}
