public class hiloThread extends Thread{
    private String word;

    public  hiloThread(String s){
        this.word = s;
    }

    public void run(){
        for (int i=0;i<3000;i++){
            System.out.print(this.word);
            System.out.flush();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Thread h1 = new Thread(new hiloThread("P"));
        Thread h2 = new Thread(new hiloThread("P"));
        h1.start();
        h2.start();
    }
}
