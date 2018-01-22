/*
线程间通讯：
其实就是多个线程在操作同一个资源
但是操作的动作不同。
*/
class Res
{
	String name;
	String sex;
}

class Input implements Runnable
{
	private Res r;
	Input(Res r)
	{
		this.r =r;
	}
	public void run()
	{
		int x = 0;
		while (true)
		{
			synchronized(r)
			{
				if(x==0)
				{
					r.name="漫莉";
					r.sex="女";
				}else
				{
					r.name="menmo";
					r.sex = "male";
				}
				x = (x+1)%2;
			}
		}
	}
}

class Output implements Runnable
{
	private Res r;
	Output(Res r)
	{
		this.r =r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				System.out.println(r.name+"---"+r.sex);
			}
		}
	}
}
class InputOutputDemo
{
	public static void main(String[] args) 
	{
		Res r = new Res();
		
		Input in = new Input(r);
		Output out = new Output(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}
