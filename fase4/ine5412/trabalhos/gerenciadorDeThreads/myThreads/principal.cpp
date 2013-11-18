/*
 * main.cpp
 *
 *  Created on: Oct 25, 2011
 *      Author: chrystian
 */

#include <iostream>
#include <cstdio>
using namespace std;

#include "MyThreads.h"

void thread1() {
	cout << "thread 1 method" << endl;
	for (int i = 0; i < 10; i++) {
		cout << i << " :::: thread 1 method" << endl;
		usleep(100);
	}
	MT_exit(0);
}

void thread2() {
	cout << "thread 2 method" << endl;
	for (int i = 0; i < 8; i++) {
		cout << i << " :::: thread 2 method" << endl;
		usleep(100);
	}
	MT_exit(0);
}

int main() {

	MT_init();
	MT_create(&thread1, 1, NORMAL_PRIORITY);
	sleep(1);
	MT_create(&thread2, 1, NORMAL_PRIORITY);

	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();
	MT_yield();

	int tid;
	tid = MT_gettid();

	cout << tid << endl;

	return 0;
}
