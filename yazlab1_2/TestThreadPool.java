package yazlab1_2;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class TestThreadPool {  
    static ExecutorService executor = Executors.newFixedThreadPool(10);//creating a pool of 10 threads  
    static long nanos;
    public static void main(String[] args) {  
       threadNumber(10);
   }  
    static long nanos2;
   public static void threadNumber(int number)
   {
	   for(int i=0;i<number;i++)
	   {
		   Runnable worker = new WorkerThread("" + i);  
           executor.execute(worker);//calling execute method of ExecutorService  
            nanos = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
            nanos2+=nanos;
            
	   }
       
       executor.shutdown();  
       while (!executor.isTerminated()) {   }  
       double sure=nanos*1.66666667*0.00000000001;
       double sure2=nanos2*1.66666667*0.00000000001;

       System.out.println("Finished all threads "+number+"adet thread kullanildi"+"sure:"+new DecimalFormat("##.##").format(sure)+"dk");  
       System.out.println("toplam sure:"+new DecimalFormat("##.##").format(sure2)+"dk");
   }
}  
