/*
yield: 
����:��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�ʹ��ﵽ����߳̾��⽻��ִ�е�Ч����

Thread.yield();
*/
class ThreadTest
{
	public static void main(String[] args) 
	{
		new Thread()//�����ڲ������
		{
			public void run()
			{
				for (int x=0; x<70; x++)
				{
					System.out.println(Thread.currentThread().getName()+"..."+x);
				}
			}
		}.start();

		for (int x=0; x<100; x++)
		{
			System.out.println(Thread.currentThread().getName()+"...."+x);
		}

		Runnable r = new Runnable()
		{
			public void run()
			{
				for (int x=0; x<100; x++)
				{
					System.out.println(Thread.currentThread().getName()+"..."+x);
				}
			}
		};
		new Thread(r).start();
	}
}
