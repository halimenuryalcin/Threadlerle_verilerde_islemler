package yazlab1_2;
class WorkerThread implements Runnable {  
	static String file="C:\\\\Users\\\\nurre\\\\PycharmProjects\\\\yazlab1_2\\\\DATA\\";
	private String ff;
    public WorkerThread(String file){  
         this.ff=file;
    }  
    CSVReader3 task=new CSVReader3();
     @SuppressWarnings("static-access")
	public void run() {  
    	task.similarity("Product",(float)12.50);
 		//task.senaryo3("Issue",(double)70.0);
 		task.senaryo2("3238275",12.5, "Issue");
        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
    }  
    private void processmessage() {  
        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}  