package thread;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophersDemo {
    public static void main(String args[]) throws InterruptedException {
        DiningPhilosophers.runTest();
    }
}


class DiningPhilosophers {

    private static Random random = new Random(System.currentTimeMillis());

    private Semaphore[] forks = new Semaphore[5];
    private Semaphore maxDiners = new Semaphore(4);

    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    static void startPhilosoper(DiningPhilosophers dp, int id) {
        try {
            dp.lifecycleOfPhilosopher(id);
        } catch (InterruptedException ie) {

        }
    }

    public static void runTest() throws InterruptedException {
        final DiningPhilosophers dp = new DiningPhilosophers();

        Thread p1 = new Thread(new Runnable() {

            public void run() {
                startPhilosoper(dp, 0);
            }
        });

        Thread p2 = new Thread(new Runnable() {

            public void run() {
                startPhilosoper(dp, 1);
            }
        });

        Thread p3 = new Thread(new Runnable() {

            public void run() {
                startPhilosoper(dp, 2);
            }
        });

        Thread p4 = new Thread(new Runnable() {

            public void run() {
                startPhilosoper(dp, 3);
            }
        });

        Thread p5 = new Thread(new Runnable() {

            public void run() {
                startPhilosoper(dp, 4);
            }
        });

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
    }

    public void lifecycleOfPhilosopher(int id) throws InterruptedException {

        while (true) {
            contemplate();
            eat(id);
        }
    }

    void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(50));
    }

    void eat(int id) throws InterruptedException {
        maxDiners.acquire();

        forks[id].acquire();
        forks[(id + 1) % 5].acquire();
        System.out.println("Philosopher " + id + " is eating");
        forks[id].release();
        forks[(id + 1) % 5].release();

        maxDiners.release();
    }

//    void eat(int id) throws InterruptedException {
//
//        // We randomly selected the philosopher with
//        // id 3 as left-handed. All others must be
//        // right-handed to avoid a deadlock.
//        if (id == 3) {
//            acquireForkLeftHanded(3);
//        } else {
//            acquireForkForRightHanded(id);
//        }
//
//        System.out.println("Philosopher " + id + " is eating");
//        forks[id].release();
//        forks[(id + 1) % 5].release();
//    }

    void acquireForkForRightHanded(int id) throws InterruptedException {
        forks[id].acquire();
        forks[(id + 1) % 5].acquire();
    }

    // Left-handed philosopher picks the left fork first and then
    // the right one.
    void acquireForkLeftHanded(int id) throws InterruptedException {
        forks[(id + 1) % 5].acquire();
        forks[id].acquire();
    }
}