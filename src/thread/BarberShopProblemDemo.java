package thread;
import java.util.HashSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShopProblemDemo {
    public static void main( String args[] ) throws InterruptedException {
        BarberShopProblem.runTest();
    }
}

class BarberShopProblem {

    final int CHAIRS = 3;
    Semaphore waitForCustomerToEnter = new Semaphore(0);
    Semaphore waitForBarberToGetReady = new Semaphore(0);
    Semaphore waitForCustomerToLeave = new Semaphore(0);
    Semaphore waitForBarberToCutHair = new Semaphore(0);
    int waitingCustomers = 0;
    ReentrantLock lock = new ReentrantLock();
    int hairCutsGiven = 0;

    void customerWalksIn() throws InterruptedException {

        lock.lock();
        if (waitingCustomers == CHAIRS) {
            System.out.println("Customer walks out, all chairs occupied");
            lock.unlock();
            return;
        }
        waitingCustomers++;
        lock.unlock();

        // Let the barber know, there's atleast 1 customer
        waitForCustomerToEnter.release();
        // Wait for barber to greet you and lead you to barber chair
        waitForBarberToGetReady.acquire();

        lock.lock();
        waitingCustomers--;
        lock.unlock();

        // Wait for haircut to complete
        waitForBarberToCutHair.acquire();

        // Leave the barber chair and let barber thread know chair is vacant
        waitForCustomerToLeave.release();


    }

    void barber() throws InterruptedException {

        while (true) {
            // wait till a customer enters a shop
            waitForCustomerToEnter.acquire();
            // let the customer know barber is ready
            waitForBarberToGetReady.release();
            hairCutsGiven++;
            System.out.println("Barber cutting hair..." + hairCutsGiven);
            Thread.sleep(50);
            // let customer thread know, haircut is done
            waitForBarberToCutHair.release();
            // wait for customer to leave the barber chair
            waitForCustomerToLeave.acquire();
        }
    }

    public static void runTest() throws InterruptedException {

        HashSet<Thread> set = new HashSet<Thread>();
        final BarberShopProblem barberShopProblem = new BarberShopProblem();

        Thread barberThread = new Thread(new Runnable() {
            public void run() {
                try {
                    barberShopProblem.barber();
                } catch (InterruptedException ie) {

                }
            }
        });
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        barberShopProblem.customerWalksIn();
                    } catch (InterruptedException ie) {

                    }
                }
            });
            set.add(t);
        }

        for (Thread t : set) {
            t.start();
        }

        for (Thread t : set) {
            t.join();
        }

        set.clear();
        Thread.sleep(800);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        barberShopProblem.customerWalksIn();
                    } catch (InterruptedException ie) {

                    }
                }
            });
            set.add(t);
        }
        for (Thread t : set) {
            t.start();
        }

        barberThread.join();
    }
}