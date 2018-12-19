import java.util.Random;
import java.util.concurrent.Semaphore;

public class Examen extends Thread {

	int id;
	static int Anum[] = new int[10];
	static Examen examen[];

	static Semaphore semaforo = new Semaphore(1);

	Examen(int id) {
		this.id = id;
		for (int i = 0; i < 10; i++) {
			Anum[i] = 0;
		}
	}

	public void run() {
		int num = 0;
		Random rand = new Random();

		try {
				semaforo.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int i = 0; i < 50; i++) {
			
			num = rand.nextInt(100);
			if (num < 10) {
				Anum[0] = Anum[0]+1;
			} else {
				if (num < 20) {
					Anum[1] = Anum[1] + 1;
				} else {
					if (num < 30) {
						Anum[2] = Anum[2] + 1;
					} else {
						if (num < 40) {
							Anum[3] = Anum[3] + 1;
						} else {
							if (num < 50) {
								Anum[4] = Anum[4] + 1;
							} else {
								if (num < 60) {
									Anum[5] = Anum[5] + 1;
								} else {
									if (num < 70) {
										Anum[6] = Anum[6] + 1;
									} else {
										if (num < 80) {
											Anum[7] = Anum[7] + 1;
										} else {
											if (num < 90) {
												Anum[8] = Anum[8] + 1;
											} else {
												if (num < 100) {
													Anum[9] = Anum[9] + 1;

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

		}
		semaforo.release();
	}

	public static void main(String args[]) {
		int tot = 0;
		examen = new Examen[5];
		for (int i = 0; i < 4; i++) {
			examen[i] = new Examen(i);
			examen[i].start();
		}
		for (int i = 0; i < 4; i++) {
			try {
				examen[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(Anum[i] + " " + i);

			tot = Anum[i] + tot;
		}
		System.out.println(tot);
	}
}
