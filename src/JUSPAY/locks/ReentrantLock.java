package JUSPAY.locks;

public class ReentrantLock {

        private boolean isLocked = false;
        private Thread lockedBy = null;
        private int lockedCount = 0;

        public synchronized void lock() throws InterruptedException {
            Thread currentThread = Thread.currentThread();
            while (isLocked && lockedBy != currentThread) {
                wait();
            }
            isLocked = true;
            lockedBy = currentThread;
            lockedCount++;
        }

        public synchronized void unlock() {
            if (Thread.currentThread() == lockedBy) {
                lockedCount--;
                if (lockedCount == 0) {
                    isLocked = false;
                    lockedBy = null;
                    notify();
                }
            }
        }

    static class SharedResource{
        private boolean availabel = true;

        public void producer(ReentrantLock lock){
            try {
                lock.lock();
                System.out.println("lock acquired by: " + Thread.currentThread().getName());
                availabel = false;
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
                System.out.println("lock released by :" + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lok = new ReentrantLock();

        SharedResource obj1 = new SharedResource();
        SharedResource obj2 = new SharedResource();

        Thread th1 = new Thread(()->{
                obj1.producer(lok);
        });

        Thread th2 = new Thread(()->{
            obj2.producer(lok);
        });

        th1.start();
        th2.start();

    }
}
