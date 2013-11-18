/*
 * MyThreads.cpp
 *
 *  Created on: Oct 25, 2011
 *      Author: chrystian
 */

#include "MyThreads.h"

typedef struct thread {

	ucontext_t context;
	int tid;
	int priority;
	bool waiting;
	int tidWaiting;

} thread_t;

queue<thread_t*> threads;
thread_t * currentThread;
thread_t * parent;
int lastTid;
int numberOfThreads;

int MT_init() {

	lastTid = 0;
	numberOfThreads = 0;

	parent = (thread_t*) malloc(sizeof(thread_t));
	threads.push(parent);
	currentThread = parent;

	ualarm(100, 100);

	return 0;

}

int MT_create(void(*func)(void), int arg, int pri) {
	signal(SIGALRM, (__sighandler_t) MT_yield);

	if (numberOfThreads == MAX_THREADS) {
		return -1;
	}

	thread_t * thread;
	thread = (thread_t*) malloc(sizeof(thread_t));

	getcontext(&thread->context);
	thread->context.uc_link = 0;
	thread->context.uc_stack.ss_flags = 0;
	thread->context.uc_stack.ss_size = STACK_SIZE;
	thread->context.uc_stack.ss_sp = malloc(STACK_SIZE);

	if (thread->context.uc_stack.ss_sp == 0) {
		return -1;
	}

	thread->priority = pri;
	thread->tid = ++lastTid;

	threads.push(thread);
	makecontext(&thread->context, func, 1);

	currentThread = threads.front();
	numberOfThreads++;

	cout << "n of threads: " << numberOfThreads << endl;
	MT_yield();

	return thread->tid;

}

int MT_join(int idt, int *result) {
	currentThread->waiting = true;
	currentThread->tidWaiting = idt;
	return 0;

}

void MT_exit(int status) {

	thread_t * pastThread = threads.front();
	threads.pop();
	numberOfThreads--;
	currentThread = threads.front();
	thread_t * thread_verif;
	for (unsigned int i = 0; i < threads.size(); i++) {
		thread_verif = threads.front();
		if (thread_verif->tidWaiting == pastThread->tid)
			thread_verif->waiting = false;
		threads.pop();
		threads.push(thread_verif);
	}
	swapcontext(&pastThread->context, &currentThread->context);

}

void MT_yield() {

	thread_t * pastThread = threads.front();
	threads.pop();
	threads.push(pastThread);
	currentThread = threads.front();
	while (currentThread->waiting == true) {
		pastThread = threads.front();
		threads.pop();
		threads.push(pastThread);
		currentThread = threads.front();
	}
	swapcontext(&pastThread->context, &currentThread->context);

}
int MT_gettid(void) {

	if (currentThread == 0)
		return -1;
	return currentThread->tid;

}
